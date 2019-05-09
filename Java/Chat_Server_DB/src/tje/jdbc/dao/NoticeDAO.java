package tje.jdbc.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import tje.jdbc.util.*;
import tje.jdbc.model.*;

public class NoticeDAO {
	private static NoticeDAO instance = new NoticeDAO();

	public static NoticeDAO getInstance() {
		return instance;
	}

	private NoticeDAO() {
	}
	
	private Notice generateObject(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String message = rs.getString(2);
		Date write_date = rs.getTimestamp(3);
		return new Notice(id, message, write_date);
	}

	// select 쿼리의 결과로 지정된 개수만큼한 검색
	public ArrayList<Notice> select(Connection conn) {
		ArrayList<Notice> result = new ArrayList<>();		
		String sql = "select * from notice order by write_date desc limit 10";
		// 11번째 레코드부터 시작하여 21번째 레코드를 검색하는 쿼리
		// 인덱스의 시작은 0
		// String sql = "select * from notice order by write_date desc limit 10, 10";
		
		Statement stmt = JDBCObjectManager.getStatement(conn);
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {				
				Notice model = generateObject(rs);
				result.add(model);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		
		return result;
	}

	public ArrayList<Notice> select(Connection conn, int startIndex) {		
		ArrayList<Notice> result = new ArrayList<>();		
		String sql = "select * from notice order by write_date desc limit " + startIndex + ", 10";
		
		Statement stmt = JDBCObjectManager.getStatement(conn);
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {				
				Notice model = generateObject(rs);
				result.add(model);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		
		return result;
	}

	public int insert(Connection conn, Notice model) {
		int result = 0;		
		String sql = "insert into notice values (0,?,now())";
		PreparedStatement stmt = JDBCObjectManager.getStatement(conn, sql);		
		
		try {			
			stmt.setString(1, model.getMessage());
			result = stmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		JDBCObjectManager.close(stmt);
		
		return result;
	}
}
