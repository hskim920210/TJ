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
		java.io.PrintWriter out = response.getWriter();
		out.print("post");
		
		try {
			Connection conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String sql = "select * from member";
			String sql_tot = "select count(*) from member";
			Statement stmt = conn.createStatement();
			Statement stmt_tot = conn.createStatement();
			ResultSet rs = null;
			ResultSet rs_tot = null;
			rs = stmt.executeQuery(sql);
			rs_tot = stmt.executeQuery(sql_tot);
			int rowCount = 0;
			
			while(rs_tot.next()) {
				rowCount = rs_tot.getInt(1);
			}
			
			while (rs.next()) {
				out.println(rs.getString("id") + rs.getString("name"));
				out.flush();
			}
			
			rs.close();
			rs_tot.close();
			stmt.close();
			stmt_tot.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
