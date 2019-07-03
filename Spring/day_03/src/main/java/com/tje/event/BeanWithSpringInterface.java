package com.tje.event;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 스프링 컨테이너의 생성, 소멸 시점을 감지하여 
// 추가적인 작업을 처리할 수 있는 스프링 빈 클래스 생성
public class BeanWithSpringInterface implements InitializingBean, DisposableBean{
	
	public BeanWithSpringInterface() {
		System.out.println("생성자 메소드 실행");
	}

	// InitializingBean 인터페이스
	// - 스프링 컨테이너에 의해서 등록되는 클래스가
	//   스프링 컨테이너의 생성 시점에 자동으로 처리하고자 하는 작업이 있는 경우
	//   구현하는 인터페이스
	// - InitializingBean 인터페이스를 구현한 클래스의 객체가
	//   스프링 빈 객체로 등록되는 경우 스프링 컨테이너의 초기화 과정에서
	//   afterPropertiesSet 메소드가 자동으로 호출
	// InitializingBean 인터페이스의 추상 메소드
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet 메소드 실행");
	}

	// DisposableBean 인터페이스
	// - 스프링 컨테이너에 의해서 등록되는 클래스가
	//   스프링 컨테이너의 종료 시점에 자동으로 처리하고자 하는 작업이 있는 경우
	//   구현하는 인터페이스
	// - DisposableBean 인터페이스를 구현한 클래스의 객체가
	//   스프링 빈 객체로 등록되는 경우 스프링 컨테이너의 종료 과정에서
	//   destroy 메소드가 자동으로 호출
	// DisposableBean 인터페이스의 추상 메소드
	public void destroy() throws Exception {
		System.out.println("destroy 메소드 실행");
	}
	
}
