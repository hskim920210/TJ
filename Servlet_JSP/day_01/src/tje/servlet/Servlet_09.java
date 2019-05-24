package tje.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹 어플리케이션의 동작 방식
// 1. 클라이언트의 URL 요청
// 	(form 태그의 정보가 전달될 수 있다.)
// 2. 서블릿 컨테이너의 서블릿 객체 호출 (request)
// 	(해당 url을 처리할 서블릿 객체 실행)
// 3. 서블릿 객체가 반환하는 값을 클라이언트에게 응답 (respondse)

// 클라이언트의 요청 정보는 HttpServletRequest 객체로 전달
// 클라이언트에게 응답하기 위한 HttpServletResponse 객체가 전달
@WebServlet("/s09")
public class Servlet_09 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 응답 스트림에 출력할 문자열 데이터가 한글이 포함되는 경우 반드시 실행해야 하는 코드
		// 현재 보내는 것은 html타입이다 ;문자셋은 utf-8 
		// 주의사항 ! getWriter 메소드 사용 전에 실행해야 한다.
		response.setContentType("text/html;charset=utf-8");
		
		// 현재 시간의 Date 객체 생성
		Date now = new Date();
		// java.util.Date now = java.util.Calendar.getInstance().getTime(); 으로 가져와도 됨
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일  a hh시 mm분 ss초 ");
		
		// HttpServletResponse 객체
		// - 클라이언트에게 응답을 할 수 있도록 제공되는 객체
		// - 기본적으로 문자열 정보를 출력하여 클라이언트의 웹 브라우저에서
		// 	  확인할 수 있도록 구현
		// - 스트림을 기반으로 통신을 구현
		
		// HttpServletResponse 클래스의 getWriter 메소드
		// - 현재 요청을 보낸 클라이언트에게 응답을 보낼 수 있는 스트림 객체를 반환해주는 메소드
		java.io.PrintWriter out = response.getWriter();
		
		// HttpServletResponse 클래스의 객체를 사용하여 클라이언트에게
		// 응답을 보낼 때는 HTML 코드를 작성하여 전송해야 한다.
		out.println("<h1>");
		out.print(sdf.format(now));
		out.print("에 접속하셨습니다.");
		out.println("</h1>");
	}
}
