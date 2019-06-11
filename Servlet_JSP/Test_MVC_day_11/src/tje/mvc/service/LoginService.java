package tje.mvc.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tje.dao.MemberDAO;
import tje.jdbc.JDBCCloser;
import tje.jdbc.JDBCConnection;
import tje.model.Member;

public class LoginService extends Service {
	private String formPage = "/WEB-INF/forms/loginForm.jsp";
	private String submitPage = "/WEB-INF/submits/login.jsp";
	private String errorPage = "/WEB-INF/errors/loginError.html";
		
	// 로그인 서비스는 한번만 만들어지므로 처음에 필드로 갖게 한다.
	private MemberDAO memberDAO = new MemberDAO();
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
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
		
		// DAO 에 전달할 자바빈 객체 생성
		Member member = new Member(id, password, null, 0, null, null);
		
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = JDBCConnection.getConnection();
		// DAO 기능을 사용하여 ID에 일치하는 Member 객체 반환
		Member searchMember = memberDAO.selectOne(conn, member);
		// JDBC 커넥션 종료
		JDBCCloser.close(conn);
		
		// 로그인 여부를 처리한 후, request 객체에 저장
		// (JDBC 처리로 반환된 모델 객체는 반드시 null 값 여부 체크)
		boolean isLogin = false;
		if( searchMember != null && member.getPassword().equals(searchMember.getPassword())) {
			isLogin = true;
		}
		
		request.setAttribute("isLogin", isLogin);
		
		if( isLogin ) {
			HttpSession session = request.getSession();
			session.setAttribute("login_id", id);
			ServletContext application = request.getServletContext();
			
			synchronized (application) {
				if( application.getAttribute("login_member_count") == null )
					application.setAttribute("login_member_count", 1);
				else {
					Integer count = (Integer)application.getAttribute("login_member_count");
					application.setAttribute("login_member_count", count+1);
				}
			}
		}
		
		return submitPage;
	}
	
}