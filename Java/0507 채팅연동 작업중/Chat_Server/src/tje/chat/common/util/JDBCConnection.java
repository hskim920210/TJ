package tje.chat.common.util;

import java.sql.*;

// JDCB 드라이버 클래스를 로딩하고 DBMS를 생성, 예외처리 하는 객체
public class JDBCConnection {
	
	// 클래스 객체가 생성될때 단 한번 실행되며 드라이버로딩을 실행하는 부분
	static {
		JDBCDriverLoader.init();
	}
	
	// DBMS의 생성을 실행해주는 getConnection 메소드
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(JDBCConstraints.JDBC_URL,
												JDBCConstraints.JDBC_USER,
												JDBCConstraints.JDBC_PASSWORD);
			System.out.println("DBMS 생성 완료 !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
