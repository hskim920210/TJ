package tje.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import tje.mvc.service.ByeService;
import tje.mvc.service.HelloService;
import tje.mvc.service.Service;

@WebServlet("*.do3")
public class Controller_03 extends HttpServlet {	
	private HashMap<String, Service> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 컨트롤러에 첫번째 요청이 들어오게 되면
		// HashMap에 URI 정보와 URI 정보가 들어올때
		// 실행할 Service 객체를 저장
		map.put("/hello.do3", new HelloService());
		map.put("/bye.do3", new ByeService());
		map.put("/msg.do3", new HelloService());
		
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 클라이언트의 요청 URI를 추출하여 변수로 저장
		String requestURI = 
				request.getRequestURI().substring(
						request.getContextPath().length());
		
		String viewPage = null;
		Service service = null;
		
		if( (service = map.get(requestURI)) != null )			
			viewPage = service.service(request, response);
		else
			response.sendError(404);
		
		if( viewPage != null )
			request.getRequestDispatcher(viewPage).forward(request, response);		
	}
}












