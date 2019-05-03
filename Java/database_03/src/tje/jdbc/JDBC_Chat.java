package tje.jdbc;

import java.sql.*;
import tje.jdbc.*;
import tje.jdbc.dao.*;
import tje.jdbc.model.*;
import tje.jdbc.util.*;

public class JDBC_Chat {
	public static void main(String[] args) {
		// Chat 데이터 베이스의 연결 객체를 반환
		Connection conn = JDBCConnection.getConnection();
		
		// chat 데이터베이스의 User 테이블에 대한
		// JDBC 작업을 제공하는 DAO 클래스
		UserDAO dao = UserDAO.getInstance();
		
		// 1. 입력 ( 모델 객체 활용 )
		User user1 = new User("abc", "123", "tje1", "tje1", "010-1111-1111");
		dao.insert(conn, user1);
		
		User user2 = new User("def", "456", "tje2", "tje2", "010-2222-2222");
		dao.insert(conn, user2);
		
//		// 2. 수정
//		User user3 = new User("abc", "1234567890");
//		dao.updatePassword(conn, user3);
		
		// 3. 검색
		User user4 = dao.select(conn, new User("def"));
		System.out.println(user4);
		
		// 4. 삭제
		User user5 = new User("def");
		dao.delete(conn, user5);
		
		// 5. 다수개의 컬럼 값을 수정
		User user = new User("abc", "1234567890", "sf", "sf", "010-68464654564354354");
		
		// Connection 클래스 객체의 setAutoCommit 메소드는 
		// 자동 커밋을 지정/해제할 수 있는 메소드다.
		// 매개변수를 false로 지정하는 경우
		// 쿼리의 작업 이후 commit 또는 rollback 메소드를 호출하여
		// 쿼리의 결과를 저장 또는 취소할 수 있다.
		// (예외처리는 별도의 util 클래스를 사용하여 처리함)
		JDBCObjectManager.setAutoCommit(conn, false);
		
		int recordCount = 0;
		recordCount += dao.updatePassword(conn, user);
		recordCount += dao.updateName(conn, user);
		recordCount += dao.updateAlias(conn, user);
		recordCount += dao.updateTel(conn, user);
		
		if( recordCount == 4 )
			// 모든 업데이트 쿼리가 정상적으로 실행된 경우
			// commit 메소드를 호출하여 DB에 저장
			JDBCObjectManager.commit(conn);
		else
			// 모든 업데이트 쿼리 중 하나라도 문제가 발생하는 경우
			// rollback 메소드를 호출하여 현재까지의 모든 작업을 취소함
			JDBCObjectManager.rollback(conn);
		
		JDBCObjectManager.close(conn);
	}
}
