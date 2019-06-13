package tje.service;

import java.sql.*;
import java.util.*;
import tje.dao.*;
import tje.model.*;

public class MemberLoginService implements Service {
	private MemberDAO memberDAO = new MemberDAO();
	
	public HashMap<String, Object> service(HashMap<String, Object> values) {
		HashMap<String, Object> result = new HashMap<>();
		Connection conn = (Connection) values.get("conn");
		Member member = (Member)values.get("member");
		
		result.put("result", memberDAO.selectOne(conn, member));
		return result;
	}
}
