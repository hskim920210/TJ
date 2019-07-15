package com.tje.jdbc.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tje.jdbc.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SimpleArticleDAO {
	private JdbcTemplate jdbcTemplate;
	
	public SimpleArticleDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public int selectAllCount() {
		String sql = "select count(*) from simpleArticle";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public List<SimpleArticle> selectAll() {
		String sql = "select * from simpleArticle";
		List<SimpleArticle> results = this.jdbcTemplate.query(sql,
				new RowMapper<SimpleArticle>() {
					@Override
					public SimpleArticle mapRow(ResultSet rs, int rowNum) throws SQLException {
						SimpleArticle simpleArticle = new SimpleArticle(
								rs.getInt(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getDate(5), 
								rs.getInt(6), rs.getInt(7));
						return simpleArticle;
					}
			
		});
		return results;
	}
	
	
	public List<SimpleArticle> select(String searchItem, String searchValue) {
		String sql = String.format("select * from simpleArticle where %s like ?", searchItem);
		List<SimpleArticle> results = this.jdbcTemplate.query(sql,
				new RowMapper<SimpleArticle>() {
					@Override
					public SimpleArticle mapRow(ResultSet rs, int rowNum) throws SQLException {
						SimpleArticle simpleArticle = new SimpleArticle(
								rs.getInt(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getDate(5), 
								rs.getInt(6), rs.getInt(7));
						return simpleArticle;
					}
			
		}, searchValue);
		return results;
	}
	
	public int delete(SimpleArticle obj) {
		int result = 0;
		String sql = "delete from article where article_id=?";
		result = this.jdbcTemplate.update(sql, obj.getArticle_id());
		return result;
	}
	
	
}	
