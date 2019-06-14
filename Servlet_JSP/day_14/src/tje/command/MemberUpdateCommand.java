package tje.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.Member;
import tje.service.*;

public class MemberUpdateCommand extends Command {
	// GET 방식의 요청일 경우 반환할 페이지 정보
	private String formPage = "/WEB-INF/forms/update.jsp";
	// POST 방식의 요청일 경우 반환할 페이지 정보
	private String submitPage = "/WEB-INF/submits/update.jsp";
	private String errorPage = "/WEB-INF/errors/update.jsp";

	private MemberIDCheckService micService = new MemberIDCheckService();
	private MemberUpdateService muService = new MemberUpdateService();

	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {

		return formPage;
	}

	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");
		int age = intConvertor(request.getParameter("age"));
		java.sql.Date birth = strConvertor(request.getParameter("birth"));
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		HttpSession session = request.getSession();
		
		Member member = new Member(member_id, null, null, 0, age, birth, tel, address, null, null);

		try (Connection conn = ConnectionProvider.getConnection()) {
			HashMap<String, Object> values = new HashMap<>();
			HashMap<String, Object> resultMap = new HashMap<>();
			values.put("conn", conn);
			values.put("member", member);
			values.put("type", "update");
			boolean result = (boolean) muService.service(values).get("result");
			if (result) {
				resultMap = micService.service(values);
				Member updatedMember = (Member) resultMap.get("searchedMember");
				request.setAttribute("updatedMember", updatedMember);
				session.setAttribute("login_member", updatedMember);
				return submitPage;
			}

			if (!result) {
				request.setAttribute("errorMsg", "정보 수정 과정에서 문제가 발생했습니다. (관리자에게 문의하세요.)");
				return errorPage;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return submitPage;
	}

	
	private java.sql.Date strConvertor(String source) {
		java.sql.Date date = null;
		date = java.sql.Date.valueOf(source);
		return date;
	}
	
	
	private int intConvertor(String source) {
		int data = 0;
		try {
			data = Integer.parseInt(source);
		} catch (Exception e) {
			;
		}
		return data;
	}
}
