package com.tje.starter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.tje.jdbc.dao.*;
import com.tje.jdbc.pool.*;
import com.tje.jdbc.model.*;

public class JDBCStarter {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourcePoolConfig.class);
		MemberDAO dao = ctx.getBean("memberDAO", MemberDAO.class);
		
//		System.out.println(dao.count());
//		
//		Member source = new Member();
//		source.setEmail("tje304@tje.com");
//		Member member = dao.selectByEmail(source);
//		System.out.println(member.getName());
//		
//		member.setName("ABC");
//		member.setPassword("DEF");
//		dao.update(member);
		
		Member newMember = new Member();
		newMember.setEmail("tje309@tje.com");
		newMember.setName("tje309");
		newMember.setPassword("1213");
		System.out.printf("INSERTED KEY : %d\n", dao.insert(newMember));
		
		ctx.close();
	}
}
