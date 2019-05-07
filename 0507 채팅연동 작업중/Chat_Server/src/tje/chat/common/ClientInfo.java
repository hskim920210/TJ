package tje.chat.common;

import java.io.*;
import java.util.*;

import tje.chat.common.jdbc.model.User;

// 클라이언트의 목록정보 저장
// 서버와 클라이언트가 공유하는 정보
// ip와 별칭, 접속시간을 필드로 갖는다.
public class ClientInfo implements Serializable {
	// 서버와 클라이언트가 같은 UID 1L을 사용하도록 한다
	private static final long serialVersionUID = 1L;
	private String ip;
	private String ID;
	private Date connectedTime;
	private User user;
	
	public ClientInfo(String ip, User user, Date connectedTime) {
		super();
		this.ip = ip;
		this.ID = user.getId();
		this.connectedTime = connectedTime;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public Date getConnectedTime() {
		return connectedTime;
	}
	public void setConnectedTime(Date connectedTime) {
		this.connectedTime = connectedTime;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 두 객체가 ip주소로 동일한지 확인 ( 클라이언트 세이버 클래스에서 remove info_list 하기 위한 작업 )
	@Override
	public boolean equals(Object obj) {
		if( !(obj instanceof ClientInfo) )
			return false;
		
		ClientInfo target = (ClientInfo)obj;
		boolean flag1 = this.ip.equals(target.ip);
		boolean flag2 = this.ID.equals(target.ID);
		
		return flag1 && flag2;
	}
}
