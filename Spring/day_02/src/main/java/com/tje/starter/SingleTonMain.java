package com.tje.starter;

import com.tje.config.*;
import com.tje.model.*;

import org.springframework.context.support.AbstractApplicationContext;
// AnnotationConfigApplicationContext 클래스
// - 클래스 파일을 사용하여 스프링 컨테이너를 정의한 경우
//   해당 클래스 파일을 사용하여 스프링 컨테이너를 생성할 수 있는 클래스
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTonMain {
	public static void main(String[] args) {
		// 자바 클래스로 정의된 스프링 컨테이너를 생성하는 코드
		// - AnnotationConfigApplicationContext 객체를 생성하여 처리
		// - 스프링 컨테이너가 정의된 자바 클래스의 class를 전달하여 처리
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(PersonConfig.class);
		
		// 스프링 컨테이너는 싱글톤 패턴으로 스프링 빈 객체를 관리한다.
		
		// 스프링 컨테이너로부터 동일한 빈 객체를 반환받는 예제
		// - 메소드를 호출하여 반환된 결과를 받는 것과 같아보이지만
		//   실제로는 단 하나의 Dog 클래스의 객체가 생성되어
		//   d1, d2는 모두 동일한 Dog 클래스의 객체를 참조하고 있는 상태
		Dog d1 = ctx.getBean("getDog", Dog.class);
		Dog d2 = ctx.getBean("getDog", Dog.class);
		
		// 둘다 같은 주소를 갖는다.
		// XML로 보면 bean의 id가 dog인거를 계속 쓰는거라 이해가 쉽다.
		// p.52까지의 내용 - chapter 3 (p.53)
		// 의존 : 어떤 클래스에서 다른 클래스를 사용 (Service, Command 클래스)
		// 단순 클래스의 구현에만 집중할 수 있다. (new를 하지않음) - 협업을 통해 만들고 스프링 컨테이너가 만들어질때 전부 생성됨
		// 즉, 설계에만 집중할 수 있다.
		System.out.println(d1);
		System.out.println(d2);
		
		if(d1 == d2) {
			System.out.println("동일한 객체입니다.");
		}
		if(d1.equals(d2)) {
			System.out.println("동일한 객체입니다.");
		}
		
		
		}
}
