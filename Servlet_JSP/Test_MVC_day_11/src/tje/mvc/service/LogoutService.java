package tje.mvc.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;
import tje.dao.*;
import tje.jdbc.JDBCCloser;
import tje.jdbc.JDBCConnection;
import tje.model.*;

public class LogoutService extends Service {
	private static final String formPage = "/WEB-INF/auth/logoutForm.jsp";	
	private static final String mainPage = "/WEB-INF/forms/main.jsp";
	
	private MemberDAO memberDAO = new MemberDAO();
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		String id = (String)session.getAttribute("login_id");
		String name = null;
		
		Connection conn = JDBCConnection.getConnection();
		
		Member member = new Member(id, null, null, 0, null, null);
		// DAO 기능을 사용하여 ID에 일치하는 Member 객체 반환
		Member searchMember = memberDAO.selectOne(conn, member);
		// JDBC 커넥션 종료
		JDBCCloser.close(conn);
		name = searchMember.getName();
		
		// 현재 페이지에서 사용할 정보를 영역객체게 저장
		request.setAttribute("name", name);
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		//세션을 제거하여 로그인 정보를 무효화
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 사용자가 로그아웃 되었기 때문에
		// 현재 접속된 사용자의 수를 1 감소
		ServletContext application = request.getServletContext();
		
		synchronized (application) {
			if( application.getAttribute("login_member_count") == null )
				application.setAttribute("login_member_count", 0);
			else {
				Integer count = (Integer)application.getAttribute("login_member_count");
				application.setAttribute("login_member_count", count-1);
			}
		}	
		try {
			response.sendRedirect(request.getContextPath() + "/main.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}