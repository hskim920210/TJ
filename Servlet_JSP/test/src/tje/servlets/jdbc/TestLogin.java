package tje.servlets.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class TestLogin
 */
@WebServlet("/test_login")
public class TestLogin extends HttpServlet {
	// final 멤버는 생성자에서 초기화하거나 정의할때 초기화할수밖에 없다
	
	private static final String okPage = "/WEB-INF/forms/test_ok.jsp";
	private static final String noPage = "/WEB-INF/forms/test_no.jsp";
	private static final String logoutPage = "/WEB-INF/forms/test_logout.jsp";
	
	private static String jdbc_url;
	private static String jdbc_id;
	private static String jdbc_password;
	
	public void init(ServletConfig config) throws ServletException {
		// 최초에 서블릿이 만들어질 때 어플리케이션에 접근하여 web.xml에 설정한 변수에 접근할 수 있다.
		// config 는 request가 할 수 있는걸 다 가지고 있다. 설정에 관한 것들.
		ServletContext application = config.getServletContext();
		jdbc_url = application.getInitParameter("JDBC_URL");
		jdbc_id = application.getInitParameter("JDBC_ID");
		jdbc_password = application.getInitParameter("JDBC_PASSWORD");
		
		// System.out.println(jdbc_url);
		
		super.init(config);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		boolean loginOk = false;
		
		System.out.println(id);
		System.out.println(pw);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String query = "select * from member where id = ? and password = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginOk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		try {
			if( conn != null ) {conn.close();}
			if( pstmt != null ) {pstmt.close();}
			if( rs != null ) {rs.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(loginOk) {
			RequestDispatcher rd = request.getRequestDispatcher(okPage);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(noPage);
			rd.forward(request, response);
		}
	}

}
