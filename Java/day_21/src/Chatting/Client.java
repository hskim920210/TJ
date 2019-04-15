package Chatting;

import javax.swing.*;

import java.io.IOException;
import java.net.*;

public class Client {
	String ip, nick, host;
	int port;
	Socket socket;

	Client(String ip, int port, String nick) {
		this.ip = ip;
		this.port = port;
		this.nick = nick;
		this.host = this.socket.getInetAddress().getHostAddress();

		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "서버를 찾을 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "서버와 연결에 실패했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

	}

}
