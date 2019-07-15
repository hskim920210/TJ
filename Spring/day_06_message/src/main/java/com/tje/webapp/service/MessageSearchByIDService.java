package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

@Service
public class MessageSearchByIDService {
	@Autowired
	private MessageDAO messageDAO;
	
	public Object service(Object args) {
		// 메세지 타입의 객체가 반환
		return messageDAO.selectById((Message)args);
	}
}
