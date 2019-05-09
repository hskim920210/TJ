package tje.chat.server.net.regist;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.sql.*;

import tje.chat.server.ServerFrame;

import tje.jdbc.util.*;
import tje.jdbc.model.*;
import tje.jdbc.dao.*;


public class RegistClientCollector extends Thread {
	public static final int REGIST_PORT = 7777;
	// 메인 프레임의 참조변수
	private ServerFrame frame;
	// 서버 소켓 변수
	private ServerSocket server;
	
	public RegistClientCollector(ServerFrame frame) {
		this.frame = frame;
		
		try {
			this.server = new ServerSocket(REGIST_PORT);
		} catch (IOException e) {	
			this.server = null;
			this.frame.noticeServerError();
			return;
		}
		
		this.frame.writeLog("회원가입을 위한 서버 생성이 완료되었습니다.");
	}
	
	public void run() {
		if( this.server == null ) {
			this.frame.writeLog("회원가입 서버 종료 - run 시작 부분");
			return;
		}
		
		while( true ) {
			Socket client = null;
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			Connection conn = null;
			try {
				client = this.server.accept();
				
				out = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
				out.flush();
				
				in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

				Member member = (Member)in.readObject();
				
				conn = JDBCConnection.getConnection();
				
				MemberDAO dao = MemberDAO.getInstance();
				
				Member result = dao.select(conn, member);				
				
				String strAck = "";
				if( result == null ) {
					
					if( dao.insert(conn, member) == 1 )
						strAck = String.format("%s 계정의 회원가입이 완료되었습니다.", member.getId());
					else 
						strAck = "회원가입에 실패했습니다.(입력정보를 확인)";
						
				} else
					strAck = "회원가입에 실패했습니다.(아이디가 중복)";
				
				out.writeObject(strAck);
				out.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
				//break;
			} finally {
				
				try {
					in.close();
					out.close();
					client.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}				
				
				JDBCObjectManager.close(conn);
			}
		}
		
		
		//this.frame.writeLog("서버 종료 - run 종료 부분");
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










