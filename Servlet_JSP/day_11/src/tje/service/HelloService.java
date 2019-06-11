package tje.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloService extends Service {
	private String formPage = "/WEB-INF/views/hello.jsp";
	private String submitPage = "/WEB-INF/views/hello.jsp";
			
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("HelloMsg", "안녕하세요~!");
		return formPage;
	}
	
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return submitPage;
	}
	
	
}














