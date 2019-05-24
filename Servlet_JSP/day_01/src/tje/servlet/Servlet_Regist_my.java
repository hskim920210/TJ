package tje.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Regist
 */
@WebServlet("/myregist")
public class Servlet_Regist_my extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 값을 받아올 때 트림 거의 필수. 언제 어디서 공백이 발생할 지 모른다.
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		int age = Integer.parseInt(request.getParameter("age").trim());
		
		String result = "회원가입 성공 !";
		
		
		PrintWriter out = response.getWriter();
		
		out.println(String.format("%s%s%s", "<h3>", "id = " + id, "</h3>"));
		out.println(String.format("%s%s%s", "<h3>", "password = " + password, "</h3>"));
		out.println(String.format("%s%s%s", "<h3>", "name = " + name, "</h3>"));
		out.println(String.format("%s%s%s", "<h3>", "age = " + age, "</h3>"));
		out.println(String.format("%s%s%s", "<h3>", result, "</h3>"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
