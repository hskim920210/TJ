package tje.jdbc.util;

import java.sql.*;

public class JDBCConnection {
	
	static {
		JDBCDriverLoader.init();
	}

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(JDBCConstraints.JDBC_URL, JDBCConstraints.JDBC_USER, JDBCConstraints.JDBC_PASSWORD);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return conn;
	}	
	
}
