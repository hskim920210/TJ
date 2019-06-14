package tje.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.DetailArticle;
import tje.model.Member;
import tje.service.*;

public class ArticleWriteCommand extends Command {
	private String formPage = "/WEB-INF/forms/article_write.jsp";
	private String submitPage = "/WEB-INF/submits/article_write.jsp";
	private String errorPage = "/WEB-INF/errors/article_write.jsp";

	private ArticleWriteService awService = new ArticleWriteService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		
		return formPage;
	}

	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Member member = (Member)request.getSession().getAttribute("login_member");
		DetailArticle da = new DetailArticle(
				0, 
				member.getMember_id(), 
				member.getName(), 
				title, 
				content, 
				null,
				null, 
				0);
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("detailArticle", da);
			HashMap<String, Object> resultMap = awService.service(values);

			request.setAttribute("articleWrite", resultMap.get("articleWrite"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return submitPage;
	}
}
