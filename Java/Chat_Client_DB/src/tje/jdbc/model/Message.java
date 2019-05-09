package tje.jdbc.model;

import java.io.*;
import java.util.*;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String sender;
	private String sender_name;
	private String receiver;
	private String receiver_name;
	private String message;
	private Date send_date;
	private Date receive_date;

	public Message() {
	}

	public Message(int id, String sender, String sender_name, String receiver, String receiver_name, String message,
			Date send_date, Date receive_date) {
		this.id = id;
		this.sender = sender;
		this.sender_name = sender_name;
		this.receiver = receiver;
		this.receiver_name = receiver_name;
		this.message = message;
		this.send_date = send_date;
		this.receive_date = receive_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public Date getReceive_date() {
		return receive_date;
	}

	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}

}
