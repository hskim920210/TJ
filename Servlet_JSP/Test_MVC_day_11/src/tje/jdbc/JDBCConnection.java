package tje.jdbc;

import java.sql.*;

public class JDBCConnection {
private static JDBCInfo info;
	
	public static void setInfo(JDBCInfo info) {
		JDBCConnection.info = info;
	}
	
	public static Connection getConnection() {
		if( info == null ) {
			return null;
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(info.getUrl(), info.getUser(), info.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
