package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

@Service
public class MessageUpdateReceiveTimeService {
	@Autowired
	private MessageDAO messageDAO;
	
	public Object service(Object args) {
		// 수정이 되면 1, 실패하면 0 이므로 그에 따라 불린 타입을 리턴
		return messageDAO.updateReceiveTime((Message)args) == 0 ? false : true;
	}
}
