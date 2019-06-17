package tje.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import tje.jdbc.util.*;
import tje.model.*;
import tje.service.*;

public class WriteCommentCommand extends Command {
	private String formPage = null;
	private String submitPage = "/auth/article_detail.do?article_id=";
	private String errorPage = "/WEB-INF/errors/write_comment.jsp";

	private CommentInsertService ciService = new CommentInsertService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return formPage;
	}

	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("login_member");
		
		String strArticle_id = request.getParameter("article_id");
		int article_id = 0;
		try {
			article_id = Integer.parseInt(strArticle_id);
		}catch (Exception e) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			return errorPage;
		}		
		String content = request.getParameter("content");
		
		Comment model = new Comment(
				0, article_id, 
				member.getMember_id(), 
				content, null);
		
		boolean result = false;
		int last_id = 0;
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("model", model);
			
			HashMap<String, Object> resultMap = ciService.service(values);
			result = (Boolean) resultMap.get("result");
			last_id = (Integer)resultMap.get("id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.setWrite_time(new java.util.Date());
		String output = 
			String.format("{ \"result\" : \"%b\", \"article_id\" : \"%d\", \"member_id\" : \"%s\", \"comment_id\" : \"%d\", \"content\" : \"%s\", \"date\" : \"%s\" }", 
					result, article_id, member.getMember_id(), last_id, content, model.getWrite_timeString());
		out.println(output);
		out.flush();
		out.close();
		if(result) {
		} else {
			
		}

		return null;
	}
}
