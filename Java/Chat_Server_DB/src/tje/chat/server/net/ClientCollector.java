package tje.chat.server.net;

import java.io.IOException;
import java.net.*;
import javax.swing.*;

import tje.chat.server.ServerFrame;

public class ClientCollector extends Thread {
	// 메인 프레임의 참조변수
	private ServerFrame frame;
	// 서버 소켓 변수
	private ServerSocket server;
	
	public ClientCollector(ServerFrame frame, int port) {
		this.frame = frame;
		
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {	
			this.server = null;
			this.frame.noticeServerError();
			return;
		}
		
		this.frame.writeLog("서버 생성이 완료되었습니다.");
	}
	
	public void run() {
		if( this.server == null ) {
			this.frame.writeLog("서버 종료 - run 시작 부분");
			return;
		}
		
		while( true ) {
			Socket client = null;
			try {
				client = this.server.accept();
				ClientSocket cs = new ClientSocket(this.frame, client);
				
				if( ClientSaver.exits(cs) )
					cs.close();
				else {
					cs.initStream();
					
					// 로그인 결과 확인
					if( cs.getMember() == null )
						cs.close();
					else {
						ClientSaver.insert(cs);			
						cs.start();
					}
				}
			} catch (IOException e) {
				break;
			}
		}
		
		
		this.frame.writeLog("서버 종료 - run 종료 부분");
	}
	
	public void close() {
		try {
			this.server.close();
			this.frame.writeLog("서버 종료가 완료되었습니다.");
		} catch (IOException e) {
			this.frame.writeLog("서버 종료에서 문제가 발생하였습니다.");
		}
	}
}










