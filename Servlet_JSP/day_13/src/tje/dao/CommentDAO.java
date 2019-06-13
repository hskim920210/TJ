package tje.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import tje.jdbc.util.*;
import tje.model.*;

public class CommentDAO {
	private Comment getInstance(ResultSet rs) throws SQLException {
		Comment obj = new Comment(
				rs.getInt("comment_id"),
				rs.getInt("article_id"), 
				rs.getString("member_id"), 
				rs.getString("content"),
				rs.getTimestamp("write_time"));
		return obj;
	}
	
	public Comment selectOne(Connection conn, Comment obj) {
		Comment result = null;
		String sql = "select * from comment where comment_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, obj.getComment_id());
			
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
	
	public ArrayList<Comment> selectAll(Connection conn, Comment obj) {
		ArrayList<Comment> result = new ArrayList<>();
		String sql = "select * from comment where article_id=? order by write_time asc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, obj.getArticle_id());
			
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
	
	public boolean insert(Connection conn, Comment obj) {
		boolean result = false;
		String sql = "insert into comment values (null,?,?,?,now())";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, obj.getArticle_id());
			pstmt.setString(2, obj.getMember_id());
			pstmt.setString(3, obj.getContent());
			
			result = pstmt.executeUpdate() == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Closer.close(pstmt);
		
		return result;
	}
	
	public boolean delete(Connection conn, Comment obj) {
		boolean result = false;
		String sql = "delete from comment where comment_id=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, obj.getComment_id());
			
			result = pstmt.executeUpdate() == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Closer.close(pstmt);
		
		return result;
	}
	
}
