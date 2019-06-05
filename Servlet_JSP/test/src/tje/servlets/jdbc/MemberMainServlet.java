package tje.servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member_main")
public class MemberMainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 웹 서버(서블릿 컨테이너)에 로그인된 사용자의 수를 추출하기 위해
		// ServletContext(JSP의 APPLICATION 객체를 반환)
		ServletContext application = request.getServletContext();
		
		// 현재 접속한 클라이언트의 세션이 존재하지 않는 경우 null 값을 반환시키는 코드
		// (세션이 존재하지 않는 경우 세션이 생성되지 않는다)
		HttpSession session = request.getSession(false);
		
		String login_id = null;
		Integer login_member_count = null;
		
		// 현재 클라이언트의 세션이 존재한다면
		if( session != null ) {
			login_id = (String)session.getAttribute("login_id");
			login_member_count = (Integer)application.getAttribute("login_member_count");
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 아래의 기능이 동작할 수 있도록 서블릿과 HTML 파일을 완성하세요.
		// (회원목록보기/로그아웃은 로그인된 클라이언트만 가능)
		// (회원가입/로그인은 로그인이 되지 않은 클라이언트만 가능)
		// (로그인된 클라이언트는 메인화면에서 현재 접속된 클라이언트의 
		//  인원수를 확인할 수 있음)
		
		out.println("<h2>메인 메뉴</h2>");
		if( login_id != null && login_member_count != null ) {
			out.println("<h3>현재 접속된 클라이언트의 수 : " + login_member_count + "</h3>");
		} else if( login_id != null && login_member_count == null ) {
			out.println("<h3>현재 접속된 클라이언트의 수 : 0</h3>");
		}
		out.println("<ul>");
		if( login_id != null ) {
			out.println("<li><a href='./auth/member_list'>회원목록 보기</a></li>");
			out.println("<li><a href='./auth/member_logout'>로그아웃</a></li>");
		} else {
			out.println("<li><a href='./member_regist'>회원가입</a></li>");
			out.println("<li><a href='./member_login'>로그인</a></li>");
		}
		out.println("</ul>");
	}
}
