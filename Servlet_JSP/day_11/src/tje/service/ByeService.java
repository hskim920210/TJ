package tje.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByeService extends Service {
	private String formPage = "/WEB-INF/views/bye.jsp";
	private String submitPage = "/WEB-INF/views/bye.jsp";
		
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("ByeMsg", "조심히 들어가세요~!");
		return formPage;
	}
	
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return submitPage;
	}
	
	
}














