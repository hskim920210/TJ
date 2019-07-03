package com.tje.dbcp;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class RegistService {

	// @Resource는 반드시 멤버필드의 선언부에만 사용 가능하다.
	@Resource(name = "memberDAO")
	private DAO dao;
	
	public RegistService() {
	}
	
	public void service(HashMap<String, Object> values) {
		Connection conn = (Connection)values.get("conn");
		Member member = (Member)values.get("member");
		values.put("result", this.dao.insert(conn, member));
	}
	
}
