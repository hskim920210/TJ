package tje.net.server;

import java.io.IOException;
import java.net.*;

// ServerSocket을 생성한 후 
// 클라이언트의 접속을 감지하는 쓰레드 클래스
public class ClientCollector extends Thread {
	private ServerSocket server;
	
	public ClientCollector(int port) {
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {			
			System.out.println("다른 프로세스에서 동일한 PORT 번호를 사용 중 입니다.");
		}
	}
	
	public void run() {
		while(true) {
			Socket socket;
			try {
				socket = this.server.accept();
				Client client = new Client(socket);
				if( !ClientSaver.checkClient(client) ) {
					ClientSaver.addClient(client);
					client.activate();
				} else {
					client.close();
				}
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}









