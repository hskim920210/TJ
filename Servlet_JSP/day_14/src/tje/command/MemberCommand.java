package tje.command;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.Member;
import tje.service.*;

public class MemberCommand extends Command {
	private String formPage = "/WEB-INF/forms/member.jsp";
	private String submitPage = "/WEB-INF/submits/member.jsp";
	private String errorPage = "/WEB-INF/errors/member.jsp";

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return formPage;
	}

	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("login_member");
		boolean isPasswordCheck = member.getPassword().equals(password);
		
		if( isPasswordCheck ) {
			// 패스워드를 잘 입력한 사람에게 성공했다는 기록을 남ㄴ김
			session.setAttribute("member_id_detail", member.getMember_id());
		} else {
			request.setAttribute("errorMsg", "PASSWORD를 확인하세요.");
			return errorPage;
		}

		return submitPage;
	}

}
