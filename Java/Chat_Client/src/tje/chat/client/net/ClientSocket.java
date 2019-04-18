package tje.chat.client.net;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

import tje.chat.client.ClientFrame;
import tje.chat.model.*;

public class ClientSocket extends Thread {
	private ClientFrame frame;
	private ServerInfo serverInfo;
	private Socket socket;

	private ObjectOutputStream out;
	private ObjectInputStream in;

	public ClientSocket(ClientFrame frame, ServerInfo serverInfo) {
		this.frame = frame;
		this.serverInfo = serverInfo;
		try {
			// 클라이언트에선 오브젝트 아웃풋 스트림 사용시 아웃풋스트림부터 생성하고 바로 플러시를 해줘야. 서버쪽도 마찬가지
			this.socket = new Socket(serverInfo.getIp(), serverInfo.getPort());
			out = new ObjectOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
			out.flush();
			in = new ObjectInputStream(new BufferedInputStream(this.socket.getInputStream()));

			// 문자열로된 별칭을 출력. 서버가 연결된후 가장 먼저 해줄 작업.
			out.writeObject(this.serverInfo.getNickName());
			out.flush();

			JOptionPane.showMessageDialog(null, "서버와 연결되었습니다");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "서버와 연결 과정에서 문제가 발생했습니다.");
			return;
		}
	}

	public void run() {

	}

	public void close() {
		try {
			this.socket.close();
			JOptionPane.showMessageDialog(null, "서버와 종료되었습니다");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "서버와 종료 과정에서 문제가 발생했습니다.");
		}
	}

}
