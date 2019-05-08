package tje.chat.client.net;

import java.net.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.*;

import tje.chat.client.ClientFrame;
import tje.chat.common.ClientInfo;
import tje.chat.common.Packet;
import tje.chat.common.jdbc.model.User;
import tje.chat.model.*;


// ip와 포트번호, 별칭을 변수로 갖는 클래스이다. 
// 서버 인포 클래스는 직렬화(Serializable)을 해야하는데, 그 이유는 
// 모든 필드들을 네트워크로 전송할 수 있도록 바이트타입으로 변환하여 스트림을 이용할 수 있도록 하기 위함이다.
public class ClientSocket extends Thread {
	private ClientFrame frame;
	private ServerInfo serverInfo;
	private Socket socket;
	private User user;

	private ObjectOutputStream out;
	private ObjectInputStream in;

	public ClientSocket(ClientFrame frame, ServerInfo serverInfo) {
		this.frame = frame;
		this.serverInfo = serverInfo;
		this.user = serverInfo.getUser();
		try {
			// 클라이언트에선 오브젝트 아웃풋 스트림 사용시 아웃풋스트림부터 생성하고 바로 플러시를 해줘야. 서버쪽도 마찬가지
			// 이 소켓은 serverInfo에 있는 ip와 포트번호로 필드를 초기화한다.
			this.socket = new Socket(serverInfo.getIp(), serverInfo.getPort());
			System.out.println("ClientSocket의 소켓 생성 완료");
			out = new ObjectOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
			System.out.println("out 생성완료");
			out.writeObject(this.user);
			out.flush();
			System.out.println("user를 out에 전달완료 (ClientSocket 부분)");
			
			in = new ObjectInputStream(new BufferedInputStream(this.socket.getInputStream()));
			System.out.println("in 생성 완료");
			// 서버의 데이터베이스에 user 정보가 있는지 확인하기 위해 user를 가장 먼저 보내준다..

			JOptionPane.showMessageDialog(null, "서버와 연결되었습니다");
			
			// 서버의 인포타입을 받아온다.
			// 서버의 인포 타입은 접속한 클라이언트의 ip와 닉네임, 접속된 시간을 저장하는 객체이다.
			// 서버에서 받아오는 객체( 서버에서 소켓이 accept 되면 ip와 클라이언트에서 보낸 별칭, 시간을 전송받는다 )
			// 그것을 기준으로 클라이언트의 테이블에 그 속성들을 추가한다.
			ArrayList<ClientInfo> connected_list = (ArrayList<ClientInfo>)in.readObject();
			
			this.frame.setConnectedTable(connected_list);
			
		} catch (Exception e) {
			this.socket = null;
			JOptionPane.showMessageDialog(null, "서버와 연결 과정에서 문제가 발생했습니다.");
			return;
		}
	}
	
	// 전송은 쓰레드를 굴릴 필요가 없다. 받는거만 필요
	// 메세지와 파일 등은 클라이언트들에게 보내는거다.
	public void send(String targetIp, Object data, String sourceIp, String sourceID) {
		Packet packet = new Packet(Packet.TYPE_CLIENT_MSG, data, targetIp, sourceIp, sourceID);
		try {
			this.out.writeObject(packet);
			this.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		if( this.socket == null )
			return;
		
		while(true) {
			try {
				// 패킷의 유형에 따라 할 일을 결정.
				Packet packet = (Packet)in.readObject();
				
				switch(packet.getPacketType()) {
					case Packet.TYPE_NOTICE: 
						this.frame.addNoticeMessage((String)packet.getPacketData());
						break;
					case Packet.TYPE_NEW_CLIENT:
						this.frame.addConnectedTable((ClientInfo)packet.getPacketData());
						break;
					case Packet.TYPE_DISCONECT_CLIENT:
						this.frame.delConnectedTable((ClientInfo)packet.getPacketData());
						break;
					case Packet.TYPE_CLIENT_MSG:
						this.frame.receiveMessage(packet.getSourceIp(), packet.getSourceID(), (String)packet.getPacketData());
						break;
				}
				
				
			} catch (Exception e) {
				//e.printStackTrace();
				//JOptionPane.showMessageDialog(null, "서버데이터 수신중 문제가 발생했습니다.");
				break;
			}
		}
	}
	
	

	public void close() {
		try {
			this.socket.close();
			JOptionPane.showMessageDialog(null, "서버와 종료되었습니다");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "서버와 종료 과정에서 문제가 발생했습니다.");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
