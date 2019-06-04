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

import com.sun.glass.ui.Application;

@WebServlet("/member_logout")
public class MemberLogoutServlet extends HttpServlet {
	// final 멤버는 생성자에서 초기화하거나 정의할때 초기화할수밖에 없다
	
	private static final String formPage = "/WEB-INF/forms/logoutForm.jsp";
	private static final String errorPage = "/WEB-INF/errors/logoutError.html";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		boolean isLogin = false;
		if( session != null && session.getAttribute("login_id") != null ) {
			isLogin = true;
		}
		
		String forwardPage = formPage;
		
		// 로그인되어있지 않다면 포워딩할 페이지를 에러페이지로 바꾼다.
		if( !isLogin ) {
			forwardPage = errorPage;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// logoutForm.jsp에서 로그아웃 버튼을 눌렀을 때 post 방식으로 전달받아 실행되는 곳
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 세션을 삭제하여 로그인 정보를 무효화
		// 원래는 removeAttribute 사용하여 아이디 정보만 지우지만 (세션에 다른 정보가 있을수도 있으니)
		// 현재 세션엔 그 정보밖에 없으니 다삭제시킨다.
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 사용자가 로그아웃 되었기 때문에
		// 현재 접속된 사용자의 수를 1 감소
		ServletContext application = request.getServletContext();
		
		synchronized (application) {
			if(application.getAttribute("login_member_count") == null) {
				application.setAttribute("login_member_count", 0);
			} else {
				Integer count = (Integer)application.getAttribute("login_member_count");
				application.setAttribute("login_member_count", count-1);
			}
		}
		
		// hidden 타입으로 전달된 현재 사용자의 이름을 추출
		String name = request.getParameter("name");
		StringBuilder html = new StringBuilder();
		html.append("<h3>'" + name + "' 님 로그아웃 되었습니다.</h3>");
		html.append(String.format("<p><a href='%s'>메인화면으로 이동</a></p>", request.getContextPath() + "/member_main"));
		out.println(html);
	}
	
}
