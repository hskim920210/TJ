package tje.servlets.request_scope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request_ex")
public class RequestEXServlet extends HttpServlet {
	
	// 포워딩을 할 HTML 파일의 경로를 기술
	// 포워딩의 경우 /는 WebContents를 의미한다.
	private static final String formPage = "/WEB-INF/forms/inputNumberForm.html";
	// POST 방식의 요청인 경우
	// 포워딩을 통해서 이동할 서블릿 클래스의 URL을 기술한다.
	private static final String nextPage = "/request_ex_plus";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNum1 = request.getParameter("num1").trim();
		String strNum2 = request.getParameter("num2").trim();
		
		boolean checkNumbers = true;
		int num1 = 0;
		int num2 = 0;
		
		try {
			num1 = Integer.parseInt(strNum1);
			num2 = Integer.parseInt(strNum2);
		} catch(Exception e) {
			checkNumbers = false;
		}
		
		if ( !checkNumbers ) {
			response.setContentType("text/html;charset=utf-8");
			java.io.PrintWriter out = response.getWriter();
			
			out.println("<h2>ERROR</h2>");
			out.println("<h3>숫자 타입을 입력하세요.</h3>");
			out.flush();
			return;
		}
		
		// 사용자에게 받은 숫자를 리퀘스트영역에 저장하고 다음페이지로 이동시킬것이다.
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
	}
}