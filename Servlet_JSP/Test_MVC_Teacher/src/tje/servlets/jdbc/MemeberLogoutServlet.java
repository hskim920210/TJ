package tje.servlets.jdbc;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/member_logout")
public class MemeberLogoutServlet extends HttpServlet {
	
	private static final String formPage = "/WEB-INF/forms/logoutForm.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 세션을 제거하여 로그인 정보를 무효화
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 사용자가 로그아웃 되었기 때문에
		// 현재 접속된 사용자의 수를 1 감소
		ServletContext application = request.getServletContext();
		
		synchronized (application) {
			if( application.getAttribute("login_member_count") == null )
				application.setAttribute("login_member_count", 0);
			else {
				Integer count = (Integer)application.getAttribute("login_member_count");
				application.setAttribute("login_member_count", count-1);
			}
		}	
		
		// hidden 타입으로 전달된 현재 사용자의 이름을 추출
		String name = request.getParameter("name");
		StringBuilder html = new StringBuilder();
		html.append("<h3>'" + name + "' 님 로그아웃 되었습니다.</h3>");
		html.append(
				String.format(
					"<p><a href='%s'>메인화면으로 이동</a></p>", 
					request.getContextPath() + "/member_main"));
		out.println(html);
		
	}

}







