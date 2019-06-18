package khs.command;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import khs.jdbc.util.*;
import khs.model.*;

public class MainCommand extends Command {
	private String formPage = "/WEB-INF/forms/main.jsp";
	private String submitPage = "/WEB-INF/submits/main.jsp";
	private String errorPage = null;
		

	// private ArticleListService alService = new ArticleListService();
	
	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return formPage;
	}
		
		
		
		
//		try (Connection conn = ConnectionProvider.getConnection()) {
//			HashMap<String, Object> values = new HashMap<>();
//			values.put("conn", conn);
//			HashMap<String, Object> resultMap = alService.service(values);
//
//			request.setAttribute("articleCount", resultMap.get("articleCount"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return formPage;
	
	
	
	
	
	
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return submitPage;
	}
	
	
}














