package tje.chat.common.jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

import tje.chat.common.util.*;

import tje.chat.common.jdbc.model.*;




// naver 데이터베이스의 info 테이블에 대한
// JDBC 작업을 제공하는 DAO 클래스
public class UserDAO {
	
	
	// DAO 클래스는 한번만 생성하기 위해 싱글톤패턴을 적용
	// 하나의 인스턴스를 생성해 동일한 인스턴스를 계속 사용할 수 있도록 한다.
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	private UserDAO() {}
	
	// ResultSet에 담긴 정보로 User모델을 활용하여 기입한 가입정보를 가진 객체를 반환하는 메소드
	private User generateObject (ResultSet rs) throws SQLException {
		String id = rs.getString(1);
		String pw = rs.getString(2);
		
		return new User(id, pw);
	}
	
	// ID 중복체크를 해서 불린타입으로 반환하는 메소드
	public boolean isIdExist (Connection conn, String id) {
		String sql = "select id from info where id = ?";
		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);
		try {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				if( rs.getString("id").equals(id) ) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCObjectManager.close(pstmt);
		return false;
	}
	// 기입된 정보를 User객체로 받아와 table에 insert하는 쿼리문을 수행해주는 메소드
	// insert 실행 이후 추가된 행의 갯수를 int 타입으로 반환한다.
	public int insert(Connection conn, User user) {
		int result = 0;
		
		// 쿼리문의 설정
		String sql = "insert into info values (?, ?)";
		
		// 쿼리문 준비
		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);
		
		// 쿼리문의 ? 값들을 설정
		try {
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			
			// setString으로 완성된 쿼리문을 실행하고 리턴값을 result에 대입
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Statement를 닫고 (예외처리를 해놓은 JDBCObjectManager의 close 메소드로)
		JDBCObjectManager.close(pstmt);
		// 결과 리턴
		return result;
	}
	
	public int insert(Connection conn, String msg) {
		String sql = "insert into log values (?, ?)";
		int result = 0;
		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);
		try {
			Date now = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd  HH:mm:ss");
			pstmt.setString(1, msg);
			pstmt.setString(2, sdf.format(now));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCObjectManager.close(pstmt);
		return result;
	}
	
	public boolean login (Connection conn, User user) {
		boolean result = false;
		// 받아온 user 정보에서 id에 맞는 id와 pw 정보 검색
		String sql = "select id, pw from info where id = ? and pw = ?";
		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);
		try {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
}
