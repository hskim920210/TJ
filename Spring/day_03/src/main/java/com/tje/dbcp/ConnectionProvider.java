package com.tje.dbcp;

import java.sql.*;

import org.springframework.stereotype.Component;

@Component
public class ConnectionProvider {
	
	public Connection getConnection() {
		Connection conn = null;
		
		// 풀로부터 커넥션을 가져올 수 있는 코드
		// DBCP 커넥션 풀로부터 커넥션 객체를 추출하는 코드
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:di");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
