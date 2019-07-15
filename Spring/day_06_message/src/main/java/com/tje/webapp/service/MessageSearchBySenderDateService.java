package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

import java.util.*;

@Service
public class MessageSearchBySenderDateService {
	@Autowired
	private MessageDAO messageDAO;
	
	public Object service(Object args) {
		HashMap<String, Object> values = (HashMap<String, Object>)args;
		MessageSearchCommand command = (MessageSearchCommand)values.get("command");
		String sender = (String)values.get("sender");
		return messageDAO.selectBySender_Date(command, sender);
	}
}
