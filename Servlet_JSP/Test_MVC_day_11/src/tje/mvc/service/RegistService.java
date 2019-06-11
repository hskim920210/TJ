package tje.mvc.service;

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

import tje.dao.MemberDAO;
import tje.jdbc.JDBCCloser;
import tje.jdbc.JDBCConnection;
import tje.model.Member;

public class RegistService extends Service {
	private static final String formPage = "/WEB-INF/forms/registForm.jsp";	
	private static final String submitPage = "/WEB-INF/submits/registSubmit.jsp";
	private static final String errorPage = "/WEB-INF/errors/loginError.html";
		
private MemberDAO memberDAO = new MemberDAO();
	
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		boolean isLogin = false;
		if( session != null && session.getAttribute("login_id") != null )
			isLogin = true;				
		
		if( isLogin ) {
			return errorPage;			
		}
		
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {		
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String strAge = request.getParameter("age").trim();
		int age = 0;
		try {
			age = Integer.parseInt(strAge);
		} catch (Exception e) {
			// 나이 입력 안함...
			age = 0;
		}
		String tel = request.getParameter("tel").trim();
		String address = request.getParameter("address").trim();
		
		Member member = new Member(id, password, name, age, tel, address);
		
		Connection conn = JDBCConnection.getConnection();
		boolean result = memberDAO.insert(conn, member);
		JDBCCloser.close(conn);
				
		request.setAttribute("member", member);
		request.setAttribute("result", result);
				
		return submitPage;
	}
	
	
}














