package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

import java.util.*;

@Service
public class MessageSearchByReceiverService {
	@Autowired
	private MessageDAO messageDAO;
	
	public Object service(Object args) {
		HashMap<String, Object> values = (HashMap<String, Object>)args;
		int curPageNo = (Integer)values.get("curPageNo");
		Message message = (Message)values.get("message");
		// 메세지 리스트 타입의 객체가 반환
		return messageDAO.selectByReceiver(message, curPageNo);
	}
}
