package tje.chat.server.net;

import java.net.*;

import javax.swing.JOptionPane;

import tje.chat.common.Packet;
import tje.chat.common.jdbc.model.User;
import tje.chat.server.ServerFrame;

import java.io.*;

// 클라이언트들이 전송하는 메세지를 저장해놓기 위해 쓰레드가 필요
// 클라이언트의 소켓과 ip, nickname, 스트림을 저장하는 객체이다.
public class ClientSocket extends Thread {
	// 메인프레임의 참조변수
	private ServerFrame frame;
	// 클라이언트 소켓의 참조변수
	private Socket socket;
	// 클라이언트의 ip 주소
	private String ip;
	// 클라이언트 별칭
	private String ID;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private User inUser;
	
	// 이 프레임에서 socket과 ip를 초기화.
	public ClientSocket(ServerFrame frame, Socket client, User user) {
		this.frame = frame;
		this.socket = client;
		this.inUser = user;
		this.ip = this.socket.getInetAddress().getHostAddress();
		
		//this.frame.writeLog(ip + " 접속");
	}
	
	// 똑같은 ip가 두번 들어오면 스트림을 한번만 만들기위해 따로 빼놓음.
	// 그래서 클라이언트쪽과는 좀 다르게 스트림설정
	public void initStream(ObjectInputStream ois) {
		try {
			// 오브젝트 아웃풋 스트림 사용시 아웃풋스트림 생성하고 바로 플러시를 해줘야. 서버쪽도 마찬가지
			System.out.println("initstream 시작");
			out = new ObjectOutputStream(
					new BufferedOutputStream(this.socket.getOutputStream()));
			this.in = ois;
			out.flush();

			this.ID = this.inUser.getId();
			// 로그 기록
			this.frame.writeLog(ip + " / " + ID +  " 님 접속");
			// 현재 서버의 모든 클라이언트 목록을 전달
			out.writeObject(ClientSaver.getInfo_list());
			out.flush();
			
		} catch (Exception e) {
			this.socket = null;
			this.frame.writeLog(ip + " / " + ID +  " 님과 접속에 문제가 발생했습니다.");
			return;
		}
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public User getInUser() {
		return inUser;
	}

	public void setInUser(User inUser) {
		this.inUser = inUser;
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
	
	// 각 클라이언트들에게 메세지를 보내는 기능.
	public void send(Packet packet) {
		try {
			this.out.writeObject(packet);
			this.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		if(this.socket == null) {
			ClientSaver.delete(this);
			return;
		}
		while(true) {
			
			Packet packet = null;
			try {
				// 클라이언트의 종료는 입력받는 과정에서 알 수 있다.
				// 예외가 발생하거나(연결이 끊김), 널값이 입력될때
				packet = (Packet)this.in.readObject();
				
				if(packet == null)
					// 클라이언트의 연결 종료
					break;
				
				// 데이터 처리
				switch( packet.getPacketType() ) {
					case Packet.TYPE_CLIENT_MSG:
						BroadCaster.broadCast(packet, packet.getTargetIp());
						break;
				}
				
			} catch (Exception e) {
				// 여기서 예외가 발생한거는 클라이언트쪽에서 접속을 끊거나 뭐 그런문제.
				break;
				
			}
			
		}
		ClientSaver.delete(this);
		this.frame.writeLog(ip + " 연결 종료");
	}
}
