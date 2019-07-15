package com.tje.jdbc.model;

import java.util.*;

public class Comment {
	private int comment_id;
	private int article_id;
	private String member_id;
	private String content;
	private Date write_time;

	public Comment() {}

	public Comment(int comment_id, int article_id, String member_id, String content, Date write_time) {
		this.comment_id = comment_id;
		this.article_id = article_id;
		this.member_id = member_id;
		this.content = content;
		this.write_time = write_time;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getWrite_time() {
		return write_time;
	}

	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}
}
