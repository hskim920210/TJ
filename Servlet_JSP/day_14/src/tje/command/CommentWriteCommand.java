package tje.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.*;
import tje.service.*;

public class CommentWriteCommand extends Command {
	private String formPage = null;
	private String submitPage = "/auth/article_detail.do?article_id=";
	private String errorPage = "/WEB-INF/errors/comment_write.jsp";

	private CommentInsertService ciService = new CommentInsertService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return formPage;
	}

	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("login_member");
		
		String strArticle_id = request.getParameter("article_id");
		int article_id = 0;
		try {
			article_id = Integer.parseInt(strArticle_id);
		} catch (Exception e) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			return errorPage;
		}
		String content = request.getParameter("content");
		
		Comment model = new Comment(0, article_id, member.getMember_id(), content, null);
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("model", model);
			HashMap<String, Object> resultMap = ciService.service(values);
			
			if(!(boolean)resultMap.get("result")) {
				request.setAttribute("errorMsg", "댓글 저장 과정에서 문제가 발생했습니다. (관리자에게 문의하세요.)");
				return errorPage;
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return submitPage + article_id;
		
	}
}
