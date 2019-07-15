package com.tje.webapp.dao;

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

import com.tje.webapp.model.*;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	                                                                                              
	public MemberDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public int count() {
		return this.jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
	}
	
	public Member selectByEmail(Member model) {
		return this.jdbcTemplate.queryForObject(
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
