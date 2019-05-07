package tje.chat.common.util;

import java.sql.*;

// 실행할 메소드의 예외처리들을 해주는 클래스
public class JDBCObjectManager {
	
	public static Statement getStatement (Connection conn) {
		// 반환할 Statement 객체를 null로 초기화
		Statement obj = null;
		
		// 실행할 쿼리문을 준비와 예외처리
		try {
			obj = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	// Statement 종류에 따른 오버로딩
	public static PreparedStatement getStatement (Connection conn, String sql) {
		PreparedStatement obj = null;
		
		try {
			obj = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	// 예외처리를 위한 close 메소드들을 정의한다. (connection, statement, preparedstatement, resultset을 닫을 때
	public static void close (Connection obj) {
		// Connection이 없으면 아무것도 하지 않는다.
		if( obj == null ) {
			return;
		}
		
		// Connection이 있을 땐 닫아준다.
		try {
			obj.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close (PreparedStatement obj) {
		if( obj == null ) {
			return;
		}
		
		try {
			obj.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close (ResultSet obj) {
		if( obj == null ) {
			return;
		}
		
		try {
			obj.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// 오토커밋과 커밋, 롤백의 예외처리
	public static void setAutoCommit (Connection conn, boolean flag) {
		try {
			conn.setAutoCommit(flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commit (Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback (Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
