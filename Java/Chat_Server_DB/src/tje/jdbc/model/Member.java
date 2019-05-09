package tje.jdbc.model;

import java.io.*;
import java.util.*;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String password;
	private String name;
	private String nick;
	private Date regist_date;

	public Member() {
	}

	public Member(String id, String password, String name, String nick, Date regist_date) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nick = nick;
		this.regist_date = regist_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}

}
