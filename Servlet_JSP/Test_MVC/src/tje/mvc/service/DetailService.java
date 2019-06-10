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

public class DetailService extends Service {
	private static final String formPage = "/WEB-INF/auth/detailForm.jsp";	
		
	private String jdbc_url;
	private String jdbc_id;
	private String jdbc_password;
			
	public DetailService(ServletConfig config) {
		ServletContext application = config.getServletContext();
		jdbc_url = application.getInitParameter("JDBC_URL");
		jdbc_id = application.getInitParameter("JDBC_ID");
		jdbc_password = application.getInitParameter("JDBC_PASSWORD");
	}
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		// 조회를 하고자 하는 멤버의 아이디값을 쿼리 스트링에 추출
		String id = request.getParameter("id");
		
		// 조회할 회원 정보를 저장할 객체 생성
		// (포워딩되는 JSP 파일에서 참조할 객체)
		Member member = null;
		
		// JDBC를 사용한 데이터베이스 처리
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
				// Member 테이블의 각 레코드를
				// 자바빈 객체로 변환
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
		return null;
	}
	
	
}














