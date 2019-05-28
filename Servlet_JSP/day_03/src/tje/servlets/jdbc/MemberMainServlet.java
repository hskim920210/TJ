package tje.servlets.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member_main")
public class MemberMainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("login_id");
		String name = (String)session.getAttribute("login_name");
		
		if( id != null) {
			// id가 세션에 있는경우
			out.println("<h2>메인 메뉴</h2>");
			out.println("<h3>현재 접속된 클라이언트의 수 : ???</h3>");
			out.println("<ul>");
			out.println("<li><a href = './member_select'>회원목록 보기</a></li>");
			out.println("<li><a href = './member_logout'>로그아웃</a></li>");
			out.println("</ul>");
			out.flush();
			// 페이지 포워딩이 일어나지 않도록
			return;
			
		}
		// 아래의 기능이 동작할 수 있도록 서블릿과 HTML 파일을 완성하세요.
		// (회원목록 보기 / 로그아웃은 로그인된 클라이언트만 가능)
		// (회원가입과 로그인은 로그인이 되지 않은 클라이언트만 가능)
		// (로그인된 클라이언트는 메인화면에서 현재 접속된 클라이언트의 인원수를 확인할 수 있다.)
		out.println("<h2>메인 메뉴</h2>");
		out.println("<h3>현재 접속된 클라이언트의 수 : ???</h3>");
		out.println("<ul>");
		out.println("<li><a href = './member_regist'>회원가입</a></li>");
		out.println("<li><a href = './member_login'>로그인</a></li>");
		out.println("</ul>");
	}
}
