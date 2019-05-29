package tje.servlets.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/member_select")
public class MemberSelectServlet extends HttpServlet {
	
	private static final String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	private static final String jdbc_url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	private static final String jdbc_id = "root";
	private static final String jdbc_password = "SystemManager304";
	private static final String formPage = "/WEB-INF/pages/selectPage.html";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		
		try {
			Connection conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String sql = "select * from member";
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);

			
			while (rs.next()) {
				out.println("회원 ID : " + rs.getString("id") + " / 회원 이름 : " + rs.getString("name") + "</br>");
			}
			out.println("<input type = \"button\" value = \"메인으로\" onclick = \"location.href='./member_main'\">");
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
