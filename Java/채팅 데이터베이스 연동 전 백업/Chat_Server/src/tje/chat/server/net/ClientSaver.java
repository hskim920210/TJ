package tje.chat.server.net;

import java.util.*;
import tje.chat.common.*;

// 접속한 클라이언트들을 저장하는 클래스

public class ClientSaver {
	// 소켓들을 관리한느 배열
	private static ArrayList<ClientSocket> socket_list = new ArrayList<ClientSocket>();
	// 각 ip 번호랑 소켓으로 키와 밸류값을 설정
	private static HashMap<String, ClientSocket> map = new HashMap<String, ClientSocket>();
	// 클라이언트 인포 객체를 어레이리스트로
	private static ArrayList<ClientInfo> info_list = new ArrayList<ClientInfo>();

	// 클라이언트 소켓의 인잇스트림에서 닉네임을 저장한뒤에 인포객체를 불러오기위해 만든 겟터
	// 이걸 불러와서 out.writeObj를 사용한다.
	public static ArrayList<ClientInfo> getInfo_list() {
		return info_list;
	}

	public static boolean exists(ClientSocket cs) {
		return map.containsKey(cs.getIp());
	}

	public static boolean exists(String targetIp) {
		return map.containsKey(targetIp);
	}
	
	public static ClientSocket getClient(String targetIp) {
		return map.get(targetIp);
	}
	
	// 얘는 하나만 부르니까 싱크로나이즈 필요없다
	// 받아온 ClientSocket 객체를 각 배열에 추가한뒤 
	// ClientInfo 객체로 만들어 Packet으로 전달(BroadCast)하고
	// info_list에 추가
	public static void insert(ClientSocket cs) {
		socket_list.add(cs);
		map.put(cs.getIp(), cs);

		// 클라이언트소켓 객체가 들어온 순간 정보를 저장
		Date now = Calendar.getInstance().getTime();
		ClientInfo info = new ClientInfo(cs.getIp(), cs.getNickName(), now);
		
		// 객체를 패킷으로 만들어 클라이언트들에게 broadcast 한다.
		Packet packet = new Packet(Packet.TYPE_NEW_CLIENT, info);
		// 자기 자신은 보낼필요없으니 순서가 이렇게 된다.
		info_list.add(info);
		
		BroadCaster.broadCast(packet);
		
	}

	
	// 얘는 동시에 여럿이 부르니 싱크로나이즈가 필요
	public static synchronized void delete(ClientSocket cs) {
		socket_list.remove(cs);
		map.remove(cs.getIp());
		
		// 지울 인덱스를 설정
		// 아이피와 닉네임이 맞는 인덱스를 가져온다.
		int index = info_list.indexOf(new ClientInfo(cs.getIp(), cs.getNickName(), null));
		
		// 객체를 패킷으로 만들어 클라이언트들에게 broadcast 한다.
		Packet packet = new Packet(Packet.TYPE_DISCONECT_CLIENT, info_list.get(index));
		BroadCaster.broadCast(packet);
		
		// remove 자체에서 아래 형식과 같은 것을 equals로 찾아내어 지운다.
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
