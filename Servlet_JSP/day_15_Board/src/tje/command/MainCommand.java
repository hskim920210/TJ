package tje.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tje.jdbc.util.*;
import java.sql.*;
import tje.service.*;
import java.util.*;

public class MainCommand extends Command {
	private String formPage = "/WEB-INF/forms/main.jsp";
	private String submitPage = null;
	private String errorPage = null;

	
	private ArticleCountService acService = new ArticleCountService();
	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		// 널체크를 우선해야 session. 에서 널포인터 익셉션이 일어나지 않는다.
		if( session == null || session.getAttribute("login_member") == null) {
			return formPage;
		};
		
		// 로그인이 된 사용자만 하기 위한거라 효율이 그닥. 로그인 먼저 체크한다.
		try(Connection conn = ConnectionProvider.getConnection()){
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			request.setAttribute("articleCount", acService.service(values).get("articleCount"));
		} catch (Exception e) {
			
		}
		return formPage;
	}
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return submitPage;
	}
	
}














