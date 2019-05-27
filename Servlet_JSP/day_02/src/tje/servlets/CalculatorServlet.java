package tje.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forms/calculator")
public class CalculatorServlet extends HttpServlet {

	
	// get은 url을 받아 form을 보여주고
	// post는 처리를 하여 결과를 보여준다
	
	// Get 방식의 메소드 호출인 경우 Form 화면을 클라이언트에게 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 응답 객체의 인코딩 처리
		response.setContentType("text/html;charset=utf-8");
		// 2. 응답 스트림 객체 생성
		java.io.PrintWriter out = response.getWriter();
		
		// 3. form을 구성하는 html 문서 작성
		StringBuilder form = new StringBuilder();
		form.append("<h2>계산 수식 입력 화면</h2>");
		form.append("<form action=\"./calculator\" method=\"post\">");
		form.append("<table>");
		form.append("<tr>");
		form.append("<th>NUM1</th>");
		form.append("<th>OP</th>");
		form.append("<th>NUM2</th>");
		form.append("<th rowspan=\"2\"><input type=\"submit\" value=\"실행\"></th>");
		form.append("</tr>");
		form.append("<tr>");
		form.append("<td><input type=\"text\" name=\"num1\" required></td>");
		form.append("<td>");
		form.append("<select name=\"op\">");
		form.append("<option value=\"+\" selected>+</option>");
		form.append("<option value=\"-\">-</option>");
		form.append("<option value=\"*\">*</option>");
		form.append("<option value=\"/\">/</option>");
		form.append("<option value=\"%\">%</option>");
		form.append("</select");
		form.append("</td>");
		form.append("<td><input type=\"text\" name=\"num2\" required></td>");
		form.append("</tr>");
		form.append("</table>");
		form.append("</form>");
		
		// 4. html 문서를 클라이언트에게 전송
		out.println(form.toString());
	}
	
	
	
	// Post 방식의 메소드 호출인 경우 Form에 입력된 정보를 사용하여 처리된 결과를 클라이언트에게 전달
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 객체의 인코딩 처리
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