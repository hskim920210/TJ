package tje.net.server;

import java.io.*;

// 각각의 클라이언트가 전송하는 메세지를 
// 수신할 수 있는 쓰레드 클래스
public class ClientMessageReceiver extends Thread {
	private Client client;
	private String host;
	private BufferedReader in;
	
	public ClientMessageReceiver(Client client, String host, BufferedReader in) {
		this.client = client;
		this.host = host;
		this.in = in;
	}
	
	public void run() {
		String msg;
		while( true ) {
			try {
				msg = in.readLine();
				
				if( msg.equals("bye") )
					break;
				
				BroadCaster.broadCast(host, msg);
				
			} catch (IOException e) {
				break;
			}
		}
		
		ClientSaver.delClient(this.client);
		System.out.printf("%s 클라이언트의 접속이 종료됨\n", this.host);
	}
}










