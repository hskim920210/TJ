package tje.servlets.session_scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session_01")
public class SessionServlet_01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 (Session)
		// 웹 어플리케이션에서 각각의 클라이언트마다 할당되는 메모리 영역
		// 특정 클라이언트의 웹 서버 접속 시점부터 일정 시간동안 값이 유지되는 영역
		// - 로그인 정보 등과 같은 클라이언트의 고유 정보를 저장하는 영역
		
		// 세션 객체의 참조 방법
		// request 객체의 getSession 메소드를 통해서 참조값을 반환
		HttpSession session = request.getSession();
		
		Integer session_count = (Integer)session.getAttribute("count");
		
		if( session_count == null ) {
			session_count = 1;
		} else {
			session_count ++;
		}
		
		session.setAttribute("count", session_count);
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		out.println("<h3>COUNT : " + session_count + "</h3>");
		
	}

}
