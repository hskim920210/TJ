package tje.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tje.model.Member;

public class RegistService extends Service {
	private static final String formPage = "/WEB-INF/forms/registForm.jsp";	
	private static final String submitPage = "/WEB-INF/submits/registSubmit.jsp";
	private static final String errorPage = "/WEB-INF/errors/loginError.html";
		
	
	public RegistService() {
		super();
	}

	public RegistService(ServletConfig config) {
	}
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		boolean isLogin = false;
		if( session != null && session.getAttribute("login_id") != null )
			isLogin = true;
		
		String forwardPage = formPage;
		
		if( isLogin ) {
			return errorPage;
		}
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		// 클라이언트가 전달한 폼 데이터를 추출 
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String strAge = request.getParameter("age").trim();
		int age = Integer.parseInt(strAge);
		String tel = request.getParameter("tel").trim();
		String address = request.getParameter("address").trim();
		
		Member member = new Member(id, password, name, age, tel, address);
		
		// 회원 가입 결과를 저장하는 변수
		Integer result = null;
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = null;
		PreparedStatement pstmt = null;		
		ServletContext context = request.getServletContext();
		try {
			conn = DriverManager.getConnection(context.getInitParameter("JDBC_URL")
					, context.getInitParameter("JDBC_ID"), context.getInitParameter("JDBC_PASSWORD"));
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
		
		request.setAttribute("member", member);
		request.setAttribute("result", result);
		return submitPage;
	}
	
	
}














