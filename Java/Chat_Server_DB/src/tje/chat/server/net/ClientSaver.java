package tje.chat.server.net;

import java.util.*;

import tje.chat.common.*;

public class ClientSaver {
	private static ArrayList<ClientSocket> socket_list = new ArrayList<>();
	private static HashMap<String, ClientSocket> map = new HashMap<>();
	
	private static ArrayList<ClientInfo> info_list = new ArrayList<>();	
	
	public static ArrayList<ClientInfo> getInfo_list() {
		return info_list;
	}
	
	public static boolean exits(ClientSocket cs) {
		return map.containsKey(cs.getIp());
	}
	
	public static boolean exits(String targetIp) {
		return map.containsKey(targetIp);
	}
	
	public static ClientSocket getClient(String targetIp) {
		return map.get(targetIp);
	}
	
	public static void insert(ClientSocket cs) {
		socket_list.add(cs);
		map.put(cs.getIp(), cs);
		
		Date now = Calendar.getInstance().getTime();
		ClientInfo info = new ClientInfo(cs.getIp(), cs.getMember(), now);
				
		Packet packet = new Packet(Packet.TYPE_NEW_CLIENT, info);
		info_list.add(info);
		
		BroadCaster.broadCast(packet);
	}
	
	public static synchronized void delete(ClientSocket cs) {
		socket_list.remove(cs);
		map.remove(cs.getIp());
		
		int index = info_list.indexOf(new ClientInfo(cs.getIp(), cs.getMember(), null));
		Packet packet = new Packet(Packet.TYPE_DISCONECT_CLIENT, info_list.get(index));
		BroadCaster.broadCast(packet);
		
		info_list.remove(index);
	}
	
	public static int getClientSize() {
		return socket_list.size();
	}
	
	public static ClientSocket getClient(int index) {
		return socket_list.get(index);
	}
	
	public static ClientSocket getClient(ClientInfo ci) {
		return map.get(ci.getIp());
	}
}

















