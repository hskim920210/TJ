package tje.network;

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.0.70", 5555);
		
		System.out.println("서버 연결 성공~!");
		
		BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(System.in));
				
		
		// PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		PrintWriter out = new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(
								socket.getOutputStream())));
		
		System.out.println("채팅을 시작합니다.");

		while(true) {
			System.out.print("서버에 전송할 메세지를 입력 : ");
			String msg = in.readLine();
			
			if( msg.equals("bye") )
				break;
			
			out.println(msg);
			out.flush();
		}
		
		System.out.println("프로그램 종료");
	}

}
