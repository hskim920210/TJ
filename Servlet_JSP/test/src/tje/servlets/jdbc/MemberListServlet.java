package tje.servlets.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.glass.ui.Application;

import tje.model.Member;

@WebServlet("/auth/member_list")
public class MemberListServlet extends HttpServlet {
	// final 멤버는 생성자에서 초기화하거나 정의할때 초기화할수밖에 없다
	
	private static final String formPage = "/WEB-INF/forms/memberList.jsp";
	
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
		// 전체 회원 목록을 저장할 리스트 객체 생성
		// (포워딩 되는 JSP 파일에서 참조할 객체)
		ArrayList<Member> list = new ArrayList<>();
		
		// JDBC를 사용한 데이터베이스 처리
		// 받아온 id,password가 테이블에 일치하는지 확인하는 작업을 한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String query = "select * from member";
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
			while( rs.next() ) {
				// Member 테이블의 각 레코드를 
				// 자바 빈 객체로 변환
				Member member = new Member(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6));
				// 리스트 객체에 자바 빈 객체를 추가
				list.add(member);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			// 커넥션, 스테이트먼트, 리절트셋 널이 아닌경우 닫아준다.
			if( conn != null ) {conn.close();}
			if( pstmt != null ) {pstmt.close();}
			if( rs != null ) {rs.close();}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}
	
}
