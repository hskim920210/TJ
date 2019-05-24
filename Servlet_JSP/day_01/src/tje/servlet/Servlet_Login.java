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
@WebServlet("/login")
public class Servlet_Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 값을 받아올 때 트림 거의 필수. 언제 어디서 공백이 발생할 지 모른다.
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		
		String result = "로그인 성공 !";
		
		if(!id.equals(password)) {
			result = "로그인 실패";
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(String.format("%s%s%s", "<h3>", result, "</h3>"));
	}

}






