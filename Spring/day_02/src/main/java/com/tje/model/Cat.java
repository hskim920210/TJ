package com.tje.model;

public class Cat implements Pet {

	@Override
	public void sound() {
		System.out.println("야옹~");
	}

	@Override
	public void action() {
		System.out.println("캣타워에 올라갑니다~");
	}

}
