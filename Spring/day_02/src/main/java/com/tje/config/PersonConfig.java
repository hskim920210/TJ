package com.tje.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tje.model.*;

// 스프링 컨테이너를 자바 클래스를 사용하여 정의하는 방법

// 1. 클래스의 선언부에 @Configuration 어노테이션을 정의
// - XML 파일을 사용한 정의 방법에서 beans 태그와 유사한 역할
@Configuration
public class PersonConfig {
	
	// 2. 클래스의 내부에 @Bean이 지정된 메소드를 선언
	// - XML 파일을 사용한 정의 방법에서 bean 태그와 유사한 역할
	// - XML 파일을 사용한 정의 방법에서 스프링 빈 객체의 이름은
	//   id 속성을 사용
	// - 클래스를 사용한 정의 방법에서 스프링 빈 객체의 이름은 
	//   메소드명이 된다.
	@Bean
	public Dog getDog() {
		return new Dog();
	}
	@Bean
	public Cat getCat() {
		return new Cat();
	}
	@Bean
	public Person getPerson1() {
		return new Person("A", getDog());
	}
	@Bean(name = "p2")
	public Person getPerson2() {
		return new Person("B", getCat());
	}
	
	
	
}
