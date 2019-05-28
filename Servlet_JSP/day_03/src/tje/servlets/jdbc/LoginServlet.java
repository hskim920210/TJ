package tje.servlets.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	private static final String jdbc_url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	private static final String jdbc_id = "root";
	private static final String jdbc_password = "SystemManager304";
	private static final String formPage = "/WEB-INF/forms/loginForm.html";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("login_id");
		String name = (String)session.getAttribute("login_name");
		
		if( id != null) {
			// id가 세션에 있는경우
			response.setContentType("text/html;charset=utf-8");
			java.io.PrintWriter out = response.getWriter();
			out.println("<h3>" + name + " 님은 로그인 상태입니다.</h3>");
			out.println("<input type = \"button\" value = \"로그아웃\" onclick = \"location.href='./logout'\">");
			out.flush();
			// 페이지 포워딩이 일어나지 않도록
			return;
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String strId = request.getParameter("id").trim();
		String strPassword = request.getParameter("password").trim();
		
		try {
			// 웹 어플리케이션에서 JDBC를 활용하는 경우
			// buildpath에 라이브러리(jar)를 등록하는 것이 아니라
			// WebContent -> WEB-INF -> lib 디렉토리에 jar파일을 위치시켜야 한다.
			Class.forName(jdbc_driver);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
		}
		
		// 누가 로그인 했는지 정보를 저장
		String name = null;
		try {
			Connection conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String sql = "select name from member where id = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, strId);
			pstmt.setString(2, strPassword);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
			
			rs.close();
			pstmt.close();
			conn.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		
		
		if( name == null ) {
			// 로그인 실패
			out.println("<h2>로그인 실패</h2>");
			out.println("<h4>입력된 정보를 확인하세요.</h4>");
		} else {
			// 로그인 성공
			out.println("<h2>로그인 성공</h2>");
			out.println("<h4>" + name + " 님 환영합니다.</h4>");
			
			HttpSession session = request.getSession();
			session.setAttribute("login_id", strId);
			session.setAttribute("login_name", name);
			
		}
	}
}