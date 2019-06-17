package tje.model;

import java.util.*;
import java.text.*;

public class DetailArticle {
	private int article_id;
	private String member_id;
	private String name;
	private String title;
	private String content;
	private Date write_time;
	private Date last_update_time;
	private int read_count;

	public DetailArticle() {
	}

	public DetailArticle(int article_id, String member_id, String name, String title, String content, Date write_time,
			Date last_update_time, int read_count) {

		this.article_id = article_id;
		this.member_id = member_id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.write_time = write_time;
		this.last_update_time = last_update_time;
		this.read_count = read_count;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrite_timeString() {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		return sdf.format(write_time);
	}

	public Date getWrite_time() {
		return write_time;
	}

	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}

	public String getLast_update_timeString() {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		return sdf.format(last_update_time);
	}

	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

}
