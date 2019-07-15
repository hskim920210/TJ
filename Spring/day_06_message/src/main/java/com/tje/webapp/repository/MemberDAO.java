package com.tje.webapp.repository;

import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tje.webapp.model.*;

@Repository
public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	
	// 생성자 호출에 필요한 DataSource 타입의 객체를
	// 스프링 컨테이너에서 검색하여 자동으로 DI 처리 
	@Autowired
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 반복되는 코드를 이너클래스로 뺀다.
	class MemberRowMapper implements RowMapper<Member> {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(
					rs.getString(1),	// member_id
					rs.getString(2),	// password
					rs.getString(3),	// name		
					false);	// rememberID	
			return member;
		}
		
	}
	
	public Member selectById(Member model) throws Exception {
		// select 문의 경우에 결과가 아예 없으면 예외가 발생한다.
		return this.jdbcTemplate.queryForObject(
				"select * from member where member_id = ?",
				new MemberRowMapper(), 
				model.getMember_id());
	}
	
	public List<Member> selectByIds(Member model) throws Exception {
		List<Member> result = this.jdbcTemplate.query(
				"select * from member where member_id like ?",
				new MemberRowMapper(),
				"%" + model.getMember_id() + "%");
		
		return result.isEmpty() ? null : result;
	}
	
	public List<Member> selectAll() {
		List<Member> result = this.jdbcTemplate.query("select * from member", new MemberRowMapper());
		
		return result.isEmpty() ? null : result;
	}
	
	public int insert(Member model) {
		System.out.println(model.getMember_id());
		System.out.println(model.getPassword());
		System.out.println(model.getName());
		return this.jdbcTemplate.update(
				"insert into member values (?, ?, ?)", 
				model.getMember_id(), 
				model.getPassword(),
				model.getName());
	}
}
