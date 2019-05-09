package tje.chat.model;

import java.text.SimpleDateFormat;
import java.util.*;

public class ChatMessage {
	private String myNickName;
	private String ip;
	private String nickName;
	private ArrayList<String> history;	
	
	public ChatMessage(String myNickName, String ip, String nickName) {
		this.myNickName = myNickName;
		this.ip = ip;
		this.nickName = nickName;
		this.history = new ArrayList<String>();
		
		this.addHistory(String.format("%s 님과 채팅을 시작합니다.\n", this.nickName));		
	}
	
	public String addHistory(String msg) {
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss -> ");		
		
		String output = String.format("(%s) %s%s\n", myNickName, sdf.format(now), msg);
		this.history.add(output);
		return output;
		
	}
	
	public ArrayList<String> getHistory() {
		return this.history;		
	}
}












