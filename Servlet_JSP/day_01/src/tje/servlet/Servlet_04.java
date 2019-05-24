package tje.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 클래스의 초기화
// - web.xml 파일을 활용하는 방법
// 1. servlet 태그 내부에 init-param 태그를 정의하여
//		초기화에 사용될 데이터의 NAME-VALUE를 설정
// 2. 서블릿 클래스의 init 메소드 내부에서 
//		web.xml 파일에 저장된 초기화 정보를 로딩

public class Servlet_04 extends HttpServlet {
	private String user_id;
	private String user_pw;
	
	public void init(ServletConfig config) throws ServletException {
		user_id = config.getInitParameter("USER_ID");
		user_pw = config.getInitParameter("USER_PW");
		System.out.printf("(init) ID : %s, PW : %s\n", user_id, user_pw);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.printf("(doGet) ID : %s, PW : %s\n", user_id, user_pw);
	}

}
