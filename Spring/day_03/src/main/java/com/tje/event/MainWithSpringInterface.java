package com.tje.event;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainWithSpringInterface {

	public static void main(String[] args) throws Exception {
		
		String configLocation = "classpath:event_1.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		System.out.println("스프링 컨테이너 생성");
		
		
		BeanWithSpringInterface bean = ctx.getBean("bean", BeanWithSpringInterface.class);
		System.out.println("스피링 빈 객체 반환");
		
		ctx.close();
		System.out.println("스피링 컨테이너 종료");
		
	}

}
