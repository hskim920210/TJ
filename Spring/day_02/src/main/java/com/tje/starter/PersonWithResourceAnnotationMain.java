package com.tje.starter;

import com.tje.config.*;
import com.tje.model.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonWithResourceAnnotationMain {
	public static void main(String[] args) {
		String configLocation = "classpath:conf/personWithResourceAnnotation.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		PersonWithDogResource p1 = ctx.getBean("p1", PersonWithDogResource.class);
		PersonWithCatResource p2 = ctx.getBean("p2", PersonWithCatResource.class);
		
		// 객체 정보 출력
		System.out.println(p1.getName());
		p1.getPet().sound();
		p1.getPet().action();
		System.out.println(p2.getName());
		p2.getPet().sound();
		p2.getPet().action();
		}
}
