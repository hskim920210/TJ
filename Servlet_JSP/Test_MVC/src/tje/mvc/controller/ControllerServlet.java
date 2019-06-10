package tje.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tje.mvc.service.*;

import java.util.*;

@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {	
	private HashMap<String, Service> uriMap = new HashMap<>();

	public void init(ServletConfig config) throws ServletException {
		uriMap.put("/main.do", new MainService());
		uriMap.put("/login.do", new LoginService(config));
		uriMap.put("/regist.do", new RegistService(config));
		uriMap.put("/auth/logout.do", new LogoutService(config));
		uriMap.put("/auth/list.do", new ListService(config));
		uriMap.put("/auth/detail.do", new DetailService(config));
		uriMap.put("/auth/update.do", new UpdateService(config));		
		uriMap.put("/auth/delete.do", new DeleteService(config));		

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
		
		if( (service = uriMap.get(requestURI)) != null )			
			viewPage = service.service(request, response);
		else
			response.sendError(404);
		
		if( viewPage != null )
			request.getRequestDispatcher(viewPage).forward(request, response);		
	}

}
