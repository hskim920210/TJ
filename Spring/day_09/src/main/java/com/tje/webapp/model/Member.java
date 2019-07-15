package com.tje.webapp.model;

public class Member {
	private String id;
	private String password;
	private String name;
	private boolean rememberID;

	public Member() {
	}
	
	public Member(String id, String password, String name, boolean rememberID) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.rememberID = rememberID;
	}

	public boolean isRememberID() {
		return rememberID;
	}

	public void setRememberID(boolean rememberID) {
		this.rememberID = rememberID;
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
	
}
