package tje.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class guguquery
 */
@WebServlet("/guguquery")
public class guguquery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		StringBuilder buffer = new StringBuilder();
		String dan = request.getParameter("dan");
		System.out.printf("dan - > %s\n", dan);
		PrintWriter out = response.getWriter();
		
		// 입력 매개변수가 전달되지 않은 경우
		if(dan==null) {
			out.println("URL에 단수를 입력해주세요. (변수는 dan으로)\n");
			out.println("예) http://localhost:8080/day_01/guguquery?dan=2 를 입력할 경우 2단이 출력됨");
		}
		
		int i = Integer.parseInt(dan);
		
		out.println(i + "단을 출력합니다.");
		out.println();
		buffer.append("<table border = '1' width = '40%'>");
		for ( int j = 1 ; j <= 9 ; j++ ) {
			buffer.append("<tr>");
				buffer.append("<tr>");
					buffer.append(i + " * " + j);
				buffer.append("</th>");
				buffer.append("<th>");
					buffer.append("=");
				buffer.append("</th>");
				buffer.append("<th>");
					buffer.append(i*j);
				buffer.append("</th>");
			buffer.append("</tr>");
		}
		
		buffer.append("</table>");
		
		out.println(buffer.toString());
	}

}
