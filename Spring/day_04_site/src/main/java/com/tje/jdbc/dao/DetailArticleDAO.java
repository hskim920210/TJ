package com.tje.jdbc.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tje.jdbc.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DetailArticleDAO {
	private JdbcTemplate jdbcTemplate;
	
	public DetailArticleDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public DetailArticle selectOne(DetailArticle obj) {
		String sql = "select * from detailArticle where article_id = ?";
		return this.jdbcTemplate.queryForObject(sql, DetailArticle.class, obj.getArticle_id());
	}
	
	public List<DetailArticle> selectAll() {
		String sql = "select * from detailArticle";
		List<DetailArticle> results = this.jdbcTemplate.query(sql,
				new RowMapper<DetailArticle>() {
					@Override
					public DetailArticle mapRow(ResultSet rs, int rowNum) throws SQLException {
						DetailArticle detailArticle = new DetailArticle(
								rs.getInt(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getDate(6),
								rs.getDate(7), rs.getInt(8));
						return detailArticle;
					}
			
		});
		return results;
	}
	
	public int insert(DetailArticle obj) {
		String sql = "insert into article values (null,?,?,?,now(),now(),0)";
		return this.jdbcTemplate.update(sql,
				obj.getMember_id(), obj.getTitle(), obj.getContent());
	}
	
	public int delete(DetailArticle obj) {
		String sql = "delete from article where article_id = ?";
		return this.jdbcTemplate.update(sql, obj.getArticle_id());
	}
	
	public int updateReadCount(DetailArticle obj) {
		String sql = "update article set read_count = read_count + 1 where article_id = ?";
		return this.jdbcTemplate.update(sql, obj.getArticle_id());
	}
	
}
