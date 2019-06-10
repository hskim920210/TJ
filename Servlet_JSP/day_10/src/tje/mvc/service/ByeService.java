package tje.mvc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByeService extends Service {
	// GET 방식의 요청일 경우 반환할 페이지 정보
	private String formPage = "/WEB-INF/views/bye.jsp";
	// POST 방식의 요청일 경우 반환할 페이지 정보
	private String submitPage = "/WEB-INF/views/bye.jsp";
		
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("ByeMsg", "조심히 들어가세요~!");
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return submitPage;
	}
	
	
}














