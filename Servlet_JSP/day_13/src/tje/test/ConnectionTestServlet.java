package tje.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import tje.jdbc.util.*;

@WebServlet("/conn_test")
public class ConnectionTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConnectionProvider.getConnection();
		
		String sql = "select * from member";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.printf("ID : %s\n", rs.getString("id"));
			}
			Closer.close(rs);
			Closer.close(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DBCP 커넥션 풀을 사용하는 경우 반환되는 커넥션 객체는
		// PoolableConnection 타입으로 close 메소드를 호출하면
		// 커넥션이 종료되지 않고 커넥션 풀로 반환되어 다음 사용을 대기
		Closer.close(conn);
	}
}
