package tje.listener;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/count")
public class VisitorCountServlet extends HttpServlet {
	
	private static final String viewPage = "/WEB-INF/views/count.jsp";
               
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		int count = 1;
		if( context.getAttribute("count") != null )
			count = (Integer)context.getAttribute("count") + 1;
		
		context.setAttribute("count", count);
		
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

}











