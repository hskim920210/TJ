package tje.service;

import java.sql.*;
import java.util.*;
import tje.dao.*;
import tje.model.*;

public class ArticleSearchService implements Service {
	private SimpleArticleDAO simpleArticleDAO = new SimpleArticleDAO();
	
	public HashMap<String, Object> service(HashMap<String, Object> values) {
		HashMap<String, Object> result = new HashMap<>();
		Connection conn = (Connection)values.get("conn");
		String searchItem = (String)values.get("searchItem");
		String searchValue = (String)values.get("searchValue");
		result.put("articleSearch", simpleArticleDAO.select(conn, searchItem, searchValue));
		
		return result;
	}
}







