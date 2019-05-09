package tje.chat.server.net;

import tje.chat.common.Packet;

// 특정 클라언트의 메세지를 모든 클라이언트에게
// 전송하는 클래스
// 또는 서버의 공지 메세지를 모든 클라이언트에게
// 전송할 수도 있음
public class BroadCaster {	
	
	// 서버의 공지사항 전당용 메소드
	public static void broadCast(Packet packet) {
		for( int i = 0 ; i < ClientSaver.getClientSize() ; i++ )
			ClientSaver.getClient(i).send(packet);
	}
	
	public static void broadCast(Packet packet, String targetIp) {
		if( ClientSaver.exits(targetIp) )
			ClientSaver.getClient(targetIp).send(packet);
	}

}









