package tje.servlets.jdbc;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member_login")
public class MemeberLoginServlet extends HttpServlet {
	
	private static final String formPage = "/WEB-INF/forms/loginForm.html";
	private static final String errorPage = "/WEB-INF/errors/loginError.html";
	
	private static String jdbc_url;
	private static String jdbc_id;
	private static String jdbc_password;

	public void init(ServletConfig config) throws ServletException {
		ServletContext application = config.getServletContext();
		jdbc_url = application.getInitParameter("JDBC_URL");
		jdbc_id = application.getInitParameter("JDBC_ID");
		jdbc_password = application.getInitParameter("JDBC_PASSWORD");
		
		// System.out.println(jdbc_url);
		
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		boolean isLogin = false;
		if( session != null && session.getAttribute("login_id") != null )
			isLogin = true;
		
		String forwardPage = formPage;
		
		if( isLogin ) {
			forwardPage = errorPage;
			/*
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder html = new StringBuilder();
			html.append("<h3>이미 로그인되어 있습니다.</h3>");			
			html.append(
				String.format(
					"<p><a href='%s'>메인화면으로 이동</a></p>", 
					request.getContextPath() + "/member_main"));
			out.println(html);
			out.flush();
			return;
			*/
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		
		// 로그인 성공 여부의 값을 저장하는 변수
		boolean isLogin = false;
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
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
		
		// 로그인 여부에 따라 작업
		StringBuilder html = new StringBuilder();
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
			
			html.append("<h3>로그인에 성공했습니다</h3>");			
		} else {
			html.append("<h3>로그인에 실패했습니다</h3>");	
			html.append("<h4>아이디와 패스워드를 확인하세요</h4>");
		}
		
		
		html.append(
			String.format(
				"<p><a href='%s'>메인화면으로 이동</a></p>", 
				request.getContextPath() + "/member_main"));
		out.println(html);
	}

}

