package tje.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

// users 테이블의 이름, 나이, 연락처 정보를 수정하는 프로그램 작성
// 수정할 아이디를 입력 : 123
// 존재하지 않는 아이디입니다.
// 수정할 아이디를 입력 : tje
// 수정할 이름 ( 기존의 이름은 '암욱애0' ) : 더조은컴퓨터학원
// 수정할 나이 ( 기존의 나이는 '30' ) : 22
// 수정할 연락처 ( 기존의 연락처는 '010-1234-5678' ) : 010-1234-5678
// 수정이 완료되었습니다.

public class JDBCConnectionAndUpdateWithChecking {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
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

		// ID 정보를 사용하여 Select 쿼리를 수행할 객체
		PreparedStatement selectPstmt = null;
		// 수정할 정보를 입력받아 Update 쿼리를 수행할 객체
		PreparedStatement updatePstmt = null;

		String select_sql = "select * from users where user_id = ?";
		String update_sql = "update users" +
					" set user_name = ?, user_age = ?, user_tel = ?" + 
					" where user_id = ?"; 

		ResultSet rs = null;
		int recordCount = 0;
		
		try {
			selectPstmt = conn.prepareStatement(select_sql);		
			updatePstmt = conn.prepareStatement(update_sql);
			
			String user_id = null;
			String prevUserName = null;
			int prevUserAge = 0;
			String prevUserTel = null;
			
			while( true ) {
				System.out.print("수정할 아이디를 입력하세요 : ");
				user_id = in.readLine();
				// select * from users where user_id
				selectPstmt.setString(1, user_id);
				rs = selectPstmt.executeQuery();
				if( rs.next() ) {
					prevUserName = rs.getString("user_name");
					prevUserAge = rs.getInt("user_age");
					prevUserTel = rs.getString("user_tel");
					break;
				} else {
					System.out.println("존재하지 않는 ID 입니다.");
				}
			}
			
			System.out.printf("수정할 이름( 기존의 이름은 -> %s ) : ", prevUserName);			
			updatePstmt.setString(1, in.readLine());
			System.out.printf("수정할 나이( 기존의 나이는 -> %d ) : ", prevUserAge);			
			updatePstmt.setInt(2, Integer.parseInt(in.readLine()));
			System.out.printf("수정할 연락처( 기존의 연락처는 -> %s ) : ", prevUserTel);			
			updatePstmt.setString(3, in.readLine());
			
			updatePstmt.setString(4, user_id);
						
			recordCount = updatePstmt.executeUpdate();
			
			if( recordCount == 1 )
				System.out.println("수정이 완료되었습니다.");
			else
				System.out.println("수정 실패!!!");
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		
		try {
			in.close();
			
			if( rs != null )
				rs.close();
			
			if( selectPstmt != null )
				selectPstmt.close();
			
			if( updatePstmt != null )
				updatePstmt.close();
			
			if( conn != null )
				conn.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		// 내 아이디어. 
//		PreparedStatement pstmt = null;
//		PreparedStatement pstmt_check = null;
//		
//		
//		// Insert 쿼리의 작성 시, values에 추가되는 값은
//		// ? 로 대체하여 손쉽게 값을 입력할 수 있다.
//		String sql = "update users" +
//					" set user_name = ?, user_age = ?, user_tel = ?" +
//					" where user_id = ?";
//		String sql_check = "select * from users" +
//						" where user_id = ?";
//	
//		// Insert, Update, Delete 쿼리를 수행하는 경우
//		// 정수 타입의 값이 반환되며, 적용된 레코드의 개수가 반환
//		// Insert : 입력된 레코드의 개수가 반환
//		// Update : 수정된 레코드의 개수가 반환
//		// Delete : 삭제된 레코드의 개수가 반환
//		int recordCount = 0;
//		ResultSet rs = null;
//		String upId;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			do {
//				pstmt_check = conn.prepareStatement(sql_check);
//				System.out.print("수정할 아이디를 입력하세요 : ");
//				upId = in.readLine();
//				pstmt_check.setString(1, upId);
//				rs = pstmt_check.executeQuery();
//			} while ( !rs.next() );
//			// ?로 지정된 자리의 값을 설정.
//			
//			System.out.print("수정할 이름 : ");
//			pstmt.setString(1, in.readLine());
//			System.out.print("수정할 나이 : ");
//			pstmt.setInt(2, Integer.parseInt(in.readLine()));
//			System.out.print("수정할 연락처 : ");
//			pstmt.setString(3, in.readLine());
//			pstmt.setString(4, upId);
//			
//			// Insert, Update, Delete 쿼리를 수행하는 경우에는
//			// executeUpdate 메소드를 사용하여 쿼리를 실행
//			// (쿼리의 실행 결과로 적용된 레코드의 개수를 반환하는 메소드)
//			recordCount = pstmt.executeUpdate();
//			if( recordCount == 1 )
//				System.out.println("회원 정보 수정 성공 !");
//			else 
//				System.out.println("회원 정보 수정 실패 !");
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
//			
//			if( pstmt != null )
//				pstmt.close();
//			if( conn != null )
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
}
