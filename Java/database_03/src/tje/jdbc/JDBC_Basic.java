package tje.jdbc;

import java.sql.*;
import java.util.ArrayList;

import tje.jdbc.dao.CityDAO;
import tje.jdbc.model.City;
import tje.jdbc.util.*;

public class JDBC_Basic {
	public static void main(String[] args) {
		// 1. 드라이버 클래스 로딩
		// - JDBC 드라이버 클래스의 로딩 과정은
		// 	  프로그램의 진행 중, 단 한번만 실행하면 된다.

		// 2. DBMS 연결 객체 생성
		Connection conn = JDBCConnection.getConnection();
		
//		// 3. 쿼리(SQL) 실행 객체 생성
//		String sql = "select * from city";
//		
//		Statement stmt = JDBCObjectManager.getStatement(conn);
//		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);

		// CityDAO dao = new CityDAO();
		CityDAO dao = CityDAO.getInstance();
		// 4. 쿼리의 수행 및 결과 확인
		ArrayList<City> result = dao.select(conn);
		for( int i = 0 ; i < result.size() ; i++ ) {
			System.out.printf("%d, %s, %s, %s, %d\n", 
									result.get(i).getId(), 
									result.get(i).getName(), 
									result.get(i).getCountryCode(), 
									result.get(i).getDistrict(), 
									result.get(i).getPopulation());
		}
		
//		ResultSet rs = null;
//		try {
//			rs = pstmt.executeQuery();
//			
//			while( rs.next() ) {
//				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				String countrycode = rs.getString(3);
//				String district = rs.getString(4);
//				int population = rs.getInt(5);
//				
//				System.out.printf("%d, %s, %s, %s, %d\n", id, name, countrycode, district, population);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		// 4. 종료 처리
//		JDBCObjectManager.close(rs);
//		JDBCObjectManager.close(stmt);
//		JDBCObjectManager.close(pstmt);
		JDBCObjectManager.close(conn);
	}
}

// 1. 드라이버 클래스 로딩
// - JDBC 드라이버 클래스의 로딩 과정은
// 	  프로그램의 진행 중, 단 한번만 실행하면 된다.
//////////////////////////////////////////////////////////////////
//String JDBCDriverClass = "com.mysql.cj.jdbc.Driver";			//
//	try {														//
//		Class.forName(JDBCDriverClass);							//
//	} catch (ClassNotFoundException e) {						//
//		e.printStackTrace();									//
//	}															//
//////////////////////////////////////////////////////////////////

// 아래는 static 메소드이므로 객체생성없이 바로 부를 수 있다.
// JDBCDriverLoader.init();
// 그런데 이건 Connection 최초로 얻어올 때 단 한번만 불리면 되므로
// JDBCConnection 클래스에서 static으로 불러준다.


// 2. DBMS 연결 객체 생성
//////////////////////////////////////////////////////////////////////////////
//	Connection conn = null;													//
//																			//
//	String url = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";	//
//	String user = "root";													//
//	String password = "SystemManager304";									//
//																			//
//	try {																	//
//		conn = DriverManager.getConnection(url, user, password);			//
//		System.out.println("DBMS 생성 완료 !");									//
//	} catch (SQLException e) {												//
//		e.printStackTrace();												//
//	}																		//
//////////////////////////////////////////////////////////////////////////////	


// 3. 쿼리(SQL) 실행 객체 생성
//////////////////////////////////////////////////
//	Statement stmt = null;						//
//	PreparedStatement pstmt = null;				//
//	try {										//
//		stmt = conn.createStatement();			//
//		pstmt = conn.prepareStatement(sql);		//
//	} catch (SQLException e) {					//
//		e.printStackTrace();					//
//	}											//
//////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////
// 4. 쿼리문 수행 및 결과출력 내가 한거																		//
//		try {																						//
//			rs = stmt.executeQuery(sql);															//
//		} catch (SQLException e) {																	//
//			e.printStackTrace();																	//
//		}																							//
//																									//	
//		try {																						//
//			while( rs.next() ) {																	//
//				String name = rs.getString(2);														//
//				String countryCode = rs.getString(3);												//
//				String district = rs.getString(4);													//
//				int population = rs.getInt(5);														//
//																									//
//				String table = String.format(														//
//						"%s - %s - %s - %d\n", name, countryCode, district, population);			//
//																									//
//				System.out.println(table);															//
//			}																						//
//		} catch (SQLException e) {																	//
//			e.printStackTrace();																	//
//		}																							//
//																									//
//		String sql_p = "select * from ?";															//
//		try {																						//
//			pstmt.setString(1, "city");																//
//		} catch (SQLException e) {																	//
//			e.printStackTrace();																	//
//		}																							//
//																									//
//		try {																						//
//			rs = pstmt.executeQuery();																//
//		} catch (SQLException e) {																	//
//			e.printStackTrace();																	//
//		}																							//
//																									//
//		try {																						//
//			while( rs.next() ) {																	//
//				String name_p = rs.getString(2);													//
//				String countryCode_p = rs.getString(3);												//
//				String district_p = rs.getString(4);												//
//				int population_p = rs.getInt(5);													//
//																									//
//				String table = String.format(														//
//						"%s - %s - %s - %d\n", name_p, countryCode_p, district_p, population_p);	//
																			
//				
//				System.out.println(table);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////

// 4. 종료 처리
//////////////////////////////////////
//	try {							//
//		stmt.close();				//
//		pstmt.close();				//
//		conn.close();				//
//	} catch (SQLException e) {		//
//		e.printStackTrace();		//
//	}								//
//////////////////////////////////////
