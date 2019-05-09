package tje.jdbc.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import tje.jdbc.util.*;
import tje.jdbc.model.*;

public class MessageDAO {
	private static MessageDAO instance = new MessageDAO();

	public static MessageDAO getInstance() {
		return instance;
	}

	private MessageDAO() {
	}
	
	private Message generateObject(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String sender = rs.getString(2);
		String sender_name = rs.getString(3);
		String receiver = rs.getString(4);
		String receiver_name = rs.getString(5);
		String message = rs.getString(6);
		Date send_date = rs.getTimestamp(7);
		Date receive_date = rs.getTimestamp(8);
		return new Message(id, sender, sender_name, receiver, receiver_name, message, send_date, receive_date);
	}

	public ArrayList<Message> select(Connection conn) {
		ArrayList<Message> result = new ArrayList<>();		
		String sql = "select * from message_view";
		Statement stmt = JDBCObjectManager.getStatement(conn);
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {				
				Message model = generateObject(rs);
				result.add(model);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		
		return result;
	}

	public Message select(Connection conn, Message model) {
		Message result = null;		
		String sql = "select * from message_view where id = ?";
		PreparedStatement stmt = JDBCObjectManager.getStatement(conn, sql);
		ResultSet rs = null;
		
		try {
			stmt.setInt(1, model.getId());
			rs = stmt.executeQuery();
			
			if( rs.next() ) {				
				result = generateObject(rs);				
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		
		return result;
	}

	public int insert(Connection conn, Message model) {
		int result = 0;		
		String sql = "insert into message values (?,?,?,?,now(),null)";
		PreparedStatement stmt = JDBCObjectManager.getStatement(conn, sql);		
		
		try {
			stmt.setInt(1, model.getId());
			stmt.setString(2, model.getSender());
			stmt.setString(3, model.getReceiver());
			stmt.setString(4, model.getMessage());			
			result = stmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		JDBCObjectManager.close(stmt);
		
		return result;
	}
}
