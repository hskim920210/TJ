package com.tje.jdbc.dao;

import com.tje.jdbc.model.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public Member selectOne(Member obj) {
		String sql = "select * from member where member_id = ?";
		return this.jdbcTemplate.queryForObject(sql, Member.class, obj.getMember_id());
	}
	
	public List<Member> selectAll() {
		String sql = "select * from member";
		List<Member> results = this.jdbcTemplate.query(sql,
				new RowMapper<Member>() {
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getInt(4), rs.getInt(5),
								rs.getDate(6), rs.getString(7), rs.getString(8),
								rs.getDate(9), rs.getDate(10));
						return member;
					}
				});
		return results;
	}
	
	public int insert(Member obj) {
		String sql = "insert into member values (?,?,?,?,?,?,?,?,now(),null)";
		return this.jdbcTemplate.update(sql,
				obj.getMember_id(), obj.getPassword(), obj.getName(),
				obj.getGender(), obj.getAge(), obj.getBirth(),
				obj.getTel(), obj.getAddress());
	}
	
	public int updateLastAT(Member obj) {
		String sql = "update member set last_access_time = now() where member_id = ?";
		return this.jdbcTemplate.update(sql, obj.getMember_id());
	}
	
	public int updatePassword(Connection conn, Member obj) {
		String sql = "update member set password = ? where member_id = ?";
		return this.jdbcTemplate.update(sql, obj.getPassword(), obj.getMember_id());
	}
	
	
	
}
