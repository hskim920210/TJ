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

import tje.model.*;
import tje.dao.*;
import tje.jdbc.*;

public class UpdateService extends Service {
	private static final String formPage = "/WEB-INF/auth/updateForm.jsp";	
	private static final String submitPage = "/WEB-INF/submits/updateSubmit.jsp";
	
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
		
		// 수정할 회원 정보를 저장할 객체 생성
		// (포워딩되는 JSP 파일에서 참조할 객체)
		Member member = new Member(id, password, name, age, tel, address);
		// 업데이트의 결과 값 저장 변수
		// (포워딩되는 JSP 파일에서 참조할 객체)
		boolean result = false;
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = JDBCConnection.getConnection();
		result = memberDAO.updatePassword(conn, member);
		JDBCCloser.close(conn);
		
		request.setAttribute("member", member);
		request.setAttribute("result", result);
		return submitPage;
	}
	
	
}














