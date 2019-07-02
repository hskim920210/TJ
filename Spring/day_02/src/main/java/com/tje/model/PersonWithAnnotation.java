package com.tje.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PersonWithAnnotation {
	private String name;
	
	// Pet 타입의 객체를 스프링 컨테이너를 통해 주입받음.
	// - 일반적으로 생성자, 프로퍼티를 사용하여 값을 주입받음.
	// 반면, 명시적인(생성자, Setter 메소드)의 사용없이
	// DI를 구연하기 위해 제공되는 어노테이션 기반의 방법
	// - @Autowired 어노테이션
	// - 현재 스프링 컨테이너 내부에 @Autowired가 적용된 멤버 필드와
	//   "동일한 타입의 객체"가 존재한다면 자동으로 DI가 구현
	//   멤버필드나 메소드, 겟터,셋터 앞에 붙이곤 한다.
	// - @Autowired를 적용하여 자동으로 DI를 구현하는 경우,
	//   해당 타입의 객체는 스프링 컨테이너에 단 하나만 존재해야 한다.
	//   스프링 컨테이너 생성시, 런타임 오류 발생)
	@Autowired
	// @Qualifier 어노테이션
	// - @Autowired와 같이 사용되며, 만약 스프링 컨테이너 내부에
	//   @Autowired로 지정된 타입의 객체가 다수개 존재하는 경우
	//   특정 객체만을 자동으로 DI 할 수 있도록 제어하는 어노테이션
	@Qualifier("happy")
	private Pet pet;


	public PersonWithAnnotation() {}

	public PersonWithAnnotation(Pet pet) {
		this.pet = pet;
	}
	public PersonWithAnnotation(String name, Pet pet) {
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
