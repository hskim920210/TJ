package servlet_jsp_test;

// servlet은 javaresources 안에 한다

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");

		out.println("<head>");
		out.println("<title> Hello Servlet </title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>Hello Servlet Programming ~ !</h1>");
		out.println("</body>");
		
		out.println("</html>");
	}

}
