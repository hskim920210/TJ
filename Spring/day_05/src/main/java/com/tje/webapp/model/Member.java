package com.tje.webapp.model;

public class Member {
	private String id;
	private String name;
	private int age;
	private boolean agree;
	public Member() {
	}
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public Member(String id, String name, int age, boolean agree) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.agree = agree;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isAgree() {
		return agree;
	}
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	
	
}
