package tje.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regist")
public class Servlet_Regist extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 클라이언트의 요청 정보에 한글과 같은 유니코드가 포함되면
		// 인코딩을 변경한 후, 요청 정보를 읽어와야 합니다.
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		int age = Integer.parseInt(request.getParameter("age").trim());
		String tel = request.getParameter("tel").trim();
		String address = request.getParameter("address").trim();
		
		StringBuilder buffer = new StringBuilder();
		String temp = String.format("<h3>%s : %s</h3>\n", "id", id);
		buffer.append(temp);
		temp = String.format("<h3>%s : %s</h3>\n", "password", password);
		buffer.append(temp);
		temp = String.format("<h3>%s : %s</h3>\n", "name", name);
		buffer.append(temp);
		temp = String.format("<h3>%s : %d</h3>\n", "age", age);
		buffer.append(temp);
		temp = String.format("<h3>%s : %s</h3>\n", "tel", tel);
		buffer.append(temp);
		temp = String.format("<h3>%s : %s</h3>\n", "address", address);
		buffer.append(temp);
		
		System.out.println(buffer);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(buffer);
	}

}






