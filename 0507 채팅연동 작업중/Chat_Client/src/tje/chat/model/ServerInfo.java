package tje.chat.model;

import java.io.Serializable;

import tje.chat.common.jdbc.model.User;

// 받아온 ip, 포트번호, 닉네임을 저장하는 클래스.
public class ServerInfo implements Serializable {
	private String ip;
	private int port;
	private String ID;
	private User user;

	public ServerInfo(String ip, int port, String ID, User user) {
		super();
		this.ip = ip;
		this.port = port;
		this.ID = ID;
		this.user = user;
	}
	
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
}
