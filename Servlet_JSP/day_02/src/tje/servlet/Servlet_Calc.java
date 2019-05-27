package tje.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class Servlet_Calc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		if (request.getParameter("x").trim().length() == 0)  {
			out.println("n1 작성을 잘못하였습니다.");
			out.println("n1에 입력하신 값은 '" + request.getParameter("x").trim() + "'입니다.</br>");
		} else if (request.getParameter("y").trim().length() == 0) {
			out.println("n2 작성을 잘못하였습니다.");
			out.println("n1에 입력하신 값은 '" + request.getParameter("y").trim() + "'입니다.</br>");
		} else if (request.getParameter("op").equals("choice")) {
			out.println("연산자 작성을 잘못하였습니다.");
			out.println("n1에 입력하신 값은 '" + request.getParameter("op").trim() + "'입니다.</br>");
		} else {
			
			try {
				double x = Double.parseDouble(request.getParameter("x"));
				double y = Double.parseDouble(request.getParameter("y"));
				String op = request.getParameter("op");
				double result;
				
				if(op.equals("plus")) {
					result = x + y;
					out.println("계산 결과는 " + result + " 입니다.");
				} else if (op.equals("minus")) {
					result = x - y;
					out.println("계산 결과는 " + result + " 입니다.");
				} else if (op.equals("mult")) {
					result = x * y;
					out.println("계산 결과는 " + result + " 입니다.");
				} else if (op.equals("divi")) {
					result = x / y;
					out.println("계산 결과는 " + result + " 입니다.");
				}
				
			} catch(NumberFormatException e) {
				out.println("숫자 입력이 잘못되었습니다.</br>");
				out.println("n1에 입력하신 값은 '" + request.getParameter("x") + "'입니다.</br>");
				out.println("n2에 입력하신 값은 '" + request.getParameter("y") + "'입니다.</br>");
				out.flush();
			}
		}
		out.println("<input type = \"button\" value = \"돌아가기\" onclick = \"location.href='calc.html' \" >");
	}

}
