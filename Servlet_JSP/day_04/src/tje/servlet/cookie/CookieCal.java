package tje.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookiecal")
public class CookieCal extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Cookie [] cookies = request.getCookies();
		
		String cookie_n1 = null;
		String cookie_op = null;
		String cookie_n2 = null;
		for(int i = 0 ; cookies != null && i < cookies.length ; i++) {
			if(cookies[i].getName().equals("n1")) {
				cookie_n1 = cookies[i].getValue();
			} else if (cookies[i].getName().equals("op")) {
				cookie_op = cookies[i].getValue();
			} else if (cookies[i].getName().equals("n2")) {
				cookie_n2 = cookies[i].getValue();
			}
		}
		
		PrintWriter out = response.getWriter();
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("<form action=\"./cookiecal\" method=\"post\">");
		
		if(cookie_n1 == null) {
			buffer.append("<p>n1 : <input type = \"text\" name = \"x\" required></p>");
		} else {
			buffer.append("<p>n1 : <input type = \"text\" name = \"x\" required" + " value = \"" + cookie_n1 + "\">" + "</p>");
		}
		
		if(cookie_op == null) {
			buffer.append("<p>연산자 : <select name = \"op\">");
			buffer.append("<option value = \"plus\" name = \"plus\">+</option>");
			buffer.append("<option value = \"minus\" name = \"minus\">-</option>");
			buffer.append("<option value = \"mult\" name = \"mult\">*</option>");
			buffer.append("<option value = \"divi\" name = \"divi\">/</option>");
			buffer.append("</select></p>");
		} else if (cookie_op.equals("plus")){
			buffer.append("<p>연산자 : <select name = \"op\">");
			buffer.append("<option value = \"plus\" name = \"plus\" selected>+</option>");
			buffer.append("<option value = \"minus\" name = \"minus\">-</option>");
			buffer.append("<option value = \"mult\" name = \"mult\">*</option>");
			buffer.append("<option value = \"divi\" name = \"divi\">/</option>");
			buffer.append("</select></p>");
		} else if (cookie_op.equals("minus")){
			buffer.append("<p>연산자 : <select name = \"op\">");
			buffer.append("<option value = \"plus\" name = \"plus\">+</option>");
			buffer.append("<option value = \"minus\" name = \"minus\" selected>-</option>");
			buffer.append("<option value = \"mult\" name = \"mult\">*</option>");
			buffer.append("<option value = \"divi\" name = \"divi\">/</option>");
			buffer.append("</select></p>");
		} else if (cookie_op.equals("mult")){
			buffer.append("<p>연산자 : <select name = \"op\">");
			buffer.append("<option value = \"plus\" name = \"plus\">+</option>");
			buffer.append("<option value = \"minus\" name = \"minus\">-</option>");
			buffer.append("<option value = \"mult\" name = \"mult\" selected>*</option>");
			buffer.append("<option value = \"divi\" name = \"divi\">/</option>");
			buffer.append("</select></p>");
		} else if (cookie_op.equals("divi")){
			buffer.append("<p>연산자 : <select name = \"op\">");
			buffer.append("<option value = \"plus\" name = \"plus\">+</option>");
			buffer.append("<option value = \"minus\" name = \"minus\">-</option>");
			buffer.append("<option value = \"mult\" name = \"mult\">*</option>");
			buffer.append("<option value = \"divi\" name = \"divi\" selected>/</option>");
			buffer.append("</select></p>");
		}
		
		
		if(cookie_n2 == null) {
			buffer.append("<p>n2 : <input type = \"text\" name = \"y\" required></p>");
		} else {
			buffer.append("<p>n2 : <input type = \"text\" name = \"y\" required" + " value = \"" + cookie_n2 + "\">" + "</p>");
		}
		buffer.append("<p><input type = \"submit\" value = \"계산 결과 보기 \" name = \"result\"></p>");
		buffer.append("</form>");
		
		out.println(buffer);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		try {
			Double n1 = Double.parseDouble(request.getParameter("x"));
			Double n2 = Double.parseDouble(request.getParameter("y"));
			Double result = null;
			
			if(request.getParameter("op").equals("plus")) {
				result = (n1 + n2);
			} else if (request.getParameter("op").equals("minus")) {
				result = (n1 - n2);
			} else if (request.getParameter("op").equals("mult")) {
				result = (n1 * n2);
			} else if (request.getParameter("op").equals("divi")) {
				result = n1 / n2;
			} 
			response.setContentType("text/html;charset=utf-8");
			Cookie cookie_n1 = new Cookie("n1","" + n1);
			Cookie cookie_op = new Cookie("op","" + request.getParameter("op"));
			Cookie cookie_n2 = new Cookie("n2","" + n2);
			response.addCookie(cookie_n1);
			response.addCookie(cookie_op);
			response.addCookie(cookie_n2);
			PrintWriter out = response.getWriter();
			
			out.println("<h1>계산 결과</h1>");
			out.printf("%.2f %s %.2f = %.2f", n1, request.getParameter("op"), n2, result);
			out.println("<p><input type = \"button\" value = \"이전으로\" onclick = \"location.href='./cookiecal'\"></p>");
		} catch(Exception e) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("숫자를 올바르게 입력하세요.");
			out.println("<p><input type = \"button\" value = \"이전으로\" onclick = \"location.href='./cookiecal'\"></p>");
		}
	
	}

}
