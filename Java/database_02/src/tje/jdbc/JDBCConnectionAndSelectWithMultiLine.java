package tje.jdbc;

import java.sql.*;

// 사원명, 부서명, 직책, 근무지 도시명을 출력하세요.
// (급여의 정보가 7000 이상, 15000 이하인 사원만)

public class JDBCConnectionAndSelectWithMultiLine {
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
		int startSalary = 7000;
		int endSalary = 15000;
		String targetName = "a";
		
		// 여러 라인으로 구성된 SQL 문을 작성하는 경우
		// 공백 문자의 부재로 인해 쿼리문에서 에러가 발생할 수 있다.
		// 이런 문제는 각 쿼리문의 시작 부분에 공백을 임의로 추가하여 해결할 수 있다.
		String sql = "select first_name || ' ' || last_name as \"e_name\", department_name as \"d_name\", job_title as \"j_title\", city, salary" + 
				" from EMPLOYEES inner join DEPARTMENTS using(DEPARTMENT_ID)" + 
				"  inner join Locations using(location_id)" + 
				"  inner join jobs using(job_id)" + 
				" where salary BETWEEN " + startSalary + " AND " + endSalary +
				" and lower(first_name || ' ' || last_name) like '%" + targetName + "%'"; 
	
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
				String e_name = rs.getString(1);
				String d_name = rs.getString(2);
				String j_title= rs.getString(3);
				String city = rs.getString(4);
				int salary = rs.getInt(5);
				
				String record = String.format("%s - %s - %s - %s - %d", 
						e_name, d_name, j_title, city, salary);
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
