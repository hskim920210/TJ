package tje.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.Member;
import tje.service.*;

public class RegistCommand extends Command {
	private String formPage = "/WEB-INF/forms/regist.jsp";
	private String submitPage = "/WEB-INF/submits/regist.jsp";
	private String errorPage = "/WEB-INF/errors/regist.jsp";

	private MemberIDCheckService micService = new MemberIDCheckService();
	private MemberRegistService mrService = new MemberRegistService();

	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return formPage;
	}

	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int gender = intConvertor(request.getParameter("gender"));
		int age = intConvertor(request.getParameter("age"));
		int year = intConvertor(request.getParameter("year"));
		int month = intConvertor(request.getParameter("month"));
		int day = intConvertor(request.getParameter("day"));
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		Member member = new Member(member_id, password, name, gender, age, null, tel, address, null, null);
		member.setBirth(year, month, day);

		try (Connection conn = ConnectionProvider.getConnection()) {

			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("member", member);
			boolean result = (Boolean) micService.service(values).get("result");

			if (result) {
				request.setAttribute("errorMsg", "ID의 값이 중복되었습니다.");
				return formPage;
			}

			result = (Boolean) mrService.service(values).get("result");

			if (!result) {
				request.setAttribute("errorMsg", "가입과정에서 문제가 발생했습니다.(관리자에게 문의하세요)");
				return errorPage;
			}

			request.setAttribute("member", micService.service(values).get("searchedMember"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return submitPage;
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
