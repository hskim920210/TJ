package tje.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.Member;
import tje.service.*;

public class LogoutCommand extends Command {
	private String formPage = "/WEB-INF/forms/logout.jsp";
	private String submitPage = "/WEB-INF/submits/logout.jsp";
	private String errorPage = "/WEB-INF/errors/logout.jsp";

	private MemberUpdateService muService = new MemberUpdateService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {

		return formPage;
	}

	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute("login_member");

		try (Connection conn = ConnectionProvider.getConnection()) {

			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("member", member);
			values.put("type", "last_access_time");
			HashMap<String, Object> resultMap = muService.service(values);

			if (!(boolean) resultMap.get("result")) {
				request.setAttribute("errorMsg", "로그아웃 과정에서 문제가 발생했습니다.(관리자에게 문의하세요)");
				return errorPage;
			}

			// 로그아웃 성공!
			session.invalidate();
			request.setAttribute("logout_member", member);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return submitPage;
	}

}
