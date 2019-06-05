package tje.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class CharacterEncodingFilter implements Filter {
	private String strEncoding;

	public void init(FilterConfig filterConfig) throws ServletException {
		strEncoding = filterConfig.getInitParameter("encoding");
		System.out.println(strEncoding);
		Filter.super.init(filterConfig);
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("CharacterEncodingFilter 실행");
		request.setCharacterEncoding(strEncoding);
		
		chain.doFilter(request, response);
		
	}

}
