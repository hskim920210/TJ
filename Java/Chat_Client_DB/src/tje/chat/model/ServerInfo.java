package tje.chat.model;

import java.io.Serializable;
import tje.jdbc.model.*;

public class ServerInfo implements Serializable {
	private String ip;
	private int port;
	private Member member;

	public ServerInfo(String ip, int port, Member member) {
		super();
		this.ip = ip;
		this.port = port;
		this.member = member;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
