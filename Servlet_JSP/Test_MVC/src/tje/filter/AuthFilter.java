package tje.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/auth/*")
public class AuthFilter implements Filter {
	
	private static final String authPage = "/error/authPage.jsp"; 
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 사용자의 로그인 여부에 따라
		// 실제 요청을 처리할지 결정
		// (로그인이 안된 상태라라면 authPage로 리다이렉트)
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(false);
		if( session == null || session.getAttribute("login_id") == null) {
			HttpServletResponse res = 
					(HttpServletResponse)response;
			res.sendRedirect(
					req.getContextPath() + authPage);
			return;
		}
		
		chain.doFilter(request, response);
		
	}	

}








