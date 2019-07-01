package com.tje;

// 이걸 가져오면 resources에 있는 xml의 bean을 가져올 수 있다.
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainUsingDI {

	public static void main(String[] args) {
		// 스프링 컨테이너의 생성
		// 1. 스프링 컨테이너 설정 파일 (또는 클래스도 가능)의 경로 설정
		//  - classpath가 의미하는 것은 resources 디렉토리를 의미
		String configLocation = "classpath:memberRequestConfig.xml";
		
		// 2. 설정파일을 사용하여 스프링 컨테이너 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext(configLocation);
		
		// 3. 스프링 컨테이너 내부의 저장되어있는 스프링 빈 객체를 반환
		MemberRequestUsingDI request = context.getBean("memberRequest", MemberRequestUsingDI.class);
		
		// 4. 스프링 빈 객체를 사용
		System.out.println(request.getMember().getName());
		System.out.println(request.getMember().getAge());
	}

}
