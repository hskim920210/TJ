package tje.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;

import tje.jdbc.util.*;
import tje.model.*;
import tje.service.*;

public class WriteArticleCommand extends Command {
	private String formPage = "/WEB-INF/forms/write_article.jsp";
	private String submitPage = "/WEB-INF/submits/write_article.jsp";
	private String errorPage = "/WEB-INF/errors/write_article.jsp";

	private ArticleInsertService aiService = new ArticleInsertService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return formPage;
	}

	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("login_member");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");		
		
		DetailArticle model = new DetailArticle(0, 
				member.getMember_id(), 
				null, 
				title, content, 
				null, null, 0);
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("model", model);
			
			HashMap<String, Object> resultMap = aiService.service(values);
			request.setAttribute("result", resultMap.get("result"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return submitPage;
	}
}
