package com.tje.starter;

import java.util.*;
import com.tje.model.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TJEMain {
	public static void main(String[] args) {
		String configLocation = "classpath:conf/tje_list.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		TheJoEun tje = ctx.getBean("tje", TheJoEun.class);
		
		System.out.println(tje);
	}
}
