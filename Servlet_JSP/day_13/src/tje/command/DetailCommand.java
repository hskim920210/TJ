package tje.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.Member;
import tje.service.*;

public class DetailCommand extends Command {
	private String formPage = "/WEB-INF/forms/detail.jsp";
	private String submitPage = "/WEB-INF/submits/detail.jsp";
	private String errorPage = "/WEB-INF/errors/detail.jsp";

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return formPage;
	}	
	
	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	/*
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");
		String save_member_id = request.getParameter("save_member_id");
		
		Member member = new Member(member_id, password, 
				null, 0, 0, null, 
				null, null, null, null);
		
		Connection conn = ConnectionProvider.getConnection();
		
		HashMap<String, Object> values = new HashMap<>();
		values.put("conn", conn);
		values.put("member", member);
		HashMap<String, Object> resultMap = micService.service(values);
		
		if( !(boolean)resultMap.get("result") ) {
			request.setAttribute("errorMsg_ID", "ID의 값이 존재하지 않습니다.");
			return formPage;
		}

		Member searchedMember = (Member)resultMap.get("searchedMember");
		boolean isLogin = 
				searchedMember.getPassword().equals(member.getPassword());
		
		if( !isLogin ) {
			request.setAttribute("errorMsg_PASSWORD", "ID와 PASSWORD를 확인하세요.");
			return formPage;
		}
		
		values.put("type", "last_access_time");
		resultMap = muService.service(values);
		
		if( !(boolean)resultMap.get("result") ) {
			request.setAttribute("errorMsg", "로그인 과정에서 문제가 발생했습니다.(관리자에게 문의하세요)");
			return errorPage;
		}
		
		// 로그인 성공!
		HttpSession session = request.getSession();
		
		searchedMember.setLast_access_time(new java.util.Date());		
		session.setAttribute("login_member", searchedMember);
				
		if( save_member_id != null && save_member_id.equals("true") )
			response.addCookie(new Cookie("save_member_id", member_id));
		
		Closer.close(conn);
		
		return submitPage;
		}
		*/
		
}
