package com.tje.dbcp;

import java.sql.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@Component
public class DBCPInitBean implements InitializingBean {
	
	@Resource(name="map")
	private HashMap<String, String> map;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet 메소드 실행");
		loadJDBCDriver();
		initConnectionPool();
	}
	
	// 스프링 컨테이너가 생성될 때, 자동으로 실행되는 메소드
	public void init() {
		System.out.println("init 메소드 실행");
		loadJDBCDriver();
		initConnectionPool();
	}
	
	private void loadJDBCDriver() {
		String driverClass = map.get("JDBC_DRIVER");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}
	
	private void initConnectionPool() {
		try {
			String url = map.get("JDBC_URL");
			String user = map.get("JDBC_USER");
			String password = map.get("JDBC_PASSWORD");

			// ConnectionFactory : 입력된 url, user, password
			// 정보를 사용하여 커넥션을 생산할 수 있는 클래스
			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(
							url, user, password);

			// PoolableConnectionFactory : 커넥션 풀에 DB 커넥션 객체를
			// 추가할 수 있는 클래스			
			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			
			// 커넥션의 유효성을 확인하기 위한 쿼리 지정
			String validationQuery = map.get("VALIDATION_QUERY");
			if (validationQuery != null && !validationQuery.isEmpty()) {
				poolableConnFactory.setValidationQuery(validationQuery);
			}
			
			// GenericObjectPoolConfig : POOL 내부에 저장된
			// 객체들을 관리하기 위한 설정을 제공하는 클래스
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			// 풀 내부의 객체를 소멸시키기 위한 동작의 주기 
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			// 풀 내부의 객체를 소멸시킬 때 유효성을 검증하는 과정의 실행 여부
			poolConfig.setTestWhileIdle(true);
			int minIdle = getIntValue("MIN_IDEL", 5);
			// 풀 내부에 저장할 객체의 최소값(기본 커넥션 개수)
			poolConfig.setMinIdle(minIdle);
			int maxTotal = getIntValue("MAX_TOTAL", 50);
			// 풀로부터 생성될 수 있는 최대 값(특정 시점에 한정)
			poolConfig.setMaxTotal(maxTotal);

			// DB 커넥션을 저장할 풀 객체 생성
			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			// 생상되는 커넥션들을 저장하기 위한 풀을 설정
			poolableConnFactory.setPool(connectionPool);
			
			// DBCP 드라이버 클래스 로딩
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			// DBCP 드라이버 클래스의 객체 반환
			PoolingDriver driver = (PoolingDriver)
				DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = map.get("POOL_NAME");
			// DBCP 풀을 등록(사용자가 지정한 이름으로 등록함)
			driver.registerPool(poolName, connectionPool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private int getIntValue(String key, int defaultValue) {
		String value = map.get(key);
		if (value == null) return defaultValue;
		return Integer.parseInt(value);
	}
}
