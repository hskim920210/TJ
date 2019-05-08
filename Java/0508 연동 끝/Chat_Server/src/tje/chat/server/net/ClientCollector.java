package tje.chat.server.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.sql.Connection;

import javax.swing.*;

import tje.chat.common.jdbc.UserDAO;
import tje.chat.common.jdbc.model.User;
import tje.chat.common.util.JDBCConnection;
import tje.chat.server.ServerFrame;

// 시작버튼을 눌렀을 때 포트번호를 받아와 생성되는 객체.
// 서버소켓을 필드로 가지고있다.
public class ClientCollector extends Thread {
	// 메인 프레임의 참조변수
	private ServerFrame frame;
	// 서버 소켓 변수
	private ServerSocket server;
	private ObjectInputStream ois;
	private User user;
	private UserDAO dao = UserDAO.getInstance();

	public ClientCollector(ServerFrame frame, int port) {
		this.frame = frame;
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {
			this.server = null;
			this.frame.noticeServerError();
			return;
		}

		this.frame.writeLog("서버 생성이 완료되었습니다");
	}
	
	public void run() {
		if( this.server == null ) {
			this.frame.writeLog("서버 종료 - run 시작부분");
		}
		
		while(true) {
			Socket client = null;
			try {
				client = this.server.accept();
				System.out.println("클라이언트의 socket 생성 완료 (ClientCollector  run 부분");
				
				ois = new ObjectInputStream(
						new BufferedInputStream(
								client.getInputStream()));
				System.out.println("ois 생성 완료  (ClientCollector  run 부분)");
				try {
					user = (User) ois.readObject();
					System.out.println("user ois readObject 완료");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				
				Connection conn = JDBCConnection.getConnection();
				boolean correctInfo ;
				correctInfo = dao.login(conn, user);
				System.out.println("dao.login = " + correctInfo);
				
				if( correctInfo ) {
					// 로그인 허가
					ClientSocket cs = new ClientSocket(this.frame, client, user);
					System.out.println("cs 생성");
					
					if( ClientSaver.exists(cs) ) {
						cs.close();
					}
					else {
						// 먼저 스트림부터 만들고 어레이리스트로 전달해야 좋다.
						// 왜냐하면 클라이언트 세이버에 객체가 들어오는순간 공지를 띄우는 상황에서
						// 제대로 전달이 안될수도 있다.(스트림이 없는객체로 들어오는게 먼저이므로)
						cs.initStream(ois);
						ClientSaver.insert(cs);
						cs.start();
					}
				} else {
					// 로그인 거절
				}
				
				
				
			} catch (IOException e) {
				break;
			}
		}
		
		
		this.frame.writeLog("서버 종료 - run 종료부분");
	}
	
	public void close() {
		try {
			this.server.close();
			this.frame.writeLog("서버 종료가 완료되었습니다");
		} catch (IOException e) {
			this.frame.writeLog("서버 종료에서 문제가 발생하였습니다");
		}
	}

}
