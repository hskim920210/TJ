package tje.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿(Servlet)
// 자바 기반의 웹 프로그래밍을 작성하기 위한 클래스를 의미
// J2EE 패키지의 명세를 따라 작성해야만 웹 서버에 의해 동작할 수 있는 클래스이다.
// (HttpServlet 클래스의 자식 클래스로 정의해야한다.)

// HttpServlet : 웹 기반의 프로그래밍을 위한 일반적인 기능을 정의하고 있는 클래스
// doGet 메소드 : 클라이언트의 get 방식의 요청을 받아들여 처리할 수 있는 메소드
// doPost 메소드 : 클라이언트의 post 방식의 요청을 받아들여 처리할 수 있는 메소드
// tomcat은 이 클래스를 httpservlet의 자식으로 관리한다. 다형성구현

// 모든 서블릿 클래스들은 클래스의 정의한 후, 웹 서버(서블릿 컨테이너)에 URL 정보와 함께
// 서블릿을 등록해야만 클라이언트의 요청에 따라 동작할 수 있다.

// 서블릿 컨테이너의 설정파일 web.xml ( 중요 ! ) 
// Deployment Descriptor:day_01 우클릭하고 generate Deployment Descriptor stub 하면 
// WebContent/Web-INF에 web.xml이 생긴다.
// 서블릿 클래스의 등록과 특정 서블릿 클래스를 실행시킬 URL 정보를 기술할 수 있다.
// 서블릿이 많아질수록 복잡해진다.
// => 지금은 어노테이션을 이용한 방법이 표준으로 이용됨.
public class Servlet_01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_01.doGet 메소드 실행");
	}

}
