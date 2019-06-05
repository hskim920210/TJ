package tje.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/fs_03")
public class Filter_03 implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 요청에 대한 사전 작업(request에 대한 작업)
		
		chain.doFilter(request, response);
		
		// 응답에 대한 사후 작업(response에 대한 작업)
		
		// chain.doFilter(request, response);
		// 실행 코드의 뒷 부분은 서블릿 또는 JSP가 모든 실행을 종료한 이후에 실행되는 영역
		// 쿠키를 응답에 추가하는 등과 같은 작업을 수행할 수 있다.
		String name = request.getParameter("name");
		if( name != null ) {
			Cookie cookie = new Cookie("name", name);
			HttpServletResponse res = (HttpServletResponse)response;
			res.addCookie(cookie);
		}
	}
	
	public void destroy() {
	}
}
