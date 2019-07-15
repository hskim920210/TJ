package com.tje.services;

import org.springframework.transaction.annotation.Transactional;

import com.tje.jdbc.dao.*;
import com.tje.jdbc.model.*;
import java.util.*;

public class TransactionTestService {
	private MemberDAO dao;
	
	public TransactionTestService(MemberDAO dao) {
		this.dao = dao;
	}
	
	// service 메소드에서 실행되는 모든 코드들이 
	// 에러가 발생되지 않는 경우에만 commit이 실행된다.
	// 단, 하나라도 예외가 발생하는 경우
	// rollback으로 처리된다.
	@Transactional
	public HashMap<String, Integer> service() {
		HashMap<String, Integer> result = 
				new HashMap<String, Integer>();
		
		Member source = new Member();
		source.setEmail("tje304_C@tje.com");
		source.setPassword("7654321");
		source.setName("Welcome");
		
		// 1번째 insert 문 - 성공
		result.put("1", dao.insert(source));
		
		source.setEmail("tje304_D@tje.com");
		source.setPassword("12345");
		source.setName("Hello");
		
		// 2번째 insert 문 - 실패
		result.put("2", dao.insert(source));
		
		System.out.println("서비스 실행 완료");
		return result;
	}
}
