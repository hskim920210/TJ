package com.personal.khs.model;

import java.util.*;

public class User {
	private String user_id;
	private String user_pw;
	private String user_nick;
	private String user_tel;
	private String user_mail;
	private Date user_regist_date;
	private int user_count_day;
	// 아이디 저장 체크박스에 사용할 변수
	private boolean idSave;

	public User() {
	}
	
	public User(String user_id, String user_pw, String user_nick, String user_tel, String user_mail,
			Date user_regist_date, int user_count_day, boolean idSave) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nick = user_nick;
		this.user_tel = user_tel;
		this.user_mail = user_mail;
		this.user_regist_date = user_regist_date;
		this.user_count_day = user_count_day;
		this.idSave = idSave;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public Date getUser_regist_date() {
		return user_regist_date;
	}

	public void setUser_regist_date(Date user_regist_date) {
		this.user_regist_date = user_regist_date;
	}

	public int getUser_count_day() {
		return user_count_day;
	}

	public void setUser_count_day(int user_count_day) {
		this.user_count_day = user_count_day;
	}

	public boolean isIdSave() {
		return idSave;
	}

	public void setIdSave(boolean idSave) {
		this.idSave = idSave;
	}
	
}
