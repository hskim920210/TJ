package tje.dao;

import java.sql.*;
import java.util.*;
// JDBC 작업을 위한 유틸리티 클래스들
import tje.jdbc.*;
// JDBC 작업 후, 반환할 데이터를 자바빈 객체로 생성하기 위한 클래스들
import tje.model.*;

public class MemberDAO {
	private Member getInstance(ResultSet rs) throws SQLException {
		Member member = new Member(rs.getString("id"),
				rs.getString("password"), 
				rs.getString("name"), 
				rs.getInt("age"),
				rs.getString("tel"), 
				rs.getString("address"));
		return member;
	}
	
	public Member selectOne(Connection conn, Member obj) {
		Member result = null;
		String sql = "select * from member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getId());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = getInstance(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCCloser.close(rs);
		JDBCCloser.close(pstmt);
		
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
		
		JDBCCloser.close(rs);
		JDBCCloser.close(pstmt);
		
		return result;
	}
	
	
	public boolean insert(Connection conn, Member obj) {
		boolean result = false;
		String sql = "insert into member values (?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getId());
			pstmt.setString(2, obj.getPassword());
			pstmt.setString(3, obj.getName());
			if( obj.getAge() != 0 ) {
				pstmt.setInt(4, obj.getAge());
			} else {
				pstmt.setNull(4, Types.NULL);
			}
			if( obj.getTel() != null && obj.getTel().length() > 0 ) {
				pstmt.setString(5, obj.getTel());
			} else {
				pstmt.setNull(5, Types.NULL);
			}
			if( obj.getAddress() != null && obj.getAddress().length() > 0 ) {
				pstmt.setString(6, obj.getAddress());
			} else {
				pstmt.setNull(6, Types.NULL);
			}
			
			result = pstmt.executeUpdate() == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCCloser.close(pstmt);
		
		return result;
	}
	
	
	
	public boolean delete(Connection conn, Member obj) {
		boolean result = false;
		String sql = "delete from member where id=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getId());
			
			result = pstmt.executeUpdate() == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCCloser.close(pstmt);
		
		return result;
	}
	
	
	
	
	public boolean updatePassword(Connection conn, Member obj) {
		boolean result = false;
		String sql = "update member set password=? where id=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getPassword());
			pstmt.setString(2, obj.getId());
			
			result = pstmt.executeUpdate() == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCCloser.close(pstmt);
		
		return result;
	}
	
}
