package tje.chat.server.net;

import tje.chat.common.Packet;

// 특정 클라언트의 메세지를 모든 클라이언트에게
// 전송하는 클래스
// 또는 서버의 공지 메세지를 모든 클라이언트에게
// 전송할 수도 있음
public class BroadCaster {

	// 서버의 공지사항 전달용 메소드
	// 클라이언트Saver에 담긴 클라이언트 수 만큼 받아온 packet을 send한다.
	public static void broadCast(Packet packet) {
		for (int i = 0; i < ClientSaver.getClientSize(); i++)
			ClientSaver.getClient(i).send(packet);
	}
	
	// 클라이언트들끼리 주고받는 대화 전달용 메소드 오버로드
	public static void broadCast(Packet packet, String targetIp) {
		if( ClientSaver.exists(targetIp) ) {
			ClientSaver.getClient(targetIp).send(packet);
		}
	}
}

