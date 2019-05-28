package tje.servlets.application_scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/application_01")
public class ApplicationServlet_01 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ServletContext (Application 영역)
		// 서블릿 컨테이너(웹 서버)가 구동될 때 생성되는 영역
		// 서블릿 컨테이너(웹 서버)가 종료될 때 소멸된다.
		// 모든 서블릿/JSP에서 공유하고자 하는 정보를 저장할 때 사용
		
		// ServletContext영역 (Application 영역)을 반환받는 방법
		ServletContext application = request.getServletContext();
		Integer count_app = (Integer)application.getAttribute("count");
		if(count_app == null) {
			count_app = 1;
		} else {
			count_app ++;
		}
		application.setAttribute("count", count_app);
		
		
		HttpSession session = request.getSession();
		Integer count_session = (Integer)session.getAttribute("count");
		if(count_session == null) {
			count_session = 1;
		} else {
			count_session ++;
		}
		session.setAttribute("count", count_session);
		
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		out.println("<h3>COUNT_APP : " + count_app + "</h3>");
		out.println("<h3>COUNT_SESSION : " + count_session + "</h3>");
	}
}