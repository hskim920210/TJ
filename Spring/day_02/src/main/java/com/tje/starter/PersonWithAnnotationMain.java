package com.tje.starter;

import com.tje.config.*;
import com.tje.model.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonWithAnnotationMain {
	public static void main(String[] args) {
		String configLocation = "classpath:conf/personWithAnnotation.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		PersonWithAnnotation p1 = ctx.getBean("p1", PersonWithAnnotation.class);
		PersonWithAnnotation p2 = ctx.getBean("p2", PersonWithAnnotation.class);
		
		// 객체 정보 출력
		System.out.println(p1.getName());
		p1.getPet().sound();
		p1.getPet().action();
		System.out.println(p2.getName());
		p2.getPet().sound();
		p2.getPet().action();
		}
}
