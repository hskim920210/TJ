package tje.mvc.service;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tje.model.*;
import tje.dao.*;
import tje.jdbc.JDBCCloser;
import tje.jdbc.JDBCConnection;

public class ListService extends Service {
	private static final String formPage = "/WEB-INF/auth/listForm.jsp";	
	private MemberDAO memberDAO = new MemberDAO();
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		// 전체 회원 목록을 저장할 리스트 객체 생성
		// (포워딩되는 JSP 파일에서 참조할 객체)
		ArrayList<Member> list = new ArrayList<>();
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = JDBCConnection.getConnection();
		list = memberDAO.selectAll(conn);
		JDBCCloser.close(conn);
		
		request.setAttribute("list", list);
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	
	
}