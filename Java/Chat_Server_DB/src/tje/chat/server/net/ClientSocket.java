package tje.chat.server.net;

import java.net.*;
import java.sql.Connection;

import javax.swing.JOptionPane;

import tje.chat.common.Packet;
import tje.chat.server.ServerFrame;
import tje.jdbc.dao.MemberDAO;
import tje.jdbc.dao.NoticeDAO;
import tje.jdbc.model.Member;
import tje.jdbc.util.JDBCConnection;
import tje.jdbc.util.JDBCObjectManager;

import java.io.*;

public class ClientSocket extends Thread {
	// 메인 프레임의 참조변수
	private ServerFrame frame;
	// 클라이언트 소켓의 참조변수
	private Socket socket;
	// 클라이언트 ip 주소
	private String ip;
	// 클라이언트 정보
	private Member member;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public ClientSocket(ServerFrame frame, Socket client) {
		this.frame = frame;
		this.socket = client;
		this.ip = this.socket.getInetAddress().getHostAddress();
	}
	
	public void initStream() {
		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(this.socket.getOutputStream()));
			out.flush();
			
			in = new ObjectInputStream(
					new BufferedInputStream(this.socket.getInputStream()));	
					
			// 클라이언트와의 스트림이 생성된 후
			// 로그인 정보를 전달받음
			member = (Member)in.readObject();
			
			if( member.getId() == null || member.getPassword() == null ) {
				this.member = null;				
				return;
			}
			
			Connection conn = JDBCConnection.getConnection();
			MemberDAO dao = MemberDAO.getInstance();
			this.member = dao.login(conn, member);
			
			
			
			if( this.member == null ) {
				return;
			}
			
			// 로그 기록 작성
			this.frame.writeLog(ip + " / " + member.getNick() + " 님 접속");
			// 로그인된 사용자의 정보를 전달
			out.writeObject(this.member);
			out.flush();
			// 현재 서버의 모든 클라이언트의 목록을 전달			
			out.writeObject(ClientSaver.getInfo_list());
			out.flush();
			
			// 공지사항 메세지를 최근의 10개 전달
			NoticeDAO noticeDao = NoticeDAO.getInstance();
			out.writeObject(noticeDao.select(conn));
			out.flush();
			
			JDBCObjectManager.close(conn);			
			
		} catch (Exception e) {
			this.socket = null;
			this.frame.writeLog(ip + " 와 접속 과정에서 문제가 발생하였습니다.");			
		}
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public Member getMember() {
		return this.member;
	}
	
	public void close() {
		try {
			this.socket.close();
			this.frame.writeLog(ip + " 연결 종료");
		} catch (IOException e) {
			this.frame.writeLog(ip + " 연결 종료과정에서 문제가 발생하였습니다.");
		}
	}

	public boolean equals(Object obj) {
		if( !(obj instanceof ClientSocket) )
			return false;
		
		ClientSocket target = (ClientSocket)obj;
		boolean flag = this.ip.equals(target.ip);
		
		return flag;
	}
	
	public void send(Packet packet) {
		try {
			this.out.writeObject(packet);
			this.out.flush();
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	}
	
	public void run() {
		if( this.socket == null ) {
			ClientSaver.delete(this);
			return;
		}
		
		while(true) {
			
			Packet packet = null;
			
			try {
				packet = (Packet)this.in.readObject();
				
				if( packet == null )
					// 클라이언트의 연결 종료
					break;
				
				// 데이터 처리
				switch( packet.getPacketType() ) {
					case Packet.TYPE_CLIENT_MSG :
						BroadCaster.broadCast(packet, packet.getTargetIp());
						break;
				}
				
			} catch (Exception e) {
				// 클라이언트의 연결 종료
				break;
			}			
		}
		
		ClientSaver.delete(this);
		this.frame.writeLog(ip + " 연결 종료");
	}
}











