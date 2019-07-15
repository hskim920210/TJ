package com.personal.khs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.khs.repository.*;
import com.personal.khs.model.*;

@Service
public class UserIdCheckService {
	@Autowired
	private UserDAO userDAO;
	
	// User 타입이 리턴되는 서비스.
	// 검색결과가 존재하면 해당 User 객체가 Object에 리턴된다.
	// 검색결과가 없으면 null인 User 객체가 Object에 리턴.
	public Object service(Object args) {
		Object result = null;
		try {
			result = userDAO.selectById((User)args);
			System.out.println("user 객체가 존재되어 리턴");
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
}
