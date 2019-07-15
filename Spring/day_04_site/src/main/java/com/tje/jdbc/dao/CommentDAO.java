package com.tje.jdbc.dao;

import com.tje.jdbc.model.*;
import java.sql.*;
import java.util.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class CommentDAO {
	private JdbcTemplate jdbcTemplate;
	
	public CommentDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public int insertWithReturnsKey(Comment obj) {
		String sql = "insert into member values (null, ?, ?, ?, now())";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id"});
				pstmt.setInt(1, obj.getArticle_id());
				pstmt.setString(2, obj.getMember_id());
				pstmt.setString(3, obj.getContent());
				return pstmt;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}
	
	public int selectCount(Comment obj) {
		String sql = "select count(*) from member";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public Comment selectOne(Comment obj) {
		String sql = "select * from comment where comment_id = ?";
		return this.jdbcTemplate.queryForObject(sql, Comment.class, obj.getComment_id());
	}
	
	public List<Comment> selectAll(Comment obj) {
		String sql = "select * from comment where article_id = ? order by write_time asc";
		List<Comment> results = this.jdbcTemplate.query(sql,
				new RowMapper<Comment>() {
					@Override
					public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
						Comment comment = new Comment(
								rs.getInt(1), rs.getInt(2),
								rs.getString(3), rs.getString(4), rs.getDate(5));
						return comment;
					}
			
		}, obj.getArticle_id());
		return results;
	}
	
	public int delete(Comment obj) {
		String sql = "delete from comment where comment_id = ?";
		return this.jdbcTemplate.update(sql, obj.getComment_id());
	}
}
