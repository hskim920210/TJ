package tje.service;

import java.sql.*;
import java.util.*;
import tje.dao.*;
import tje.model.*;

public class ArticleListService implements Service {
	private SimpleArticleDAO simpleArticleDAO = new SimpleArticleDAO();
	
	public HashMap<String, Object> service(HashMap<String, Object> values) {
		HashMap<String, Object> result = new HashMap<>();
		Connection conn = (Connection)values.get("conn");
				
		result.put("articleList", simpleArticleDAO.selectAll(conn));
		result.put("articleCount", simpleArticleDAO.selectCount(conn));
		
		return result;
	}
}







