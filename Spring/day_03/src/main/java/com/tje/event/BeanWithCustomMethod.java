package com.tje.event;

public class BeanWithCustomMethod {
	
	public BeanWithCustomMethod() {
		System.out.println("생성자 메소드 실행");
	}

	public void init() {
		System.out.println("init 메소드 실행");
	}

	public void destroy() {
		System.out.println("destroy 메소드 실행");
	}
	
}
