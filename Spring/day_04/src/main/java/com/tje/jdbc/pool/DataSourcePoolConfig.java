package com.tje.jdbc.pool;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tje.jdbc.dao.MemberDAO;
import com.tje.services.TransactionTestService;

@Configuration
// 현재 자바 클래스에서 생성되는 DataSource를 통해 제공되는
// 커넥션 객체들에 대해서 트랜잭션을 처리할 수 있도록 설정하는 어노테이션
@EnableTransactionManagement
public class DataSourcePoolConfig {
	// 하단의 static 메소드인 properties에 의해 ${}로 properties에 정의된 값들을 가져올 수 있다.
	// 가져오는 법은 어노테이션 Value를 사용.
	@Value("${JDBC_DRIVER}")
	private String driver;
	@Value("${JDBC_URL}")
	private String url;
	@Value("${JDBC_USER}")
	private String user;
	@Value("${JDBC_PASSWORD}")
	private String password;
	@Value("${INIT_SIZE}")
	private int init_size;
	@Value("${MAX_ACTIVE}")
	private int max_active;
	
	// DataSource에 저장된 모든 커넥션 객체들을 트랜잭션으로 처리를 할 수 있도록
	// PlatformTransactionManager 객체를 생성
	// 현재 내가 만들고있는 모든 커넥션 풀(dataSource()에 의해)에 트랜잭션을 처리할 수 있도록 설정
	@Bean
	public PlatformTransactionManager transactionManager() {
		// dataSource() 에 의해 만들어진 모든 커넥션은 트랜잭션을 갖도록 설정한다.
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		// <context:property-placeholder location="classpath:/jdbc.properties"/> 와 같음 (XML의 - day_03의 resources의 dbcp.xml)
		// 이걸 클래스에서 지정하는 방법
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		config.setLocation(new ClassPathResource("jdbc.properties"));
		return config;
	}
	
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		// ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setDriverClassName(driver);
		// ds.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
		ds.setUrl(url);
		// ds.setUsername("root");
		ds.setUsername(user);
		// ds.setPassword("SystemManager304");
		ds.setPassword(password);
		// ds.setInitialSize(2);
		ds.setInitialSize(init_size);
		// ds.setMaxActive(10);
		ds.setMaxActive(max_active);
		return ds;
	}
	
	@Bean("memberDAO")
	public MemberDAO getMemberDAO() {
		return new MemberDAO(dataSource());
	}
	
	@Bean
	public TransactionTestService ttService() {
		return new TransactionTestService(getMemberDAO());
	}
}
