package tje.service;

import java.sql.*;
import java.util.*;
import tje.dao.*;
import tje.model.*;

public class ArticleWriteService implements Service {
	private DetailArticleDAO detailArticleDAO = new DetailArticleDAO();
	
	public HashMap<String, Object> service(HashMap<String, Object> values) {
		HashMap<String, Object> result = new HashMap<>();
		Connection conn = (Connection)values.get("conn");
		DetailArticle detailArticle = (DetailArticle)values.get("detailArticle");
		
		result.put("articleWrite", detailArticleDAO.insert(conn, detailArticle));
		
		return result;
	}
}







