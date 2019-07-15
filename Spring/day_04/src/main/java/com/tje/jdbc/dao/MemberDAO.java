package com.tje.jdbc.dao;

import com.tje.jdbc.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	                                                                                              
	public MemberDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	// member 테이블의 회원 수 확인
	public int count() {
//		List<Integer> results = this.jdbcTemplate.query(
//				"select count(*) from member", 
//				new RowMapper<Integer>() {
//					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//						return rs.getInt(1);
//					}
//				});
//		return results.get(0);
		
		// 결과가 1행인 경우 위와 같은 의미로 사용할 수 있는 메소드
		return this.jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
	}
	
	public Member selectByEmail(Member model) {
		// JDBC를 사용하여 쿼리를 수행하는 과정
		// 1. 커넥션 객체 반환
		// 2. 커넥션 객체를 사용하여 쿼리를 수행할 수 있는 클래스의 객체 생성
		// - Statement, PreparedStatement
		// 3. 쿼리 수행
		// 4. 쿼리의 수행 결과를 ResultSet 타입의 객체로 반환
		// 5. 반복문을 수행하여 쿼리의 결과를 ResultSet 내부를 순회하며
		//    모델 클래스의 객체로 생성하여 리스트를 생성
		
		// JdbcTemplate의 query메소드를 하면 위 과정을 한번에 해결해준다.
		
		// JdbcTemplate 클래스의 query 메소드
		// 1번째 매개변수는 수행할 SQL문을 작성
		// - 파라메터가 필요한 부분에 ?를 사용하여 작성
		// 2번째 매개변수는 해당 쿼리를 수행한 후, ResultSet 내부를 순회하며
		// 처리할 RowMapper 인터페이스 객체를 전달
		// while (rs.next())
		//  generateObject(rs) <-- RowMapper 객체가 수행할 작업
		// 3번째 이후의 매개변수는 ? 자리를 대체할 변수를 넣어준다.
		// List<Member> results = this.jdbcTemplate.query("select * from member where email=?", new MemberRowMapper(), model.getEmail());
		
		// 2번째 변수 new MemberRowMapper()는 아래의 코드를 대체함. (com.tje.jdbc.dao 패키지의 MemberRowMapper 참고하기)
		//	new RowMapper<Member>() {
		//		// 이거는 인터페이스므로 추상메소드 오버라이딩 해야한다.
		//		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		//			Member member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
		//			return member;
		//		}
		//	}
		//return results.isEmpty() ? null : results.get(0);
		
		// 아래는 List<Member> results = this.jdbcTemplate.query("select * from member where email=?", new MemberRowMapper(), model.getEmail());와 같은 역할
		return this.jdbcTemplate.queryForObject(
				/* 이렇게 해도 되고.
				"select * from member where email=?",
				new RowMapper<Member>() {
					// 이거는 인터페이스므로 추상메소드 오버라이딩 해야한다.
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
						return member;
					}
				}, model.getEmail()
				*/				
				"select * from member where email = ?",
				new RowMapper<Member>() {					
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getTimestamp(5));						
						return member;
					}
				}, 
				model.getEmail());
	}
	
	public int insert(Member model) {
//		int result = this.jdbcTemplate.update("insert into member values (null, ?, ?, ?, now())",
//				model.getEmail(), model.getPassword(), model.getName());
//		return result;
		
		
		/*
		int rows=0;
		int key;
		try (Connection conn = this.ds.getConnection()) {
			
			PreparedStatement pstmt = 
					conn.prepareStatement(
						"insert into member values (null, ?, ?, ?, now())",
						new String[]{"id"}
						);
			pstmt.setString(1, model.getEmail());
			pstmt.setString(2, model.getPassword());
			pstmt.setString(3, model.getName());
			
			// 쿼리가 실행된 레코드의 개수
			rows = pstmt.executeUpdate();			
			ResultSet rs = pstmt.getGeneratedKeys();			
			while( rs.next() ) {
				System.out.println("생성된 키 : " + rs.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return rows;
		*/
		// 아래 코드는 위와 같은 의미이다.
		
		// new String[]{"id"} 로 받은 것을 keyHolder에 저장. 들어간 ID의 값을 확인할 수 있다.
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into member values (null, ?, ?, ?, now())", new String[]{"id"});
				pstmt.setString(1, model.getEmail());
				pstmt.setString(2, model.getPassword());
				pstmt.setString(3, model.getName());
				return pstmt;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}
	
	public int update(Member model) {
		int result = this.jdbcTemplate.update("update member set name=?, password=? where email=?", 
				model.getName(), model.getPassword(), model.getEmail());
		return result;
	}
	
	public List<Member> selectAll() {
		List<Member> results = this.jdbcTemplate.query("select * from member", new MemberRowMapper());
		
		return results.isEmpty() ? null : results;
	}
}
