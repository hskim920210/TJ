package khs.jdbc.listener;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInitListener implements ServletContextListener {

	// 웹 서버의 시작 시, 자동 호출되는 메소드
	public void contextInitialized(ServletContextEvent sce) {
		String poolConfig = 
				sce.getServletContext().getInitParameter("POOL_CONFIG");
		
		// =을 기준으로 키와 밸류로 나눈다.
		Properties prop = new Properties();
		try {
			// poolConfig에 담긴걸 그대로 prop에 load
			prop.load(new StringReader(poolConfig));
		} catch (IOException e) {
			// 런타임 익셉션 나오게하고 끝내라
			throw new RuntimeException("config load fail", e);
		}
		loadJDBCDriver(prop);
		initConnectionPool(prop);
	}

	private void loadJDBCDriver(Properties prop) {
		// 키가 JDBC_DRIVER인 밸류를 꺼내와서 driverClass에 대입
		String driverClass = prop.getProperty("JDBC_DRIVER");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	// 커넥션 풀을 만들어주는 메소드.
	private void initConnectionPool(Properties prop) {
		try {
			String url = prop.getProperty("JDBC_URL");
			String user = prop.getProperty("JDBC_USER");
			String password = prop.getProperty("JDBC_PASSWORD");

			// ConnectionFactory : 입력된 url, user, password 정보를 사용하여
			// 						모자랄 때 알아서 커넥션을 생산할 수 있는 클래스.
			//						(커넥션을 만들 수 있는 공장)
			ConnectionFactory connFactory = 
					// 커넥션 풀을 만들어주기 위한 클래스
					// apache-comons-dbcp2 패키지에서 제공
					new DriverManagerConnectionFactory(url, user, password);

			// 풀에 넣어줄 커넥션을 생산하는 공장
			// PoolableConnectionFactory : 커넥션 풀에 DB 커넥션 객체를 추가할 수 있는 클래스
			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			
			// 현재 만들어져있는 커넥션이 잘 연결되어있는지 감시하기 위한 쿼리.
			// 의미는 없지만 쿼리가 잘 수행되면 커넥션이 잘 수행되고 있는 것.
			// 커넥션의 유효성을 확인하기 위한 쿼리 지정 (커넥션이 하나 만들어질 때마다 확인)
			String validationQuery = prop.getProperty("VALIDATION_QUERY");
			if (validationQuery != null && !validationQuery.isEmpty()) {
				poolableConnFactory.setValidationQuery(validationQuery);
			}
			// 커넥션이 저장될 풀에 관한 속성을 지정하는 클래스.
			// GenericObjectPoolConfig : POOL 내부에 저장된 객체들을 관리하기 위한 설정을 제공하는 클래스
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			// 풀 내부의 객체를 소멸시키기 위한 동작의 주기를 설정
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			// 풀 내부의 객체를 소멸시킬 때 유효성을 검증하는 과정의 실행 여부
			// close를 부를 때 한번 확인. 잘 살아있을 때 close를 해야하니까
			// 위에서 validationQuery로 유효성 검사 해서 딱히 지금은 없어도 살아있다는게 보장된다.
			poolConfig.setTestWhileIdle(true);
			int minIdle = getIntProperty(prop, "MIN_IDLE", 5);
			// 풀 내부에 저장할 객체의 최솟값(기본 커넥션 개수)
			// 기본적으로 커넥션 객체 MIN_IDLE 개를 만들어주고 시작하겠다.
			poolConfig.setMinIdle(minIdle);
			int maxTotal = getIntProperty(prop, "MAX_TOTAL", 50);
			// 풀로부터 생성될 수 있는 최댓값 ( 특정 시점에 한정 )
			// 사용자가 급증할 때 순간적으로 풀의 객체를 만들 때 최대로 만들 수 있는 갯수.
			poolConfig.setMaxTotal(maxTotal);

			// 실제 풀 객체 클래스.
			// DB 커넥션을 저장할 풀 객체 생성
			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			// 생성되는 커넥션들을 저장하기 위한 풀을 설정
			poolableConnFactory.setPool(connectionPool);
			
			// DBCP 드라이버 클래스 로딩
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			// DBCP 드라이버 클래스의 객체 반환
			PoolingDriver driver = (PoolingDriver)
				DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = prop.getProperty("POOL_NAME");
			// DBCP 풀을 등록(사용자가 지정한 이름으로 등록함)
			driver.registerPool(poolName, connectionPool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private int getIntProperty(Properties prop, String propName, int defaultValue) {
		String value = prop.getProperty(propName);
		if (value == null) return defaultValue;
		return Integer.parseInt(value);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
