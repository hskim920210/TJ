package tje.servlets.session_scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session_05")
public class SessionServlet_05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 이때서야 ram에 할당된다
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
		
		// 특정 세션을 제거하는 메소드 (모든 어트리뷰트를 다 소멸시킨다)
		session.invalidate();
		
	}

}
