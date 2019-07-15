package com.tje.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tje.webapp.dao.*;
import com.tje.webapp.model.*;

public class MemberRegisterService {
	@Autowired
	private MemberDAO dao;
	
	public Object service(Object values) {
		RegisterRequest input = (RegisterRequest)values;
		return dao.insert(input);
	}
	
	
}
