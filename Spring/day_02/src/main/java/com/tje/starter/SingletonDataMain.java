package com.tje.starter;

import com.tje.config.*;
import com.tje.model.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingletonDataMain {
	public static void main(String[] args) {
		String configLocation = "classpath:conf/singleton.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		SingletonData s1 = ctx.getBean("s1", SingletonData.class);
		SingletonData s2 = ctx.getBean("s2", SingletonData.class);
		SingletonData s3 = ctx.getBean("s3", SingletonData.class);
		
		// s1은 싱글톤패턴으로 만들어진게 아니라 강제로 private 생성자에 접근하여 생성한 객체
		System.out.println(s1.getNumber());
		// factory-method로 getInstace를 불렀으므로 싱글톤객체 생성
		System.out.println(s2.getNumber());
		// s2가 만들어질 때 instance가 null이 아니므로 s3을 불러와도 여전히 100이 출력되게 된다.
		System.out.println(s3.getNumber());
		}
}
