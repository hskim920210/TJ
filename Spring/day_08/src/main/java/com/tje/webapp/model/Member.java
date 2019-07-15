package com.tje.webapp.model;

public class Member {
	private String member_id;
	private String password;
	private String name;
	private boolean idSave;

	public Member() {
	}

	public Member(String member_id, String password, String name, boolean idSave) {
		this.member_id = member_id;
		this.password = password;
		this.name = name;
		this.idSave = idSave;
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

	public boolean isIdSave() {
		return idSave;
	}

	public void setIdSave(boolean idSave) {
		this.idSave = idSave;
	}
	
	
	
}
