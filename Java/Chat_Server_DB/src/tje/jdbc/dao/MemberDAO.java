package tje.jdbc.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import tje.jdbc.util.*;
import tje.jdbc.model.*;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {
	}
	
	private Member generateObject(ResultSet rs) throws SQLException {
		String id = rs.getString(1);
		String password = rs.getString(2);
		String name = rs.getString(3);
		String nick = rs.getString(4);
		Date regist_date = rs.getTimestamp(5);
		return new Member(id, password, name, nick, regist_date);
	}

	public ArrayList<Member> select(Connection conn) {
		ArrayList<Member> result = new ArrayList<>();		
		String sql = "select * from member";
		Statement stmt = JDBCObjectManager.getStatement(conn);
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {				
				Member model = generateObject(rs);
				result.add(model);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		
		return result;
	}

	public Member select(Connection conn, Member model) {
		Member result = null;		
		String sql = "select * from member where id = ?";
		PreparedStatement stmt = JDBCObjectManager.getStatement(conn, sql);
		ResultSet rs = null;
		
		try {
			stmt.setString(1, model.getId());
			rs = stmt.executeQuery();
			
			if( rs.next() ) {				
				result = generateObject(rs);				
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		
		return result;
	}
	
	public Member login(Connection conn, Member model) {
		Member result = null;		
		String sql = "select * from member where id = ? and password = ?";
		PreparedStatement stmt = JDBCObjectManager.getStatement(conn, sql);
		ResultSet rs = null;
		
		try {
			stmt.setString(1, model.getId());
			stmt.setString(2, model.getPassword());
			rs = stmt.executeQuery();
			
			if( rs.next() ) {				
				result = generateObject(rs);				
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		
		return result;
	}

	public int insert(Connection conn, Member model) {
		int result = 0;		
		String sql = "insert into member values (?,?,?,?,now())";
		PreparedStatement stmt = JDBCObjectManager.getStatement(conn, sql);		
		
		try {
			stmt.setString(1, model.getId());
			stmt.setString(2, model.getPassword());
			stmt.setString(3, model.getName());
			stmt.setString(4, model.getNick());			
			result = stmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		JDBCObjectManager.close(stmt);
		
		return result;
	}
}
