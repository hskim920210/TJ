package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;


@Service
public class MemberSearchByIDService {
	@Autowired
	private MemberDAO memberDAO;
	
	public Object service(Object obj) {
		Object result = null;
		try {
			result = memberDAO.selectById( (Member)obj );
		} catch (Exception e) {
			// e.printStackTrace();
			result = null;
		}
		return result;
	}

}
