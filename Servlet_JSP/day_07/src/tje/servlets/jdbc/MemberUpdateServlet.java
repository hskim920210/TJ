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

@WebServlet("/member_update")
public class MemberUpdateServlet extends HttpServlet {
	// final 멤버는 생성자에서 초기화하거나 정의할때 초기화할수밖에 없다
	
	private static final String formPage = "/WEB-INF/forms/memberUpdate.jsp";
	private static final String submitPage = "/WEB-INF/submits/submitUpdate.jsp";
	
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
		
		// 수정을 하고자 하는 멤버의 아이디 값을 쿼리 스트링에서 추출
		String id = request.getParameter("id");
		
		// 조회할 회원 정보를 저장할 객체 생성
		// (포워딩 되는 JSP 파일에서 참조할 객체)
		Member member = null;
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String query = "select * from member where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				member = new Member(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6));
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
		
		request.setAttribute("member", member);
		
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 수정을 하고자 하는 멤버의 아이디 값을 쿼리 스트링에서 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		// 수정할 회원 정보를 저장할 객체 생성
		// (포워딩 되는 JSP 파일에서 참조할 객체)
		Member member = new Member(id, password, name, age, tel, address);
		// 업데이트의 결과값 저장 변수
		// (포워딩 되는 JSP 파일에서 참조할 객체)
		Integer result = 0;
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String query = "update member set name = ?, age = ?, tel = ?, address = ? where id = ? and password = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			pstmt.setString(5, id);
			pstmt.setString(6, password);
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			if( conn != null ) {conn.close();}
			if( pstmt != null ) {pstmt.close();}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("member", member);
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher(submitPage);
		rd.forward(request, response);
	}
	
}
