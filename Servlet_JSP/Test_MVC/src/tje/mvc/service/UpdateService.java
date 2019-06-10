package tje.mvc.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tje.model.Member;

public class UpdateService extends Service {
	private static final String formPage = "/WEB-INF/auth/updateForm.jsp";	
	private static final String submitPage = "/WEB-INF/submits/updateSubmit.jsp";
		
	private String jdbc_url;
	private String jdbc_id;
	private String jdbc_password;
			
	public UpdateService(ServletConfig config) {
		ServletContext application = config.getServletContext();
		jdbc_url = application.getInitParameter("JDBC_URL");
		jdbc_id = application.getInitParameter("JDBC_ID");
		jdbc_password = application.getInitParameter("JDBC_PASSWORD");
	}
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		Member member = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String query = "select * from member where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				member = new Member(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if( conn != null ) conn.close();
			if( pstmt != null ) pstmt.close();
			if( rs != null ) rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("member", member);
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");	
		
		// 수정할 회원 정보를 저장할 객체 생성
		// (포워딩되는 JSP 파일에서 참조할 객체)
		Member member = new Member(id, password, name, age, tel, address);
		// 업데이트의 결과 값 저장 변수
		// (포워딩되는 JSP 파일에서 참조할 객체)
		Integer result = 0;
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String query = "update member set name = ?, age = ?, tel = ?, address = ? where id = ? and password = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			pstmt.setString(5, id);
			pstmt.setString(6, password);
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if( conn != null ) conn.close();
			if( pstmt != null ) pstmt.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("member", member);
		request.setAttribute("result", result);
		return submitPage;
	}
	
	
}














