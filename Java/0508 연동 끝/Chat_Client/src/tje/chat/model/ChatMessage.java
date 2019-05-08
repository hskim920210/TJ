package tje.chat.model;

import java.text.SimpleDateFormat;
import java.util.*;

// 선택한 사용자에게 메세지를 보내는 기능.
// 이 때 ip는 받을 사람의 ip, 닉네임도 받을 사람의 nickname이다.
public class ChatMessage {
	private String myID;
	private String ip;
	private String ID;
	private ArrayList<String> history;
	
	public ChatMessage(String myID, String ip, String ID) {
		super();
		this.myID = myID;
		this.ip = ip;
		this.ID = ID;
		this.history = new ArrayList<String>();
		this.addHistory(String.format("%s 님과 채팅을 시작합니다.\n", this.ID));
	}
	
	public String addHistory(String msg) {
//		Date now = Calendar.getInstance().getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss  : ");
//		String output = String.format("(%s) %s%s\n", myNickName, sdf.format(now), msg);
//		this.history.add(output);
//		return output;
		
		// 위는 날짜가 모두 출력되고 아래는 날짜가 출력되지 않게 수정
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd  HH:mm  -> ");
		String output = String.format("(%s) %s%s\n", myID, sdf.format(now), msg);
		this.history.add(output);
		return output;
	}
	
	public ArrayList<String> getHistory() {
		return this.history;
	}
	

}
