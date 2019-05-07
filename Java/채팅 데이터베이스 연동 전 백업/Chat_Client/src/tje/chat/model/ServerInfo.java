package tje.chat.model;

import java.io.Serializable;

// 받아온 ip, 포트번호, 닉네임을 저장하는 클래스.
public class ServerInfo implements Serializable {
	private String ip;
	private int port;
	private String nickName;

	public ServerInfo(String ip, int port, String nickName) {
		super();
		this.ip = ip;
		this.port = port;
		this.nickName = nickName;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
