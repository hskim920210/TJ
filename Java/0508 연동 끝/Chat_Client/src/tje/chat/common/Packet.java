package tje.chat.common;

import java.io.Serializable;

// 서로 다른 유형의 데이터들을 하나의 스트림으로 주고받기 위해
// 객체화 시켜 전달하기 위한 패킷 클래스.
public class Packet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 헷갈림 방지용 상수 설정
	public static final int TYPE_NOTICE = 1;
	public static final int TYPE_NEW_CLIENT = 2;
	public static final int TYPE_DISCONECT_CLIENT = 3;
	public static final int TYPE_CLIENT_MSG = 4;
	public static final int TYPE_SIGN_INFO = 5;
	
	
	// 데이터 타입
	// 1. 공지메시지 
	// 2. 서버에 새롭게 접속한 클라이언트의 정보
	// 3. 서버와 연결이 종료된 클라이언트의 정보
	// 4. 클라이언트 간의 메세지
	// 5. 회원가입 정보
	// 이 데이터들을 하나의 객체로 묶어서 전송하여 하나의 스트림으로도 다양한 데이터를 주고받을 수 있도록 설정한다.
	private int packetType;
	private Object packetData;
	private String targetIp;
	private String sourceIp;
	private String sourceID;
	
	public Packet(int packetType, Object packetData) {
		this.packetType = packetType;
		this.packetData = packetData;
	}
	
	// ip정보까지 받을수있는 생성자 오버로딩
	public Packet(int packetType, Object packetData, String targetIp, String sourceIp, String sourceID) {
		this(packetType, packetData);
		this.targetIp = targetIp;
		this.sourceIp = sourceIp;
		this.sourceID = sourceID;
	}
	
	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getSourceID() {
		return sourceID;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}
	
	public String getTargetIp() {
		return targetIp;
	}

	public void setTargetIp(String targetIp) {
		this.targetIp = targetIp;
	}

	public int getPacketType() {
		return packetType;
	}

	public void setPacketType(int packetType) {
		this.packetType = packetType;
	}

	public Object getPacketData() {
		return packetData;
	}

	public void setPacketData(Object packetData) {
		this.packetData = packetData;
	}
	
	

}
