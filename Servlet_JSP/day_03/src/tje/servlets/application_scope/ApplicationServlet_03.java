package tje.servlets.application_scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/application_03")
public class ApplicationServlet_03 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext application = request.getServletContext();
		
		Integer count_app = null;

		synchronized (application) {
			count_app = (Integer)application.getAttribute("count");
			if(count_app == null) {
				count_app = 1;
			} else {
				count_app ++;
			}
			application.setAttribute("count", count_app);
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		out.println("<h3>COUNT_APP : " + count_app + "</h3>");
	}
}