package tje.jdbc.dao;

// JDBC 프로그래밍에서  DAO 클래스
// 각각의 테이블에서 검색, 입력, 수정, 삭제 기능을 
// 정의하고 있는 클래스
// 특정 테이블에 대한 모든 작업을 정의하여
// 재활용성을 극대화할 수 있다.
// 일반적인 작명 규칙은 테이블명DAO

import java.sql.*;
import tje.jdbc.util.*;
// Select 절의 실행 결과가 다수개인 경우 컬렉션 클래스를 활용하기 위한 import 구문
import java.util.*;
// Select 절의 실행 결과를 저장하기 위한 모델 클래스의 패키지
import tje.jdbc.model.*;

public class CityDAO {
	// static 멤버 필드로 현재 DAO 클래스의 객체를 1개 생성
	private static CityDAO instance = new CityDAO();
	
	// 생성된 DAO 클래스의 객체를 반환할 수 있는 static 메소드를 제공
	public static CityDAO getInstance() {
		return instance;
	}
	// DAO 클래스들은 동일한 기능을 제공하는 클래스이므로
	// 싱글턴 패턴을 적용하여 객체를 1개만 생성되도록 제어한다.
	
	// DAO 클래스의 외부에서 객체를 생성할 수 없도록 
	// 생성자를 private으로 지정
	private CityDAO() {}
	
	// DAO 클래스의 검색기능 메소드는
	// 모델 클래스의 객체 또는 리스트를 반환하는 것이 일반적이다.
	// - select 절의 실행 결과를 
	//   모델 클래스의 객체로 변환하여
	//   ResultSet 객체를 순회하는 코드의 중복을 제거하기 위해서
	// - 모델 클래스 : 특정 테이블의 컬럼들과 맵핑된 멤버필드를 제공하는 클래스.
	// - 모델 클래스의 객체는 특정 테이블의 레코드의 정보를 저장한다.
	
	public ArrayList<City> select(Connection conn) {
		ArrayList<City> result = new ArrayList<City>();
		String sql = "select * from city";
		
		Statement stmt = JDBCObjectManager.getStatement(conn);
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			while( rs.next() ) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String countryCode = rs.getString(3);
				String district = rs.getString(4);
				int population = rs.getInt(5);
				
				City city = new City(id, 
									name, 
									countryCode, 
									district, 
									population);
				result.add(city);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		return result;
	}
	
	// DAO 클래스의 입력, 수정, 삭제 기능은
	// 일반적으로 정수 타입을 반환한다.
	// - executeUpdate 메소드의 실행 결과인
	//   SQL 문의 적용 레코드의 수를 반환하기 위해서
	
//	public int insert() {
//		
//	}
//	
//	public int update() {
//		
//	}
//	
//	public int delete() {
//		
//	}
}
