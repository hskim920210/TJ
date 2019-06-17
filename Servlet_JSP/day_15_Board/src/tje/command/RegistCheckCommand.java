package tje.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.Member;
import tje.service.*;

public class RegistCheckCommand extends Command {

	private MemberIDCheckService micService = new MemberIDCheckService();

	// GET 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");

		Member member = new Member();
		member.setMember_id(member_id);

		
		boolean result = false;
		try (Connection conn = ConnectionProvider.getConnection()) {

			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("member", member);
			result = (Boolean) micService.service(values).get("result");

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("text/plane;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
