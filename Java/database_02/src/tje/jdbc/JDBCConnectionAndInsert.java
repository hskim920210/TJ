package tje.jdbc;

import java.sql.*;


public class JDBCConnectionAndInsert {
	public static void main(String[] args) {
		// 1. JDBC 드라이버 클래스 로딩
		String strDriverClassName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(strDriverClassName);
			System.out.println("드라이버 클래스 로딩 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 로딩 실패");
			e.printStackTrace();
			return;
		}
		
		// 2. DBMS 연결
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/hr?serverTimezone=UTC";
		String user = "root";
		String password = "SystemManager304";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DBMS 연결 성공");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패");
			e.printStackTrace();
			return;
		}
		
		PreparedStatement pstmt = null;
		
		
		// Insert 쿼리의 작성 시, values에 추가되는 값은
		// ? 로 대체하여 손쉽게 값을 입력할 수 있다.
		String sql = "insert into users values (0, ?, ?, ?, ?, ?)"; 
	
		// Insert, Update, Delete 쿼리를 수행하는 경우
		// 정수 타입의 값이 반환되며, 적용된 레코드의 개수가 반환
		// Insert : 입력된 레코드의 개수가 반환
		// Update : 수정된 레코드의 개수가 반환
		// Delete : 삭제된 레코드의 개수가 반환
		int recordCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// ?로 지정된 자리의 값을 설정.
			pstmt.setString(1, "abcdef");
			pstmt.setString(2, "12345");
			pstmt.setString(3, "아무개1");
			pstmt.setInt(4, 22);
			pstmt.setString(5, "010-1111-1010");
			
			// Insert, Update, Delete 쿼리를 수행하는 경우에는
			// executeUpdate 메소드를 사용하여 쿼리를 실행
			// (쿼리의 실행 결과로 적용된 레코드의 개수를 반환하는 메소드)
			recordCount = pstmt.executeUpdate();
			
			if( recordCount == 1 )
				System.out.println("회원 정보 추가 성공 !");
			else 
				System.out.println("회원 정보 추가 실패 !");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			
			if( pstmt != null )
				pstmt.close();
			if( conn != null )
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
