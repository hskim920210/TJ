package tje.servlets.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member_login")
public class MemberLoginServlet extends HttpServlet {
	
	private static final String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	private static final String jdbc_url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	private static final String jdbc_id = "root";
	private static final String jdbc_password = "SystemManager304";
	private static final String formPage = "/WEB-INF/pages/loginPage.html";
	private static final String jspPage = "/MemberLoginJSP.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 쿠키 여부 확인
		Cookie [] cookies = request.getCookies();
		
//		String save_id = null;
//		for(int i = 0 ; cookies != null && i < cookies.length ; i++) {
//			if(cookies[i].getName().equals("save_id")) {
//				save_id = cookies[i].getValue();
//			}
//		} 
		
		if(cookies != null) {
			RequestDispatcher rd = request.getRequestDispatcher(jspPage);
			rd.forward(request, response);
		}

		
//		StringBuilder buffer = new StringBuilder();
//		buffer.append("<form action=\"./member_login\" method=\"post\">");
//		buffer.append("<table>");
//		buffer.append("<caption>로그인</caption>");
//		buffer.append("<tr>");
//		buffer.append("<th>ID</th>");
//		buffer.append("<th>PW</th>");
//		buffer.append("</tr>");
//		buffer.append("<tr>");
//		buffer.append("<td><input type=\"text\" name=\"id\" required></td>");
//		buffer.append("<td><input type=\"password\" name=\"password\" required></td>");
//		buffer.append("</tr>");
//		buffer.append("<tr>");
//		buffer.append("<th colspan=\"2\"><input type=\"submit\" value=\"로그인\"></th>");
//		buffer.append("</tr>");
//		buffer.append("<tr>");
//		buffer.append("<th colspan=\"2\"><label>아이디 저장<input type = \"checkbox\" name = \"save_id\"></label></th>");
//		buffer.append("</tr>");
//		buffer.append("</table>");
//		buffer.append("</form>");
//		buffer.append("<form action = \"./member_main\" method=\"get\">");
//		buffer.append("<p><input type = \"submit\" value = \"메인으로\"></p>");
//		buffer.append("</form>");
		
		
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("login_id");
		String name = (String)session.getAttribute("login_name");
		
		if( id != null) {
			// id가 세션에 있는경우
			response.setContentType("text/html;charset=utf-8");
			java.io.PrintWriter out = response.getWriter();
			out.println("<h3>" + name + " 님은 로그인 상태입니다.</h3>");
			out.println("<input type = \"button\" value = \"메인으로\" onclick = \"location.href='./member_main'\">");
			out.flush();
			return;
		}
		
		// RequestDispatcher rd = request.getRequestDispatcher(formPage);
//		RequestDispatcher rd = request.getRequestDispatcher(formPage);
//		rd.forward(request, response);
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
			out.println("<input type = \"button\" value = \"메인으로\" onclick = \"location.href='./member_main'\">");
			
			
			Integer count = Integer.parseInt((String)request.getServletContext().getAttribute("count"));
			request.getServletContext().setAttribute("count", "" + (count+1));
		}
		
		// 로그인 아이디 저장을 위한 쿠키 생성
		String save_id = request.getParameter("save_id");
		if (save_id != null) {
			Cookie cookie = new Cookie("save_id", strId);
			// 클라이언트에게 전송하는 응답 흐름에 쿠키 객체를 추가
			// (클라이언트의 웹 브라우저에 쿠키가 저장된다.
			response.addCookie(cookie);
		} else if (save_id == null) {
			// 키값이 save_id인 쿠키를 생성한 뒤에 0초뒤에 관련된 쿠키를 지워버린다.
			Cookie cookie = new Cookie("save_id", "");
			// 0초 뒤에 쿠키가 삭제된다.
			cookie.setMaxAge(0);
			// 클라이언트에게 전송하는 응답 흐름에 쿠키 객체를 추가
			// (클라이언트의 웹 브라우저에 쿠키가 저장된다.
			response.addCookie(cookie);
		}
		
		
	}
}
