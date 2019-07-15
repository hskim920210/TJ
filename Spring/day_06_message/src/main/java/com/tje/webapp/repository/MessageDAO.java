package com.tje.webapp.repository;

import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tje.webapp.model.*;
import com.tje.webapp.setting.*;

@Repository
public class MessageDAO {
	@Autowired
	private PagingInfo pagingInfo;
	
	private JdbcTemplate jdbcTemplate;
	
	// 생성자 호출에 필요한 DataSource 타입의 객체를
	// 스프링 컨테이너에서 검색하여 자동으로 DI 처리 
	@Autowired
	public MessageDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 반복되는 코드를 이너클래스로 뺀다.
	class MessageRowMapper implements RowMapper<Message> {
		@Override
		public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
			Message message = new Message(
					rs.getInt(1),			// message_id
					rs.getString(2),		// sender
					rs.getString(3),		// receiver
					rs.getString(4),		// content
					rs.getTimestamp(5),		// send_time
					rs.getTimestamp(6));	// receive_time	
			return message;
		}
		
	}
	
	public Message selectById(Message model) {
		return this.jdbcTemplate.queryForObject(
				"select * from message where message_id = ?",
				new MessageRowMapper(), 
				model.getMessage_id());
	}
	
	// 각 사용자 별, 받은 메세지의 개수를 반환하는 메소드
	public Integer selectByReceiverCount(Message model) {
		return this.jdbcTemplate.queryForObject(
				"select count(*) from message where receiver = ?",
				Integer.class, 
				model.getReceiver());
	}
	// 각 사용자 별, 보낸 메세지의 개수를 반환하는 메소드
	public Integer selectBySenderCount(Message model) {
		return this.jdbcTemplate.queryForObject(
				"select count(*) from message where sender = ?",
				Integer.class, 
				model.getSender());
	}
	
	// 현재 페이지의 정보를 매개변수로 전달받아 현재 페이지에 해당되는 메세지를 반환하는 메소드
	public List<Message> selectBySender(Message model, int page) {
		List<Message> result = this.jdbcTemplate.query("select * from message where sender = ? order by message_id limit ?,?",
				new MessageRowMapper(), model.getSender(), (page-1) * this.pagingInfo.getPagingSize(), this.pagingInfo.getPagingSize());
		
		return result.isEmpty() ? null : result;
	}
	
	public List<Message> selectBySender_Date(MessageSearchCommand command, String sender) {
		List<Message> result = this.jdbcTemplate.query(
				"select * from message where sender = ? and send_time between ? and ? order by message_id",
				new MessageRowMapper(), sender, command.getFrom(), command.getTo());
		
		return result.isEmpty() ? null : result;
	}
	
	public List<Message> selectByReceiver(Message model, int page) {
		List<Message> result = this.jdbcTemplate.query("select * from message where receiver = ? order by message_id limit ?,?",
				new MessageRowMapper(), model.getReceiver(), (page-1) * this.pagingInfo.getPagingSize(), this.pagingInfo.getPagingSize());
		
		return result.isEmpty() ? null : result;
	}
	
	// 작성 날짜를 기준으로 받은 메세지를 검색하는 메소드
	public List<Message> selectByReceiver_Date(MessageSearchCommand command, String receiver) {
		List<Message> result = this.jdbcTemplate.query(
				"select * from message where receiver = ? and send_time between ? and ? order by message_id",
				new MessageRowMapper(), receiver, command.getFrom(), command.getTo());
		
		return result.isEmpty() ? null : result;
	}
	
	
	public List<Message> selectAll() {
		List<Message> result = this.jdbcTemplate.query("select * from message", new MessageRowMapper());
		
		return result.isEmpty() ? null : result;
	}
	
	public int insert(Message model) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into message values (null, ?, ?, ?, now(), null)", new String[]{"message_id"});
				pstmt.setString(1, model.getSender());
				pstmt.setString(2, model.getReceiver());
				pstmt.setString(3, model.getContent());
				return pstmt;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}
	
	public int updateReceiveTime(Message model) {
		return this.jdbcTemplate.update("update message set receive_time=now() where message_id=? and receive_time is null", model.getMessage_id());
	}
}
