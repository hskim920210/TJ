package com.tje.services;

import java.util.*;
import java.sql.*;

public class RegistService {
	
	private DAO dao;
	
	public RegistService(DAO dao) {
		this.dao = dao;
	}
	
	public void service(HashMap<String, Object> values) {
		Connection conn = (Connection)values.get("conn");
		Member member = (Member)values.get("member");
		values.put("result", this.dao.insert(conn, member));
	}
	
}
