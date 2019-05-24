package tje.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 어노테이션
// 서블릿 클래스의 서블릿 컨테이너 등록을 위한 어노테이션
// web.xml 파일을 사용하지 않고 현재 서블릿 클래스를 서블릿 컨테이너에 등록할 수 있다.
// 추가적으로 문자열 정보를 입력하여 URL 정보를 기술할 수 있다.
@WebServlet("/s02")
public class Servlet_02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_02.doGet 메소드 실행");
	}

}
