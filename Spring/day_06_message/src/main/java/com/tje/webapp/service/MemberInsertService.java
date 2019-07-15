package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

@Service
public class MemberInsertService {
	@Autowired
	private MemberDAO memberDAO;
	
	public Object service(Object args) {
		// 불린 값 반환
		return memberDAO.insert((Member)args) == 0 ? false : true;
	}
}
