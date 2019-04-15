package Chatting;

import java.util.*;

// 컬렉션 클래스의 객체를 사용하여 
// 현재 서버에 접속 중인 클라이언트들을 저장하는 클래스
public class ClientList {
	private static ArrayList<ClientSocket> CLIENTS = new ArrayList<ClientSocket>();
	
	public static int getClientSize() {
		return CLIENTS.size();
	}
	
	public static ClientSocket getClient(int index) {
		return CLIENTS.get(index);
	}
	
	public static void addClient(ClientSocket client) {
		CLIENTS.add(client);
		
	}
	
	public static void delClient(ClientSocket client) {
		CLIENTS.remove(client);
		
	}
	
	public static boolean checkClient(ClientSocket client) {
		return CLIENTS.contains(client);
	}
}










