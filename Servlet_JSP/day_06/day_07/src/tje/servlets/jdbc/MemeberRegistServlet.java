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

import tje.model.Member;

@WebServlet("/member_regist")
public class MemeberRegistServlet extends HttpServlet {
	
	private static final String formPage = "/WEB-INF/forms/memberForm.html";	
	private static final String submitPage = "/WEB-INF/submits/memberSubmit.jsp";
	
	private static String jdbc_url;
	private static String jdbc_id;
	private static String jdbc_password;

	public void init(ServletConfig config) throws ServletException {
		ServletContext application = config.getServletContext();
		jdbc_url = application.getInitParameter("JDBC_URL");
		jdbc_id = application.getInitParameter("JDBC_ID");
		jdbc_password = application.getInitParameter("JDBC_PASSWORD");
		
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트가 전달한 폼 데이터를 추출 
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String strAge = request.getParameter("age").trim();
		int age = Integer.parseInt(strAge);
		String tel = request.getParameter("tel").trim();
		String address = request.getParameter("address").trim();
		
		// 폼 데이터를 사용하여 자바 빈 객체를 생성
		Member member = new Member(id, password, name, age, tel, address);
		
		// 회원 가입 결과를 저장하는 변수
		Integer result = null;
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String query = "insert into member values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getTel());
			pstmt.setString(6, member.getAddress());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if( conn != null ) conn.close();
			if( pstmt != null ) pstmt.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// 포워딩 될 JSP에서 활용할 정보를 request 영역에 저장
		
		// 1. request 영역에 사용자가 입력한 폼데이터를 저장하고 있는
		// 자바 빈 객체 저장
		request.setAttribute("member", member);
		// 2. request 영역에 회원 가입의 결과를 저장
		request.setAttribute("result", result);
		
		// 3. JSP 페이지로 포워딩
		RequestDispatcher rd = request.getRequestDispatcher(submitPage);
		rd.forward(request, response);
	}

}







