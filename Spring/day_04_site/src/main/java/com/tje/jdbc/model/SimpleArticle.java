package com.tje.jdbc.model;

import java.util.*;

public class SimpleArticle {
	private int article_id;
	private String title;
	private String member_id;
	private String name;
	private Date write_time;
	private int read_count;
	private int comment_count;

	public SimpleArticle() {
	}

	public SimpleArticle(int article_id, String title, String member_id, String name, Date write_time, int read_count, int comment_count) {
		this.article_id = article_id;
		this.title = title;
		this.member_id = member_id;
		this.name = name;
		this.write_time = write_time;
		this.read_count = read_count;
		this.comment_count = comment_count;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWrite_time() {
		return write_time;
	}

	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
}
