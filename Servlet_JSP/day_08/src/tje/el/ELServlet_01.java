package tje.el;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/el_02")
public class ELServlet_01 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSP에서 사용할 정보를 저장
		
		// request 영역에 저장
		request.setAttribute("id", "request_id");
		
		// session 영역에 저장
		HttpSession session = request.getSession();
		session.setAttribute("password", "session_password");
		
		// application 영역에 저장
		ServletContext application = request.getServletContext();
		application.setAttribute("name", "application_name");
		
		String forwardPage = "/el_02.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}
}
