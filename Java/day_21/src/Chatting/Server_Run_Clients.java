package Chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Server_Run_Clients extends Thread {
	ServerSocket server;
	Socket socket;
	String ip;
	int port;

	public Server_Run_Clients(String ip, int port) {
		this.ip = ip;
		this.port = port;
		try {
			// 서버소켓 생성
			this.server = new ServerSocket(port);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "다른 프로세스에서 동일한 PORT 번호를 사용 중입니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			// 허가된 소켓들을 어레이리스트에 추가하는 반복작업
			socket = server.accept();
			ClientList.addClient(new ClientSocket(socket));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		while (true) {

		}
	}

}
