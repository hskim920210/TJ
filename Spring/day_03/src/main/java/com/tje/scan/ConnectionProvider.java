package com.tje.scan;

import java.sql.*;

import org.springframework.stereotype.Component;

@Component
public class ConnectionProvider {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/di?serverTimezone=UTC";
	private String user = "root";
	private String password = "SystemManager304";
	
	public ConnectionProvider() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public Connection getConnection() {
		Connection conn = null;
		
		// 풀로부터 커넥션을 가져올 수 있는 코드
		// DBCP 커넥션 풀로부터 커넥션 객체를 추출하는 코드
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
