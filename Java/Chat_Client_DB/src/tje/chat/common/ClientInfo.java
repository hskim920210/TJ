package tje.chat.common;

import java.io.Serializable;
import java.util.Date;

import tje.jdbc.model.Member;

public class ClientInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String ip;
	private Member member;
	private Date connectedTime;

	public ClientInfo(String ip, Member member, Date connectedTime) {
		super();
		this.ip = ip;
		this.member = member;
		this.connectedTime = connectedTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getConnectedTime() {
		return connectedTime;
	}

	public void setConnectedTime(Date connectedTime) {
		this.connectedTime = connectedTime;
	}
	
	public boolean equals(Object obj) {
		if( !(obj instanceof ClientInfo) )
			return false;
					
		ClientInfo target = (ClientInfo)obj;
		boolean flag1 = this.ip.equals(target.ip);
		boolean flag2 = this.member.getNick().equals(target.member.getNick());
					
		return flag1 && flag2;
	}
}












