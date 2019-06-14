package tje.service;

import java.sql.*;
import java.util.*;
import tje.dao.*;
import tje.model.*;

public class ArticleDetailSearchService implements Service {
	private DetailArticleDAO detailArticleDAO = new DetailArticleDAO();
	
	public HashMap<String, Object> service(HashMap<String, Object> values) {
		HashMap<String, Object> result = new HashMap<>();
		Connection conn = (Connection)values.get("conn");
		DetailArticle model = (DetailArticle)values.get("model");
		result.put("detailArticle", detailArticleDAO.selectOne(conn, model));
		result.put("result", result.get("detailArticle") != null);
		
		return result;
	}
}







