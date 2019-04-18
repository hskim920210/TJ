package tje.chat.server.net;

import java.net.*;

import javax.swing.JOptionPane;

import tje.chat.server.ServerFrame;

import java.io.*;

public class ClientSocket {
	// 메인프레임의 참조변수
	private ServerFrame frame;
	// 클라이언트 소켓의 참조변수
	private Socket socket;
	// 클라이언트의 ip 주소
	private String ip;
	// 클라이언트 별칭
	private String nickName;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public ClientSocket(ServerFrame frame, Socket client) {
		this.frame = frame;
		this.socket = client;
		this.ip = this.socket.getInetAddress().getHostAddress();
		
		//this.frame.writeLog(ip + " 접속");
	}
	
	// 똑같은 ip가 두번 들어오면 스트림을 한번만 만들기위해 따로 빼놓음.
	// 그래서 클라이언트쪽과는 좀 다르게 스트림설정
	public void initStream() {
		try {
			// 오브젝트 아웃풋 스트림 사용시 아웃풋스트림 생성하고 바로 플러시를 해줘야. 서버쪽도 마찬가지
			out = new ObjectOutputStream(
					new BufferedOutputStream(this.socket.getOutputStream()));
			out.flush();
			in = new ObjectInputStream(
					new BufferedInputStream(this.socket.getInputStream()));
			
			nickName = (String)in.readObject();
			
			this.frame.writeLog(ip + " / " + nickName +  " 님 접속");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "서버와 연결 과정에서 문제가 발생했습니다.");
			return;
		}
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public void close() {
		try {
			this.socket.close();
			this.frame.writeLog(ip + " 연결 종료");
		} catch (IOException e) {
			this.frame.writeLog(ip + " 연결 종료 과정에서 문제가 발생하였습니다.");
		}
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if( !(obj instanceof ClientSocket) )
			return false;
		
		ClientSocket target = (ClientSocket) obj;
		boolean flag = this.ip.equals(target.ip);
		
		return flag;
	}
	
}
