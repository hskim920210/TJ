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

@WebServlet("/session_02")
public class SessionServlet_02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		// 세션이 만들어진 시간
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일  HH:mm:ss");
		Date ct = new Date(session.getCreationTime());
		// 마지막 접속시간
		Date lat = new Date(session.getLastAccessedTime());
		
		// 세션의 최대 유효 시간
		int maxInterval = session.getMaxInactiveInterval();
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		
		out.println("<h3>세션 생성 시간 : ");
		out.println(sdf.format(ct) + "</h3>");
		
		out.println("<h3>세션의 마지막 접속 시간 : ");
		out.println(sdf.format(lat) + "</h3>");
		
		out.println("<h3>세션의 유효 시간 : ");
		out.println(maxInterval + "</h3>");
	}

}
