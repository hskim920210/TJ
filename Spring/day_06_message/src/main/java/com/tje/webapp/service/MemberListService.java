package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;

@Service
public class MemberListService {
	@Autowired
	private MemberDAO memberDAO;
	
	// 일관된 interface를 위해 args를 안써또 형식상 받는다.
	// 나중에 서비스 사용 시 null값을 파라메터로 넘겨주면 되서 상관없음.
	public Object service(Object args) {
		// 멤버 리스트를 리턴
		return memberDAO.selectAll();
	}
}
