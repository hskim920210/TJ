package com.tje.model;

// private 생성자를 선언하여 사용하는 경우에
// Spring Bean 객체 생성에 문제가 발생할 수 있습니다.
// - private 으로 선언된 매개변수가 필요한 생성자만 사용하는 경우
// Spring 컨테이너에서 해당 클래스의 객체를 생성할 수 없습니다.
// 해결 방법
// a. 설정 파일(XML)에서 생성자의 필요한 매개변수를 직접 선언해서 사용하는 방법
// b. 설정 파일(XML)에서 해당 클래스의 객체를 생성하여 반환할 수 있는 static 메소드를 선언하는 방법
// (factory-method 속성에 기술하여 사용)
// 만약 해당 클래스의 객체를 생성하여 반환할 수 있는 static 메소드가 매개변수를 필요로 한다면,
// constructor-arg 태그를 사용하여 매개변수를 전달할 수 있습니다.

public class SingletonData {
	
	private int number;
	private static SingletonData instance ;
	
	public static SingletonData getInstance() {
		System.out.println("getInstance() 메소드 호출");
		if( instance == null ) {
			instance = new SingletonData(100);
		}
		return instance;
	}
	
	public static SingletonData getInstanceWithArg(int n) {
		System.out.println("getInstance(int n) 메소드 호출");
		if( instance == null ) {
			instance = new SingletonData(n);
		}
		return instance;
	}
	
	private SingletonData(int number) {
		System.out.println("매개변수를 사용한 생성자 호출");
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
