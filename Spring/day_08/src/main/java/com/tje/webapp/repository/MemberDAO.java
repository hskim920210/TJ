package com.tje.webapp.repository;

import java.sql.*;
import java.util.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tje.webapp.model.*;

@Repository
public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	class MemberRowMapper implements RowMapper<Member> {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), false);
			return member;
		}
		
	}
	
	public Member selectById(Member model) throws Exception {
		String sql = "select * from member where member_id = ?";
		return this.jdbcTemplate.queryForObject(sql, new MemberRowMapper(), model.getMember_id());
	}
	
	public List<Member> selectByIdSearch(Member model) throws Exception {
		String sql = "select * from member where member_id like ?";
		String searchId = "%" + model.getMember_id() + "%";
		List<Member> result = this.jdbcTemplate.query(sql, new MemberRowMapper(), searchId);
		return result.isEmpty() ? null : result;
	}
	
	public List<Member> selectAll() {
		String sql = "select * from member";
		List<Member> result = this.jdbcTemplate.query(sql, new MemberRowMapper());
		return result.isEmpty() ? null : result;
	}
	
	public int insert(Member model) {
		String sql = "insert into member values (?, ?, ?)";
		return this.jdbcTemplate.update(sql, model.getMember_id(), model.getPassword(), model.getName());
	}
}
