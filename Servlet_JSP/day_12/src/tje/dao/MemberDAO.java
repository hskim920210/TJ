package tje.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import tje.jdbc.util.*;
import tje.model.*;

public class MemberDAO {
	// 이런 저런 고민 하기 싫으면 getTimestamp - 보편적 방법
	// 제대로 하고싶으면 new Date(rs.getDate(```).getTime())을 쓰면 된다.
	private Member getInstance(ResultSet rs) throws SQLException {
		Member obj = new Member(
				rs.getString("member_id"),
				rs.getString("password"), 
				rs.getString("name"), 
				rs.getInt("gender"),
				rs.getInt("age"),
				rs.getTimestamp("birth"),
				rs.getString("tel"), 
				rs.getString("address"),
				new java.util.Date(rs.getDate("regist_date").getTime()),
				rs.getTimestamp("last_access_time"));
		return obj;
	}
	
	public Member selectOne(Connection conn, Member obj) {
		Member result = null;
		String sql = "select * from member where member_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getMember_id());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = getInstance(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Closer.close(rs);
		Closer.close(pstmt);
		
		return result;
	}
	
	
	
	public ArrayList<Member> selectAll(Connection conn) {
		ArrayList<Member> result = new ArrayList<>();
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(getInstance(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Closer.close(rs);
		Closer.close(pstmt);
		
		return result;
	}
	
	
	

	
	private void setPreparedStatement(int index, int value, PreparedStatement pstmt) throws SQLException {
		if( value != 0 )
			pstmt.setInt(index, value);
		else
			pstmt.setNull(index, Types.NULL);
	}
	
	private void setPreparedStatement(int index, String value, PreparedStatement pstmt) throws SQLException {
		if( value != null && value.length() > 0 ) {
			pstmt.setString(index, value);
		} else {
			pstmt.setNull(index, Types.NULL);
		}
	}
	
	// pstmt.setDate(9, (java.sql.Date)obj.getRegist_date());
	// pstmt.setTimestamp(10, (Timestamp)obj.getLast_access_time());
	private void setPreparedStatement(int index, Date value, PreparedStatement pstmt) throws SQLException {
		if( value != null ) {
			pstmt.setTimestamp(index, new java.sql.Timestamp(value.getTime()));
		} else {
			pstmt.setNull(index, Types.NULL);
		}
	}
	
	
	public boolean insert(Connection conn, Member obj) {
		boolean result = false;
		String sql = "insert into member values (?,?,?,?,?,?,?,?,now(),null)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getMember_id());
			pstmt.setString(2, obj.getPassword());
			pstmt.setString(3, obj.getName());
			
			// Null값 체크 후 설정을 할 수 있는 메소드 호출
			setPreparedStatement(4, obj.getGender(), pstmt);
			setPreparedStatement(5, obj.getAge(), pstmt);
			setPreparedStatement(6, obj.getBirth(), pstmt);
			setPreparedStatement(7, obj.getTel(), pstmt);
			setPreparedStatement(8, obj.getAddress(), pstmt);
			
			result = pstmt.executeUpdate() == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Closer.close(pstmt);
		
		return result;
	}
	
	
	public boolean updatePassword(Connection conn, Member obj) {
		boolean result = false;
		String sql = "update member set password=? where member_id=?";
		
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
	
	
	
	
	/*
	public boolean delete(Connection conn, Member obj) {
		boolean result = false;
		String sql = "delete from member where member_id=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getMember_id());
			
			result = pstmt.executeUpdate() == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Closer.close(pstmt);
		
		return result;
	}
	*/
	
}
