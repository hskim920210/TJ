package khs.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import khs.jdbc.util.*;
import khs.model.*;

public class UserDAO {
	private User getInstance(ResultSet rs) throws SQLException {		
		User obj = new User(
				rs.getString("user_id"),
				rs.getString("user_pw"),
				rs.getString("user_nick"),
				rs.getInt("user_tel"),				
				rs.getString("user_mail"),
				rs.getTimestamp("user_regist_date"),
				rs.getInt("user_count_day"));
		return obj;
	}
	
	public User selectOne(Connection conn, User obj) {
		User result = null;
		String sql = "select * from user where user_id = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getUser_id());
			
			rs = pstmt.executeQuery();
			if( rs.next() )
				result = getInstance(rs);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		Closer.close(rs);
		Closer.close(pstmt);
		
		return result;
	}
	
	public ArrayList<User> selectAll(Connection conn) {
		ArrayList<User> result = new ArrayList<>();
		String sql = "select * from user";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);						
			rs = pstmt.executeQuery();
			
			while( rs.next() )
				result.add(getInstance(rs));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		Closer.close(rs);
		Closer.close(pstmt);
		
		return result;
	}
	
	private void setPreparedStatement(int index, int value, PreparedStatement pstmt) throws SQLException {
		if((int)(Math.log10(value)+1) >= 0 )
			pstmt.setInt(index, value);
		else
			pstmt.setNull(index, Types.NULL);
	}
	
	private void setPreparedStatement(int index, String value, PreparedStatement pstmt) throws SQLException  {
		if( value != null && value.length() > 0 )
			pstmt.setString(index, value);
		else
			pstmt.setNull(index, Types.NULL);
	}
	
	private void setPreparedStatement(int index, Date value, PreparedStatement pstmt) throws SQLException  {
		if( value != null )			
			pstmt.setTimestamp(index, 
					new java.sql.Timestamp(value.getTime()));
		else
			pstmt.setNull(index, Types.NULL);
	}
	
	public boolean insert(Connection conn, User obj) {
		boolean result = false;
		String sql = "insert into user values (?,?,?,?,?,now(),?)";
		
		PreparedStatement pstmt = null;		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, obj.getUser_id());
			pstmt.setString(2, obj.getUser_pw());
			pstmt.setString(3, obj.getUser_nick());
			// NULL값 체크 후 설정을 할 수 있는 메소드 호출
			setPreparedStatement(4, obj.getUser_tel(), pstmt);
			setPreparedStatement(5, obj.getUser_mail(), pstmt);
			// 접속 일수를 아예 0으로 해서 가입시킨다.
			pstmt.setInt(6, 0);
			
			result = pstmt.executeUpdate() == 1 ? true : false;
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		Closer.close(pstmt);
		
		return result;
	}
		
	public boolean updateCountday(Connection conn, User obj) {
		boolean result = false;
		String sql = "update user set user_count_day = datediff(now(),user_regist_date) where user_id = ?";
		
		PreparedStatement pstmt = null;		
		
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, obj.getUser_id());
			
			result = pstmt.executeUpdate() == 1 ? true : false;
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		Closer.close(pstmt);
		
		return result;
	}
}
	
	/*
	public boolean updatePassword(Connection conn, User obj) {
		boolean result = false;
		String sql = "update member set password = ? where member_id = ?";
		
		PreparedStatement pstmt = null;		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getPassword());
			pstmt.setString(2, obj.getMember_id());
			
			result = pstmt.executeUpdate() == 1 ? true : false;
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		Closer.close(pstmt);
		
		return result;
	}
	*/














