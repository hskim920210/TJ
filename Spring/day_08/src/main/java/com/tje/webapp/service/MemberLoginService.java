package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.model.*;
import com.tje.webapp.repository.*;

@Service
public class MemberLoginService {
	@Autowired
	private MemberDAO memberDAO;
	
	public Object service(Object obj) {
		Member request = (Member)obj;
		Member target = null;
		try {
			target = memberDAO.selectById( request );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return target.getPassword().equals(request.getPassword()) ? true : false;
		
	}
}
