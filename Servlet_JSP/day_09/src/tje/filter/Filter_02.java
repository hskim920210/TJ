package tje.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/fs_02")
public class Filter_02 implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// chain.doFilter(request, response);
		// 실행 코드의 앞은 서블릿 또는 JSP로 실제 요청 객체가
		// 전달되기 전에 실행되는 영역
		// 인코딩 처리와 같은 작업을 실행할 수 있는 영역
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(request, response);
		System.out.println("Filter_01의 doFilter 메소드 실행(AFTER)");
	}
	
	public void destroy() {
	}
}
