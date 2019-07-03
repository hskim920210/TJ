package com.tje.pet;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	private String name;
	
	// 스프링 컨테이너 내부에서 @Autowired가 지정된
	// 멤버필드(변수)의 타입과 일치하는 스프링 빈 객체를 
	// 사용하여 자동으로 DI를 처리하는 어노테이션
	// 주의사항!
	// - 동일한 타입의 스프링 빈 객체가 2개 이상인 경우 에러 발생
	// - 동일한 타입의 스프링 빈 객체가 존재하지 않을 경우 에러 발생
	
	// Autowired 어노테이션의 required 속성의 값을 false로 지정하는 경우
	// 해당되는 타입의 빈 객체가 존재하지 않더라도 에러가 발생되지 않도록
	// 처리할 수 있다.
	@Autowired(required = false)
	private Pet pet;

	public Person() {}
	
	public Person(String name, Pet pet) {
		this.name = name;
		this.pet = pet;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	
}
