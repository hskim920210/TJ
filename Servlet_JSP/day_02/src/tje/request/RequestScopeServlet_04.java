package tje.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/r_04")
public class RequestScopeServlet_04 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 포워딩을 사용하여 다른 서블릿으로 이동하는 경우
		// request 영역의 값이 유지된다.
		// (아래의 msg 값은 RequestScopeServlet_03 에서 설정한 값이 된다.)
		String msg = (String)request.getAttribute("msg");
		
		System.out.println("msg = " + msg);
	}
}
