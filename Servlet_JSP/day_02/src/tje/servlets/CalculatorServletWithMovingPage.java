package tje.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServletWithMovingPage extends HttpServlet {
	
	// 아래 페이지로 점프시킨다.
	// 리다이렉트 기능으로 이동할 페이지의 URL 정보를 /로 시작하는 경우 
	// 웹 어플리케이션의 이름이 생략되기 때문에 404 에러가 발생한다.
	// 이러한 문제를 해결하기 위해 request.getContextPath() 메소드의 실행 결과를
	// URL의 앞부분에 추가하여 실행하게 된다.
	public static final String formPage = "/forms/calculatorForm.html";
	
	// Get 방식의 메소드 호출인 경우 Form 화면을 클라이언트에게 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// formPage로 정의된 url로 이동시킨다.
		// 서블릿에서의 페이지 전환 방법
		// 1. 리다이렉트를 이용한 페이지 전환 방법
		// - response 객체를 사용
		// - 이동할 페이지의 주소 (URL) 정보를
		//   response 객체의 sendRedirect 메소드의 매개변수로 전달하여 실행.
		// - 실행 과정
		//  a. 클라이언트의 요청
		//     (http://localhost:8080/day_02/calculator)
		//  b. 서블릿에서의 응답 처리
		//     (response.sendRedirect(formPage);
		//  c. 클라이언트의 웹 브라우저에서 formPage에 기술된 URL로 새로운 요청이 실행
		// - 리다이렉트를 사용하여 페이지를 이동하는 경우의 특징
		//  a. 새로운 요청이 실행되는 방식이므로 웹 브라우저의 URL이 변경
		//  b. 기존의 요청 객체에 저장된 모든 정보는 사라진다.
		
		// - 리다이렉트를 활용하는 경우
		//  a. 인증되지 않은 클라이언트를 로그인 페이지와 같은 경로로 이동하는 경우
		//  b. 에러가 발생한 경우 예외처리 페이지로 이동하는 경우
		
		// response.sendRedirect(formPage);
		
		// 현재 웹 어플리케이션의 이름을 추출하여 이동할 경로를 완성하는 방법
		// request.getContextPath() 메소드의 실행 결과는 /day_02가 된다
		response.sendRedirect(request.getContextPath() + formPage);
		
	}
	
	// Post 방식의 메소드 호출인 경우 Form에 입력된 정보를 사용하여 처리된 결과를 클라이언트에게 전달
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// // 1. 요청 객체의 인코딩 처리
		request.setCharacterEncoding("utf-8");
		// 2-1. 응답 객체의 인코딩 처리
		response.setContentType("text/html;charset=utf-8");
		// 2-2. 응답 스트림 객체 생성
		java.io.PrintWriter out = response.getWriter();
		
		// 3. 요청 객체로 부터 입력 값 추출
		String strNum1 = request.getParameter("num1").trim();
		String strOp = request.getParameter("op").trim();
		String strNum2 = request.getParameter("num2").trim();
		
		// 4. 예외처리
		int nNum1 = 0, nNum2 = 0;
		boolean isNumber = true;
		try {
			nNum1 = Integer.parseInt(strNum1);
			nNum2 = Integer.parseInt(strNum2);
		} catch (Exception e) {
			isNumber = false;
		}
		
		if( !isNumber ) {
			out.println("<h1>숫자만 입력이 가능합니다.</h1>");
			out.println("<h2>입력된 값 1 : " + strNum1 + "</h2>");
			out.println("<h2>입력된 값 2 : " + strNum2 + "</h2>");
			out.flush();
			return;
		}
		
		// 5. 처리 과정
		double result = 0;
		switch( strOp.charAt(0) ) {
			case '+' :	result = nNum1 + nNum2;	break;
			case '-' :	result = nNum1 - nNum2;	break;
			case '*' :	result = nNum1 * nNum2;	break;
			case '/' :	result = nNum1 / nNum2;	break;
			case '%' :	result = nNum1 % nNum2;	break;				
		}
		
		// 6. 출력
		out.println("<h1>계산 결과</h1>");
		out.println(String.format("<h2>%d %s %d = %.2f</h2>\n", 
				nNum1, strOp, nNum2, result));
		
	}

}
