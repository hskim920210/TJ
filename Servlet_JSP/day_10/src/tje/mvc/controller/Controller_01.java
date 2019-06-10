package tje.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MVC 패턴
// 모델/뷰/컨트롤러를 사용하여 프로그램을 구현하는 방식
// 클라이언트의 요청을 받아들이는 컨트롤러
// 요청의 처리 결과를 저장하는 모델
// 모델의 값을 화면에 출력하여 클라이언트에 보여지는 뷰

// MVC 패턴을 구성하는 각 요소의 역할(웹 어플리케이션의 경우)
// 1. 컨트롤러
//  - 클라이언트의 요청의 종류를 파악하여 적절한 처리 객체를 통해
//    모델 객체를 생성하고, 특정 영역 객체(request, session, application)
//    에 모델을 저장한 후, 뷰 페이지로 이동하는 역할을 담당
// 2. 모델
//  - 요청의 처리 결과를 저장하는 일반 클래스
//  - 일반적으로 자바빈의 규약을 준수하는 클래스의 형태로 작성
//  - 처리 결과의 유형에 따라서 다양하게 작성될 수 있음
// 3. 뷰
//	- 일반적으로 JSP를 사용하여 구현
//  - 컨트롤러에서 포워딩되어 실행
//  - 처리 결과인 모델의 값을 사용하여 화면에 출력하는 역할

// 컨트롤러 클래스의 구현
// - MVC 패턴을 이용하여 웹 어플리케이션을 구현하는 경우
//   모든 클라이언트의 요청은 단 하나의 컨트롤러 클래스가 담당하여
//   처리합니다.
// - 컨트롤러 클래스는 클라이언트의 요청 URI를 확인하여 적절한
//   처리 클래스(서비스)를 사용하여 로직을 처리
@WebServlet("*.do1")
public class Controller_01 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		System.out.println(requestURI.substring(request.getContextPath().length()));
		*/
		// 클라이언트의 요청 URI를 추출하여 변수로 저장
		String requestURI = 
				request.getRequestURI().substring(
						request.getContextPath().length());
		
		String viewPage = null;
		if( requestURI.equals("/hello.do1") ) {
			request.setAttribute("HelloMsg", "안녕하세요~!");
			viewPage = "/WEB-INF/views/hello.jsp";
		} else if( requestURI.equals("/bye.do1") ) {
			request.setAttribute("ByeMsg", "조심히 들어가세요~!");
			viewPage = "/WEB-INF/views/bye.jsp";
		}
		
		if( viewPage != null )
			request.getRequestDispatcher(viewPage).forward(request, response);
		else
			response.sendError(404);
	}
}












