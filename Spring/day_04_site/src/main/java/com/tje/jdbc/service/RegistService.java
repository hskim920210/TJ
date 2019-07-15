package com.tje.jdbc.service;


import org.springframework.transaction.annotation.Transactional;

import com.tje.jdbc.dao.*;
import com.tje.jdbc.model.*;

public class RegistService {
	private MemberDAO dao;
	public RegistService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public int service() {
		int result = 0;
		
		Member member = new Member();
		member.setMember_id("abcdefg");
		member.setPassword("abcdefg");
		member.setName("abcgfe");
		member.setGender(1);
		member.setAge(11);
		
		return dao.insert(member);
	}
}
