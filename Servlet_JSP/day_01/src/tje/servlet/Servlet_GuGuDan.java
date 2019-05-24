package tje.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_GuGuDan
 */
@WebServlet("/gugudan")
public class Servlet_GuGuDan extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder buffer = new StringBuilder();
		
		/*
		buffer.append("<table border = '1'>");
		for( int i = 2 ; i < 10 ; i++ ) {
			buffer.append("<tr>");
			buffer.append("<th colspan='2' width='37%'>");
			buffer.append(i + "단을 출력합니다.");
			buffer.append("</th>");
			buffer.append("</tr>");
			
			for( int j = 1 ; j < 10 ; j++ ) {
				buffer.append("<tr>");
				buffer.append("<td>");				
				buffer.append(String.format("%d * %d", i, j));
				buffer.append("</td>");
				buffer.append("<td>");				
				buffer.append(i * j);
				buffer.append("</td>");
				buffer.append("</tr>");
			}
		}
		buffer.append("</table>");
		*/
		
		
		buffer.append("<table border = '1'>");
		for( int i = 0 ; i < 10 ; i++ ) {
			
			buffer.append("<tr>");
			for( int j = 2 ; j < 10 ; j++ ) {
				if(i == 0) {
					buffer.append("<th colspan='2'");
					buffer.append(j + "단을 출력합니다.");
					buffer.append("</th>");
				} else {
					buffer.append("<th>");				
					buffer.append(String.format("%d * %d", j, i));
					buffer.append("</th>");
					buffer.append("<th>");				
					buffer.append(i * j);
					buffer.append("</th>");
				}
			}
			buffer.append("</tr>");
		}
		buffer.append("</table>");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(buffer.toString());
	}

}
