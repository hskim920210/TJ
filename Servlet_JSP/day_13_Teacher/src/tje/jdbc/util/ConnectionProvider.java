package tje.jdbc.util;

import java.sql.*;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection conn = null;
		
		// DBCP 커넥션 풀로부터 커넥션 객체를 추출하는 코드
		try {
			conn = DriverManager.getConnection(
					"jdbc:apache:commons:dbcp:site");
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return conn;		 
	}
}
