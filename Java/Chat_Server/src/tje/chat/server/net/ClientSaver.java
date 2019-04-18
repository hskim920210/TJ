package tje.chat.server.net;

import java.util.*;


public class ClientSaver {
	private static ArrayList<ClientSocket> list = new ArrayList<ClientSocket>();
	// 각 ip 번호랑 소켓으로
	private static HashMap<String, ClientSocket> map = new HashMap<String, ClientSocket>();
	
	public static boolean exists(ClientSocket cs) {
		return map.containsKey(cs.getIp());
	}
	
	public static void insert(ClientSocket cs) {
		list.add(cs);
		map.put(cs.getIp(), cs);
	}
	
	public static void delete(ClientSocket cs) {
		list.remove(cs);
		map.remove(cs.getIp());
	}
	
	

	
}
