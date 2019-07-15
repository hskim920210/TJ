package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

import java.util.*;
import com.tje.webapp.setting.*;

@Service
public class MessageCountByReceiverService {
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private PagingInfo pagingInfo;
	
	public Object service(Object args) {
		int totalCount = messageDAO.selectByReceiverCount((Message)args);
		int totalPageCount = totalCount / pagingInfo.getPagingSize() + (totalCount % pagingInfo.getPagingSize() == 0 ? 0 : 1);
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("totalCount", totalCount);
		result.put("totalPageCount", totalPageCount);
		// 메세지 리스트 타입의 객체가 반환
		return result;
	}
}
