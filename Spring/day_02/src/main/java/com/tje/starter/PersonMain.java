package com.tje.starter;

import com.tje.config.*;
import com.tje.model.*;

import org.springframework.context.support.AbstractApplicationContext;
// AnnotationConfigApplicationContext 클래스
// - 클래스 파일을 사용하여 스프링 컨테이너를 정의한 경우
//   해당 클래스 파일을 사용하여 스프링 컨테이너를 생성할 수 있는 클래스
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		// 자바 클래스로 정의된 스프링 컨테이너를 생성하는 코드
		// - AnnotationConfigApplicationContext 객체를 생성하여 처리
		// - 스프링 컨테이너가 정의된 자바 클래스의 class를 전달하여 처리
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(PersonConfig.class);
		
		// 클래스를 사용한 설정인 경우 @Bean 어노테이션이 적용된 
		// 메소드의 이름을 사용하여 스프링 빈 객체를 반환받을 수 있다.
		Person p1 = ctx.getBean("getPerson1", Person.class);
		// 만약, @Bean 어노테이션에 name 속성이 적용된 경우
		// 메소드 명이 아닌 name 속성의 값을 사용하여 스프링 빈 객체를 반환받을 수 있다.
		Person p2 = ctx.getBean("p2", Person.class);
		
		// 객체 정보 출력
		System.out.println(p1.getName());
		p1.getPet().sound();
		p1.getPet().action();
		System.out.println(p2.getName());
		p2.getPet().sound();
		p2.getPet().action();
		}
}
