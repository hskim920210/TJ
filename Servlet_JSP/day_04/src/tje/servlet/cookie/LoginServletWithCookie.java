package tje.servlet.cookie;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login_cookie")
public class LoginServletWithCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 쿠키 여부 확인
		Cookie [] cookies = request.getCookies();
		String save_id = null;
		
		for(int i = 0 ; cookies != null && i < cookies.length ; i++) {
			if(cookies[i].getName().equals("save_id")) {
				save_id = cookies[i].getValue();
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("<form action=\"./login_cookie\" method=\"post\">");
		buffer.append("<table>");
		buffer.append("<caption>로그인</caption>");
		buffer.append("<tr>");
		buffer.append("<th>ID</th>");
		if(save_id == null) {
			buffer.append("<td><input type=\"text\" name=\"id\" required></td>");
		} else {
			buffer.append("<td><input type=\"text\" name=\"id\" value = \"" + save_id + "\" required></td>");
		}
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<th>PW</th>");
		buffer.append("<td><input type=\"password\" name=\"password\" required></td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<th colspan=\"2\">");
		buffer.append("<input type=\"submit\" value=\"로그인\">");
		buffer.append("<label>아이디 저장");
		if(save_id == null) {
			buffer.append("<input type=\"checkbox\" name = \"save_id\">");
		} else {
			buffer.append("<input type=\"checkbox\" name = \"save_id\" checked>");
		}
		buffer.append("</label>");
		buffer.append("</th>");
		buffer.append("</tr>");
		buffer.append("</table>");
		buffer.append("</form>");
		
		out.println(buffer);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		// 체크를 안하면 null값이 넘어오므로 .을 찍으면 널포인트 익셉션이 나온다.
		// 그래서 .trim을 부르면 에러발생
		// 체크박스인 경우 체크를 하면 on 문자열이, 체크를 하지 않으면 null값이 반환
		String save_id = request.getParameter("save_id");
		
		// System.out.printf("%s, %s, %s\n", id, password, save_id);
		
		boolean isLogin = false;
		if (id.equals(password)) {
			isLogin = true;
		}
		
		response.setContentType("text/html;charset=utf-8");
		
		// 로그인 아이디 저장을 위한 쿠키 생성
		if (isLogin && save_id != null) {
			Cookie cookie = new Cookie("save_id", id);
			// 클라이언트에게 전송하는 응답 흐름에 쿠키 객체를 추가
			// (클라이언트의 웹 브라우저에 쿠키가 저장된다.
			response.addCookie(cookie);
		} else if (isLogin && save_id == null) {
			// 키값이 save_id인 쿠키를 생성한 뒤에 0초뒤에 관련된 쿠키를 지워버린다.
			Cookie cookie = new Cookie("save_id", "");
			// 0초 뒤에 쿠키가 삭제된다.
			cookie.setMaxAge(0);
			// 클라이언트에게 전송하는 응답 흐름에 쿠키 객체를 추가
			// (클라이언트의 웹 브라우저에 쿠키가 저장된다.
			response.addCookie(cookie);
		}
		
		PrintWriter out = response.getWriter();
		
		if(isLogin) {
			out.println("<h3>로그인 성공</h3>");
		} else {
			out.println("<h3>로그인 실패</h3>");
		}
		
	}
}
