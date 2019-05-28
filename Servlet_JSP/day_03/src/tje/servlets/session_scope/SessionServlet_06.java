package tje.servlets.session_scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session_06")
public class SessionServlet_06 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 이때서야 ram에 할당된다
		HttpSession session = request.getSession();
		
		Integer count1 = (Integer)session.getAttribute("count1");
		
		if( count1 == null ) {
			count1 = 1;
		} else {
			count1 ++;
		}
		
		session.setAttribute("count1", count1);
		
		Integer count2 = (Integer)session.getAttribute("count2");
		
		if( count2 == null ) {
			count2 = 1;
		} else {
			count2 ++;
		}
		
		session.setAttribute("count2", count2);
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		out.println("<h3>COUNT1 : " + count1 + "</h3>");
		out.println("<h3>COUNT2 : " + count2 + "</h3>");
		
		// 세션에 저장된 특정 속성을 제거하는 메소드
		session.removeAttribute("count2");
	}
}