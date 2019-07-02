package com.tje.model;

public class Dog implements Pet {

	@Override
	public void sound() {
		System.out.println("멍멍~");
	}

	@Override
	public void action() {
		System.out.println("꼬리를 흔듭니다~");
	}

}
