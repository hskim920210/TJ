package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.model.*;
import com.tje.webapp.repository.*;

@Service
public class MemberInsertService {
	@Autowired
	private MemberDAO memberDAO;
	
	public Object service(Object obj) {
		return memberDAO.insert( (Member)obj ) == 0 ? false : true;
	}
}
