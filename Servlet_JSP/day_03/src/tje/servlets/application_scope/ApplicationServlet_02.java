package tje.servlets.application_scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/application_02")
public class ApplicationServlet_02 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ServletContext (Application 영역) 사용 시 주의사항
		// Application 영역 객체는 모든 클라이언트들이 공유하는 객체이다.
		// 공유되는 특징으로 인해 값의 수정 시, 올바르게 적용되도록 보장할 수 있어야 한다.
		// (동기화 처리 방법이 적용되야한다.)
		
		ServletContext application = request.getServletContext();
		
		Integer count_app = null;
		
		// 현재 똑같은 객체를 사용하는 것들은 대기해라. ( Application_02 인 객체는 모두 여기서 대기 )
		// 그러나 버그코드. 현재 이 서블릿에 접속한 사용자만 막을 수 있다.
		// 아래의 동기화 코드는 현재 서블릿으로 요청을 보낸 클라이언트들이
		// 블럭 상태로 빠지게 만드는 코드 (현재 서블릿만 락킹이 된다.
		// 만약 다른 서블릿에서 ServletContext를 수정하려는 경우
		// 동기화처리를 할 수 없다.
		// synchronized (this) { ~~~ }
		
		
		// 아래의 동기화 코드는 ServletContext 객체를 사용하여 
		// 동기화를 처리하는 코드이다.
		// 모든 서블릿에서 특정 ServletContext의 속성을 제어하려는 경우
		// 반드시 아래와 같이 동기화를 지정해야 한다.
		synchronized (application) {
			count_app = (Integer)application.getAttribute("count");
			if(count_app == null) {
				count_app = 1;
			} else {
				count_app ++;
			}
			application.setAttribute("count", count_app);
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		out.println("<h3>COUNT_APP : " + count_app + "</h3>");
	}
}