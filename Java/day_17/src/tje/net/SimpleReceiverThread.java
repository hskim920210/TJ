package tje.net;

import java.net.*;
import java.io.*;

class SimpleReceiverThread extends Thread{
	private String title;
	private BufferedReader in;
	public SimpleReceiverThread(String title, BufferedReader in) {
		this.in = in;
		this.title = title;
	}
	public void run() {
		// 네트워크에서 전송되는 데이터를 수신하는 역할.
		String msg;
		while(true) {
			// 연결이 종료되는 경우 예외가 발생
			// 연결 종료를 대비하는 예외처리 코드가 필요함
			try {
				msg = in.readLine();
				System.out.printf("%s : %s\n", title, msg);
				
				if( msg.equals("bye") )
					break;
			} catch (IOException e) {
				break;
			}
		}
		
		System.out.printf("%s와의 연결 종료\n", title);
		
		try {
			this.in.close();
		} catch (IOException e) {
			System.out.println("입력 스트림 종료과정에서 예외가 발생했습니다.");
		}
	}
}