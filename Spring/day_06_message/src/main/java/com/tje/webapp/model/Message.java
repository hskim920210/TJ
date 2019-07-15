package com.tje.webapp.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Message {
	@JsonIgnore
	private int message_id;
	private String sender;
	private String receiver;
	private String content;
	// @JsonFormat(shape = Shape.STRING)
	@JsonFormat(pattern = "yyyyMMddHHmmss")
	private Date send_time;
	@JsonFormat(shape = Shape.STRING)
	private Date receive_time;
	
	public Message() {
	}

	public Message(int message_id, String sender, String receiver, String content, Date send_time, Date receive_time) {
		this.message_id = message_id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.send_time = send_time;
		this.receive_time = receive_time;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSend_time() {
		return send_time;
	}

	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	public Date getReceive_time() {
		return receive_time;
	}

	public void setReceive_time(Date receive_time) {
		this.receive_time = receive_time;
	}
	
}
