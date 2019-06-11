package tje.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginService extends Service {
	private String formPage = "/WEB-INF/forms/loginForm.jsp";
	private String submitPage = "/WEB-INF/submits/login.jsp";
	private String errorPage = "/WEB-INF/errors/loginError.html";
		
	private String jdbc_url;
	private String jdbc_id;
	private String jdbc_password;
	
	public LoginService() {
		super();
	}

	public LoginService(ServletConfig config) {
	}
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		boolean isLogin = false;
		if( session != null && session.getAttribute("login_id") != null )
			isLogin = true;
		
		
		if( isLogin ) {
			return errorPage;
		}
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		
		boolean isLogin = false;
		ServletContext context = request.getServletContext();
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(context.getInitParameter("JDBC_URL")
			, context.getInitParameter("JDBC_ID"), context.getInitParameter("JDBC_PASSWORD"));
			String query = "select * from member where id = ? and password = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if( rs.next() )
				isLogin = true;
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
		
		request.setAttribute("isLogin", isLogin);
		
		if( isLogin ) {
			// 현재 로그인된 사용자의 아이디를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("login_id", id);
			// 현재 웹 서버(서블릿 컨테이너)에 로그인된 사용자의 수를 증가
			ServletContext application = request.getServletContext();
			
			synchronized (application) {
				if( application.getAttribute("login_member_count") == null )
					application.setAttribute("login_member_count", 1);
				else {
					Integer count = (Integer)application.getAttribute("login_member_count");
					application.setAttribute("login_member_count", count+1);
				}
			}
		}
		return submitPage;
	}
	
	
}














