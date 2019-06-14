package tje.command;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tje.jdbc.util.ConnectionProvider;
import tje.service.ArticleListService;

public class MainCommand extends Command {
	private String formPage = "/WEB-INF/forms/main.jsp";
	private String submitPage = null;
	private String errorPage = null;
		

	private ArticleListService alService = new ArticleListService();
	
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			HashMap<String, Object> resultMap = alService.service(values);

			request.setAttribute("articleCount", resultMap.get("articleCount"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formPage;
	}
	
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return submitPage;
	}
	
	
}














