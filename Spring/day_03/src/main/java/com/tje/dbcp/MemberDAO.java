package com.tje.dbcp;

import java.sql.*;

import org.springframework.stereotype.Component;

@Component("memberDAO")
public class MemberDAO implements DAO {
	public boolean select(Connection conn, Member obj) {
		boolean result = false;
		
		String sql = "select * from member where id=?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getId());
			
			rs = stmt.executeQuery();
			if( rs.next() ) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Closer.close(rs);
		Closer.close(stmt);
		
		return result;
	}
	
	public boolean insert(Connection conn, Member obj) {
		boolean result = false;
		
		String sql = "insert into member values (?,?,?)";
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getId());
			stmt.setString(2, obj.getName());
			stmt.setInt(3, obj.getAge());
			
			if( stmt.executeUpdate() > 0 ) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Closer.close(stmt);
		
		return result;
	}
	
}
