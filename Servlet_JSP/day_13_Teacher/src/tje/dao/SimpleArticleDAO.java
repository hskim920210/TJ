package tje.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import tje.jdbc.util.*;
import tje.model.*;

public class SimpleArticleDAO {
	private SimpleArticle getInstance(ResultSet rs) throws SQLException {		
		SimpleArticle obj = new SimpleArticle(
				rs.getInt("article_id"),
				rs.getString("title"),
				rs.getString("member_id"),
				rs.getString("name"),
				rs.getTimestamp("write_time"),
				rs.getInt("read_count"));
		return obj;
	}
	
	public ArrayList<SimpleArticle> selectAll(Connection conn) {
		ArrayList<SimpleArticle> result = new ArrayList<>();
		String sql = "select * from simpleArticle";
		
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
}













