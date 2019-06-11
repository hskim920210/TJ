package tje.service;

import java.io.IOException;
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

public class LogoutService extends Service {
	private static final String formPage = "/WEB-INF/auth/logoutForm.jsp";	
	private static final String mainPage = "/WEB-INF/forms/main.jsp";
			
	public LogoutService() {
		super();
	}

	public LogoutService(ServletConfig config) {
	}
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		String id = (String)session.getAttribute("login_id");
		String name = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ServletContext context = request.getServletContext();
		try {
			conn = DriverManager.getConnection(context.getInitParameter("JDBC_URL")
					, context.getInitParameter("JDBC_ID"), context.getInitParameter("JDBC_PASSWORD"));
			String query = "select * from member where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if( rs.next() )
				// 세션에 저장된 아이디의 이름을 추출하는 코드
				name = rs.getString("name");
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
		
		// 현재 페이지에서 사용할 정보를 영역객체게 저장
		request.setAttribute("name", name);
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		//세션을 제거하여 로그인 정보를 무효화
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 사용자가 로그아웃 되었기 때문에
		// 현재 접속된 사용자의 수를 1 감소
		ServletContext application = request.getServletContext();
		
		synchronized (application) {
			if( application.getAttribute("login_member_count") == null )
				application.setAttribute("login_member_count", 0);
			else {
				Integer count = (Integer)application.getAttribute("login_member_count");
				application.setAttribute("login_member_count", count-1);
			}
		}	
		try {
			response.sendRedirect(request.getContextPath() + "/main.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}














