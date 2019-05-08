package tje.chat.server.net;


import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.util.*;

import javax.swing.JOptionPane;

import tje.chat.common.util.*;
import tje.chat.common.ClientInfo;
import tje.chat.common.jdbc.UserDAO;
import tje.chat.common.jdbc.model.User;

public class SignInThread extends Thread {
	public static final int PORT = 50150;
	private ServerSocket ss;
	UserDAO dao = UserDAO.getInstance();
	
	Socket signSocket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	User user;

	String id;
	String pw;
	
	public SignInThread() {
		try {
			this.ss = new ServerSocket(PORT);
		} catch (IOException e) {
			this.ss = null;
		}
	}
	
	public void run() {
		if (this.ss == null) {
			return;
		}
		
		// 무한 루프를 돌며 가입정보를 기다린다.
		while(true) {
			System.out.println("회원가입 스레드 첫부분  (SignInThread run 부분)");
			try {
				signSocket = this.ss.accept();
				ois = 
					new ObjectInputStream(
							new BufferedInputStream(
									signSocket.getInputStream()));
				try {
					user = (User)ois.readObject();
					id = user.getId();
					pw = user.getPw();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					user = null;
					id = null;
					pw = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
				user = null;
				id = null;
				pw = null;
			}
			
			System.out.println("회원가입 스레드 ois 스트림 생성 직전");
			
			Connection conn = JDBCConnection.getConnection();
			// 가져온 유저 객체를 토대로 database에 아이디를 확인하고 경고메세지를 돌려주거나 저장을 한다.
			// 스트림을 먼저 만들고
			try {
				oos = 
						new ObjectOutputStream(
								new BufferedOutputStream(
										signSocket.getOutputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			// 1. 이미 저장된 ID인지 체크한 결과를 불린타입으로 반환
			boolean idExist = dao.isIdExist(conn, id);
			// 존재한다면 경고 메세지만 넘겨주고, 존재하지 않는다면 테이블에 추가한뒤 완료메세지를 넘겨준다.
			if( idExist ) {
					String idExistMessage = "회원가입 결과 : 실패 ( 중복된 ID )";
					try {
						oos.writeObject(idExistMessage);
						oos.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
			} else if ( !idExist ) {
				dao.insert(conn, user);
				String completeSign = "회원가입 결과 : 성공 !";
				try {
					oos.writeObject(completeSign);
					oos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			try {
				oos.close();
				signSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close() {
		try {
			this.ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
