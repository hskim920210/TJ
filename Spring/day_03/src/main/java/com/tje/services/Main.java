package com.tje.services;

import java.util.*;
import java.sql.*;
import java.io.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) throws Exception {
		
		// 키보드 입력 스트림
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("회원가입을 시작합니다.");
		System.out.print("ID : ");
		String id = in.readLine();
		System.out.print("Name : ");
		String name = in.readLine();
		System.out.print("Age : ");
		int age = Integer.parseInt(in.readLine());
		
		Member member = new Member(id, name, age);
		
		String configLocation = "classpath:services.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		// 스프링 컨테이너로부터 커넥션 객체를 생성할 수 있는 객체 반환
		ConnectionProvider provider = ctx.getBean("provider", ConnectionProvider.class);
		// 스프링 컨테이너로부터 멤버의 중복 여부를 확인할 수 있는 서비스 객체 반환
		SearchingService ss = ctx.getBean("ss", SearchingService.class);
		// 스프링 컨테이너로부터 멤버를 입력할 수 있는 서비스 객체 반환
		RegistService rs = ctx.getBean("rs", RegistService.class);
		
		// 서비스 객체에 전달할 맵 객체 생성
		HashMap<String, Object> values = new HashMap<String, Object>();
		values.put("conn", provider.getConnection());
		values.put("member", member);
		
		ss.service(values);
		if( (Boolean)values.get("result") ) {
			System.out.printf("%s 는 존재하는 아이디입니다.\n", member.getId());
			Closer.close((Connection)values.get("conn"));
			return;
		}
		
		rs.service(values);
		if( (Boolean)values.get("result") ) {
			System.out.printf("%s 아이디로 회원가입이 성공했습니다.\n", member.getId());
		} else {
			System.out.println("회원가입에 실패했습니다.");
			System.out.println("관리자에게 문의하세요");
		}
		
		Closer.close((Connection)values.get("conn"));
		
	}

}
