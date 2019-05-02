package tje.jdbc;

import java.sql.*;

public class JDBCConnectionAndSelect {
	public static void main(String[] args) {
		// 1. JDBC 드라이버 클래스 로딩
		String strDriverClassName = "oracle.jdbc.driver.OracleDriver";
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
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "hr";
		String password = "hr";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DBMS 연결 성공");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패");
			e.printStackTrace();
			return;
		}
		
		// 연결된 DBMS에 쿼리문을 실행할 수 있는 영역
		// java.sql.Statement 클래스
		// - java.sql.Connection 클래스의 객체로부터 생성되는 객체 타입
		// - 연결된 DBMS에 쿼리문을 실행할 수 있는 클래스
		Statement stmt = null;
		String sql = "select * from departments"; 
		
		ResultSet rs = null;
		
		try {
			// 연결된 DBMS로부터 쿼리문을 실행할 수 있는 객체를 반환받는 코드
			stmt = conn.createStatement();
			
			// java.sql.Statement 클래스의 execute XXX 메소드
			// 문자열 값을 매개변수로 전달받아 해당 문자열의 SQL을
			// DBMS를 통해 실행한 후, 실행의 결과를 반환받는 메소드
			
			// executeQuery 메소드는 SELECT절을 실행한 후,
			// 실행의 결과를 java.sql.ResultSet 클래스 타입으로 반환한다.
			rs = stmt.executeQuery(sql);
			
			// rs.next 하면 그다음줄에 한줄이 있는지 확인하여 T/F 반환
			while( rs.next() ) {
				int department_id = rs.getInt(1);
				String department_name = rs.getString("department_name");
				int manager_id = rs.getInt(3);
				int location_id = rs.getInt("location_id");
				
				String record = 
						String.format(
								"%d - %s - %d - %d\n", department_id, department_name, manager_id, location_id);
				System.out.println(record);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			if( rs != null )
				rs.close();
			if( stmt != null )
				stmt.close();
			if( conn != null )
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
