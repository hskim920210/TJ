package khs.command;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import khs.jdbc.util.*;
import khs.model.*;
import khs.service.*;

public class LoginCommand extends Command {
	private String formPage = "/WEB-INF/forms/login.jsp";
	private String submitPage = "/WEB-INF/submits/login.jsp";
	private String errorPage = "/WEB-INF/errors/login.jsp";

	private UserIDCheckService uicService = new UserIDCheckService();
	private UserUpdateService uuService = new UserUpdateService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String save_user_id = request.getParameter("save_user_id");

		User user = new User(user_id, user_pw, null, 0, null, null, 0);

		try (Connection conn = ConnectionProvider.getConnection()) {

			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("user", user);
			HashMap<String, Object> resultMap = uicService.service(values);

			if (!(boolean) resultMap.get("result")) {
				request.setAttribute("errorMsg", "ID의 값이 존재하지 않습니다.");
				return errorPage;
			}

			User searchedUser = (User) resultMap.get("searchedUser");
			boolean isLogin = searchedUser.getUser_pw().equals(user.getUser_pw());

			if (!isLogin) {
				request.setAttribute("errorMsg", "ID와 PASSWORD를 확인하세요.");
				return errorPage;
			}

			values.put("type", "isLogin");
			resultMap = uuService.service(values);

			if (!(boolean) resultMap.get("result")) {
				request.setAttribute("errorMsg", "날짜 일수 계산 과정에서 에러가 발생했습니다. 관리자에게 문의하세요.");
				return errorPage;
			}

			// 로그인 성공!
			HttpSession session = request.getSession();
			ServletContext application = request.getServletContext();
			synchronized (application) {
				if (application.getAttribute("login_user_count") == null)
					application.setAttribute("login_user_count", 1);
				else {
					Integer count = (Integer) application.getAttribute("login_user_count");
					application.setAttribute("login_user_count", count + 1);
				}
			}

			session.setAttribute("login_user", searchedUser);

			if (save_user_id != null && save_user_id.equals("true")) {
				response.addCookie(new Cookie("save_user_id", user_id));
			} else {
				Cookie cookie = new Cookie("save_user_id", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return submitPage;
	}

}
