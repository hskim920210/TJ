package com.tje.prefix;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String configLocation = "classpath:prefix_update.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		// 강아지 객체를 가지고 있는 p1
		Person p1 = ctx.getBean("p1", Person.class);
		// 고양이 객체를 가지고 있는 p2
		Person p2 = ctx.getBean("p2", Person.class);
		
		// 강아지의 action 출력
		p1.getPet().action();
		// 고양이의 action 출력
		p2.getPet().action();
	}

}
