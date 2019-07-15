package com.tje.jdbc.service;


import org.springframework.transaction.annotation.Transactional;

import com.tje.jdbc.dao.*;
import com.tje.jdbc.model.*;

public class ArticleDeleteService {
	private DetailArticleDAO daDAO;
	private CommentDAO cDAO;
	public ArticleDeleteService(DetailArticleDAO daDAO, CommentDAO cDAO) {
		this.daDAO = daDAO;
		this.cDAO = cDAO;
	}
	
	@Transactional
	public int service() {
		int result = 0;
		DetailArticle da = new DetailArticle();
		da.setArticle_id(3);
		Comment comment = new Comment();
		comment.setArticle_id(3);
		
		daDAO.delete(da);
		result += 1;
		cDAO.delete(comment);
		result += 1;
		
		return result;
	}
}
