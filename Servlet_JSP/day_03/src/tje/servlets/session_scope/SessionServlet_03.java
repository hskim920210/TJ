package tje.servlets.session_scope;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session_03")
public class SessionServlet_03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		// 세션의 유효시간을 제어하는 방법
		// 1. setMaxInactiveInterval 메소드의 매개변수로
		// 세션의 유효시간의 값을 정의할 수 있다. 단위는 초
		// - 특정 세션의 지속 시간을 제어하는 경우에 사용한다.
		session.setMaxInactiveInterval(60);
		
		// 세션의 최대 유효 시간
		int maxInterval = session.getMaxInactiveInterval();
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();

		
		out.println("<h3>세션의 유효 시간 : ");
		out.println(maxInterval + "</h3>");
	}

}
