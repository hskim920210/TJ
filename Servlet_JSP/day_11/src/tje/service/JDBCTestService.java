package tje.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import tje.jdbc.*;

public class JDBCTestService extends Service {
	private String formPage = null;
	private String submitPage = null;
			
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		Connection conn = JDBCConnection.getConnection();
		System.out.println("JDBC 커넥션 객체 생성");
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member");
			
			while( rs.next() ) {
				System.out.printf("ID : %s\n", rs.getString("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*
		try {
			conn.close();
			System.out.println("JDBC 커넥션 객체 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		JDBCCloser.close(rs);
		JDBCCloser.close(stmt);
		JDBCCloser.close(conn);
		System.out.println("JDBC 커넥션 객체 종료");
		return formPage;
	}
	
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return submitPage;
	}
	
	
}














