package tje.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/r_02")
public class RequestScopeServlet_02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새로운 요청이 발생하는 경우 request 객체가 새로 생성되기 때문에
		// 기존에 저장된 정보는 확인할 수 없다
		String msg = (String)request.getAttribute("msg");
		
		System.out.println("msg = " + msg);
	}
}
