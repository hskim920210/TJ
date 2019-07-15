package com.tje.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.webapp.repository.*;
import com.tje.webapp.model.*;
import java.util.*;

@Service
public class MemberLoginService {
	@Autowired
	private MemberDAO memberDAO;
	
	// Object로 리스트 (2개의 값) 형태로 가져오는 상황을 가정
	public Object service(Object args) {
		ArrayList<Member> input = (ArrayList<Member>)args;
		// 사용자가 요청 객체에 전달한 정보
		Member source = input.get(0);
		// 사용자가 요청 객체에 전달한 ID에 해당되는 데이터 베이스 정보
		Member info = input.get(1);
		
		// 불린 타입으로 반환
		return source.getPassword().equals(info.getPassword());
	}
}
