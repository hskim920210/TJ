package com.personal.khs.repository;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import com.personal.khs.model.*;

@Repository
public class UserDAO {
	private JdbcTemplate jdbcTemplate;
	
	// root-context.xml에 정의해놓은 스프링 빈 객체인 dataSource 주입
	// DataSource 는 org.apache.tomcat.jdbc.poo.DataSource 임에 주의
	@Autowired
	public UserDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 쿼리 수행 결과 resultSet의 속성들을 기반으로 객체를 만들어 저장해주는 RowMapper 인터페이스.
	// 반드시 mapRow 메소드를 오버라이딩 한다.
	// org.springframework.jdbc.core.RowMapper 임에 주의
	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUser_id(rs.getString(1));
			user.setUser_pw(rs.getString(2));
			user.setUser_nick(rs.getString(3));
			user.setUser_tel(rs.getString(4));
			user.setUser_mail(rs.getString(5));
			user.setUser_regist_date(rs.getTimestamp(6));
			user.setUser_count_day(rs.getInt(7));
			return user;
		}
	}
	
	// user_id로 검색하여 결과를 User로 리턴하는 메소드
	// 결과는 1개만 나올 것이므로 queryForObject를 사용한다.
	public User selectById(User model) throws Exception {
		String sql = "select * from user where user_id = ?";
		return this.jdbcTemplate.queryForObject(sql,
				new UserRowMapper(), model.getUser_id());
	}
	
	// 회원가입을 위해 사용자로부터 받아온 정보를 토대로 테이블에 insert 하는 메소드.
	// 회원가입에 성공하면 1을 리턴하고 실패하면 0을 리턴한다.
	public int insert(User model) {
		String sql = "insert into user values (?,?,?,?,?,now(),1)";
		return this.jdbcTemplate.update(sql,
				model.getUser_id(), model.getUser_pw(), model.getUser_nick(),
				model.getUser_tel(), model.getUser_mail());
	}
	
}
