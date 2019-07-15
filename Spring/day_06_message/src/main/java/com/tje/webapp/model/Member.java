package com.tje.webapp.model;

public class Member {
	private String member_id;
	private String password;
	private String name;
	private boolean rememberID;
	
	public Member() {
	}
	
	public Member(String member_id, String password, String name, boolean rememberID) {
		this.member_id = member_id;
		this.password = password;
		this.name = name;
		this.rememberID = rememberID;
	}

	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public boolean isRememberID() {
		return rememberID;
	}

	public void setRememberID(boolean rememberID) {
		this.rememberID = rememberID;
	}

}
