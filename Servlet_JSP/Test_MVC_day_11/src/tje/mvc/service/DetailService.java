package tje.mvc.service;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tje.dao.*;
import tje.jdbc.*;
import tje.model.*;

public class DetailService extends Service {
	private static final String formPage = "/WEB-INF/auth/detailForm.jsp";	
		
	private MemberDAO memberDAO = new MemberDAO();
	
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		// 조회를 하고자 하는 멤버의 아이디값을 쿼리 스트링에 추출
		String id = request.getParameter("id");
		
		// 조회할 회원 정보를 저장할 객체 생성
		// (포워딩되는 JSP 파일에서 참조할 객체)
		Member member = new Member(id, null, null, 0, null, null);
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = JDBCConnection.getConnection();
		Member searchMember = memberDAO.selectOne(conn, member);
		JDBCCloser.close(conn);
		request.setAttribute("member", searchMember);
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	
	
}