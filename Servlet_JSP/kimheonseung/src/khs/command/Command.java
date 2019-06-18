package khs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
	public String process(HttpServletRequest request, HttpServletResponse response) {
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
