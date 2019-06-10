package tje.mvc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모든 서비스 클래스의 부모 클래스
// (추상클래스로 선언하여 객체는 생성할 수 없음)
public abstract class Service {
	public String service(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		if( method.equals("GET") ) {
			return processForm(request, response);
		} else if( method.equals("POST") ) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}	
	protected abstract String processForm(HttpServletRequest request, HttpServletResponse response);
	protected abstract String processSubmit(HttpServletRequest request, HttpServletResponse response);	
}














