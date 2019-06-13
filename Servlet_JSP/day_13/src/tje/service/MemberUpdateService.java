package tje.service;

import java.sql.*;
import java.util.*;
import tje.dao.*;
import tje.model.*;

public class MemberUpdateService implements Service {
	private MemberDAO memberDAO = new MemberDAO();
	
	public HashMap<String, Object> service(HashMap<String, Object> values) {
		HashMap<String, Object> result = new HashMap<>();
		Connection conn = (Connection) values.get("conn");
		Member member = (Member)values.get("member");
		
		String type = (String)values.get("type");
		
		if( type.equals("last_access_time") ) {
			result.put("result", memberDAO.updateLastAT(conn, member));
		} else if( type.equals("age") ) {
			result.put("result", memberDAO.updateAge(conn, member));
		} else if( type.equals("birth") ) {
			result.put("result", memberDAO.updateBirth(conn, member));
		} else if( type.equals("tel") ) {
			result.put("result", memberDAO.updateTel(conn, member));
		} else if( type.equals("address") ) {
			result.put("result", memberDAO.updateAddress(conn, member));
		}
		
		return result;
	}
}
