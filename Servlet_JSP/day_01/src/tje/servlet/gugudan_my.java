package tje.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan_my")
public class gugudan_my extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		out.println("구구단 시작 !");
		out.println("<table width = \"1000px\">");
		
		for(int j = 1 ; j <= 9 ; j++) {
			out.println("<tr>");
			
				for(int i = 2 ; i <= 9 ; i++) {

					out.println("<td>");
					out.println(i);
					out.println("</td>");
					
					out.println("<td>");
					out.println("*");
					out.println("</td>");
					
					out.println("<td>");
					out.println(j);
					out.println("</td>");
					
					out.println("<td>");
					out.println("=");
					out.println("</td>");
					
					out.println("<td>");
					out.println(i*j);
					out.println("</td>");
					
					out.println("<td>");
					out.println("|");
					out.println("</td>");
				}
			out.println("</tr>");
		}
		out.println("</table>");
	}


}
