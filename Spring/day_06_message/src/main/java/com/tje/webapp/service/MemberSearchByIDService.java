package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

@Service
public class MemberSearchByIDService {
	@Autowired
	private MemberDAO memberDAO;
	
	public Object service(Object args) {
		Object result = null;
		try {
			result = memberDAO.selectById((Member)args);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	
	public Object service(Object args, boolean isList) {
		Object result = null;
		try {
			result = memberDAO.selectByIds((Member)args);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
}
