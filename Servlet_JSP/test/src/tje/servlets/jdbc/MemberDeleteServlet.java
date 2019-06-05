package tje.servlets.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

@WebServlet("/auth/member_delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final String formPage = "/WEB-INF/forms/memberDelete.jsp";
	private static final String submitPage = "/WEB-INF/submits/submitDelete.jsp";
	
	
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
		// 삭제하고자 하는 멤버의 아이디 값을 쿼리 스트링에서 추출
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 삭제하고자 하는 멤버의 객체를 추출
		// 삭제를 하고자 하는 멤버의 아이디 값을 쿼리 스트링에서 추출
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
		Integer result = 0;
		
		// JDBC를 사용한 데이터베이스 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 입력한 패스워드와 멤버의 패스워드가 같다면
		if( password.equals(confirmPw) ) {
			try {
				conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
				String query = "delete from member where id = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, id);
				
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
			return;
		}
		
		request.setAttribute("member", member);
		request.setAttribute("result", result);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(submitPage);
		rd.forward(request, response);
		
	}

}
