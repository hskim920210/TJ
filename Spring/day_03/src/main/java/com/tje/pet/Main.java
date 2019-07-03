package com.tje.pet;

import java.util.*;
import java.sql.*;
import java.io.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) throws Exception {
		
		String configLocation = "classpath:pet.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		Person person = ctx.getBean("person", Person.class);
		
		System.out.println(person.getName());
	}

}
