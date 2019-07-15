package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

@Service
public class MessageInsertService {
	@Autowired
	private MessageDAO messageDAO;
	
	public Object service(Object args) {
		// 자동증가치가 리턴되므로 인트 타입을 리턴
		return messageDAO.insert((Message)args);
	}
}
