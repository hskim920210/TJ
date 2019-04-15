package Chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public ClientSocket(Socket socket) {
		this.socket = socket;
		// 생성자로 전달된 Socket 객체를 사용하여 스트림 생성
		try {
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("스트림 객체 생성에서 예외가 발생");
		}
	}

	public void send(String msg) {
		this.out.println(msg);
	}
}
