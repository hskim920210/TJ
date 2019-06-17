package tje.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;

import tje.dao.SimpleArticleDAO;
import tje.jdbc.util.*;
import tje.model.*;
import tje.service.*;

public class ArticleCommand extends Command {
	private String formPage = "/WEB-INF/forms/article.jsp";
	private String submitPage = "/WEB-INF/submits/article.jsp";
	private String errorPage = "/WEB-INF/errors/article.jsp";

	private ArticleListService alService = new ArticleListService();
	private ArticleSearchService asService = new ArticleSearchService();
	private CommentCountService ccService = new CommentCountService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			
			HashMap<String, Object> resultMap = alService.service(values);
			request.setAttribute("articleList", resultMap.get("articleList"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return formPage;
	}

	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String searchItem = request.getParameter("searchItem");
		String searchValue = request.getParameter("searchValue");
				
		try (Connection conn = ConnectionProvider.getConnection()) {
			
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("searchItem", searchItem);
			values.put("searchValue", searchValue);
			
			HashMap<String, Object> resultMap = asService.service(values);
			request.setAttribute("articleSearch", resultMap.get("articleSearch"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return submitPage;
	}
}
