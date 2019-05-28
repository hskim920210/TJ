package tje.servlets.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member_logout")
public class MemberLogoutServlet extends HttpServlet {

	private static final String formPage = "/WEB-INF/pages/logoutPage.html";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("login_id");
		String name = (String)session.getAttribute("login_name");
		
		session.removeAttribute("login_id");
		session.removeAttribute("login_name");
	
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		
		// 로그인 성공
		out.println("<h2>로그아웃</h2>");
		out.println("<h4>" + name + " 님의 로그아웃 요청이 처리되었습니다.</h4>");
		out.println("<input type = \"button\" value = \"메인으로\" onclick = \"location.href='./member_main'\">");
	}

}
