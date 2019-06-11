package tje.mvc.service;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tje.dao.*;
import tje.model.*;
import tje.jdbc.*;

public class DeleteService extends Service {
	private static final String formPage = "/WEB-INF/auth/deleteForm.jsp";
	private static final String submitPage = "/WEB-INF/submits/deleteSubmit.jsp";
		
	private MemberDAO memberDAO = new MemberDAO();
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Member member = new Member(id, null, null, 0, null, null);
		Connection conn = JDBCConnection.getConnection();
		Member searchMember = memberDAO.selectOne(conn, member);
		JDBCCloser.close(conn);
		request.setAttribute("member", searchMember);
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		// JSP 페이지에서 입력받은 확인용 비밀번호
		String confirmPw = request.getParameter("confirmPw");
		
		// 삭제할 회원 정보를 저장할 객체 생성
		// (포워딩 되는 JSP 파일에서 참조할 객체)
		Member member = new Member(id, password, name, age, tel, address);
		boolean result = false;
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = JDBCConnection.getConnection();
		
		// 입력한 패스워드와 멤버의 패스워드가 같다면
		if( password.equals(confirmPw) ) {
			result = memberDAO.delete(conn, member);
			
			request.setAttribute("member", member);
			request.setAttribute("result", result);
			
			/////////////////// 로그아웃 과정 실행 ///////////////////
			// 세션을 삭제하여 로그인 정보를 무효화
			// 원래는 removeAttribute 사용하여 아이디 정보만 지우지만 (세션에 다른 정보가 있을수도 있으니)
			// 현재 세션엔 그 정보밖에 없으니 다삭제시킨다.
			HttpSession session = request.getSession();
			session.invalidate();
			
			// 사용자가 로그아웃 되었기 때문에
			// 현재 접속된 사용자의 수를 1 감소
			ServletContext application = request.getServletContext();
			
			synchronized (application) {
				if(application.getAttribute("login_member_count") == null) {
					application.setAttribute("login_member_count", 0);
				} else {
					Integer count = (Integer)application.getAttribute("login_member_count");
					application.setAttribute("login_member_count", count-1);
				}
			}
			
			return submitPage;
		}
		request.setAttribute("member", member);
		request.setAttribute("result", result);
		return submitPage;
	}
	
	
}














