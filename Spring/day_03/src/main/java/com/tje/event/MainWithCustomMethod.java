package com.tje.event;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainWithCustomMethod {

	public static void main(String[] args) throws Exception {
		
		String configLocation = "classpath:event_2.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		System.out.println("스프링 컨테이너 생성");
		
		
		BeanWithCustomMethod bean1 = ctx.getBean("bean", BeanWithCustomMethod.class);
		BeanWithCustomMethod bean2 = ctx.getBean("bean", BeanWithCustomMethod.class);
		
		if( bean1 == bean2 ) {
			System.out.println("동일한 객체");
		} else {
			System.out.println("서로 다른 객체");
		}
		
		System.out.println("스피링 빈 객체 반환");
		
		ctx.close();
		System.out.println("스피링 컨테이너 종료");
		
	}

}
