package tje.chat.common;

import java.io.*;
import java.util.*;

// 클라이언트의 목록정보 저장
// 서버와 클라이언트가 공유하는 정보
// ip와 별칭, 접속시간을 필드로 갖는다.
public class ClientInfo implements Serializable {
	// 서버와 클라이언트가 같은 UID 1L을 사용하도록 한다
	private static final long serialVersionUID = 1L;
	private String ip;
	private String ID;
	private Date connectedTime;
	
	public ClientInfo(String ip, String ID, Date connectedTime) {
		super();
		this.ip = ip;
		this.ID = ID;
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
}
