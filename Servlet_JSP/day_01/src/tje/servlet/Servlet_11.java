package tje.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹 어플리케이션의 동작 방식
// 1. 클라이언트의 URL 요청
// (form 태그의 정보가 전달될 수 있음)
// 2. 서블릿 컨테너의 서블릿 객체 호출
// (해당 url을 처리할 서블릿 객체 실행)
// 3. 서블릿 객체가 반환하는 값을 클라이언트에게 응답

// 클라이언트의 요청 정보는 HttpServletRequest 객체로 전달
// 클라이언트에게 응답하기위한 HttpServletResponse 객체가 전달 
@WebServlet("/s11")
public class Servlet_11 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strDan = request.getParameter("dan");
		// 입력매개변수가 전달되지 않은 경우
		if( strDan == null )
			strDan = "2";
		
		int nDan = Integer.parseInt(strDan);

		StringBuilder buffer = new StringBuilder();
		buffer.append("<table border='1'>");

		buffer.append("<tr>");
		buffer.append("<th colspan='2' width='37%'>");
		buffer.append(nDan + "단을 출력합니다.");
		buffer.append("</th>");
		buffer.append("</tr>");

		for (int j = 1; j < 10; j++) {
			buffer.append("<tr>");
			buffer.append("<td>");
			buffer.append(String.format("%d * %d", nDan, j));
			buffer.append("</td>");
			buffer.append("<td>");
			buffer.append(nDan * j);
			buffer.append("</td>");
			buffer.append("</tr>");
		}

		buffer.append("</table>");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(buffer.toString());
	}

}






