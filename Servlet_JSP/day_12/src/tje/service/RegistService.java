package tje.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistService extends Service {
	// GET 방식의 요청일 경우 반환할 페이지 정보
		private String formPage = "/WEB-INF/forms/regist.jsp";
		// POST 방식의 요청일 경우 반환할 페이지 정보
		private String submitPage = "/WEB-INF/submits/registSubmit.jsp";
		private String alreadyPage = "/WEB-INF/errors/already.jsp";
			
		// GET 요청일 경우의 처리 로직을 구현하는 메소드
		protected String processForm(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(false);
			boolean isLogin = false;
			if( session != null && session.getAttribute("login_id") != null )
				isLogin = true;				
			
			if( isLogin ) {
				return alreadyPage;			
			}
			
			return formPage;
		}
		
		// POST 요청일 경우의 처리 로직을 구현하는 메소드
		protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
			return submitPage;
		}
}
