package tje.net;

import java.net.*;

public class Server_01 {

	public static void main(String[] args) throws Exception {
		// ServerSocket 클래스
		// 클라이언트의 접속을 받아들일 수 있는 클래스
		// 특정 port 번호를 감시하는 역할을 함
		// accept 메소드를 사용하여 클라이언트의 접속을 감지할 수 있으며
		// 새로운 클라이언트가 접속되면 해당 클라이언트와 데이터를 주고받을 수 있는
		// Socket 객체를 생성하여 반환함
		
		int port = 5050;
		// 5050번의 port 번호를 감시할 수 있는 ServerSocket 객체 생성.
		ServerSocket ss = new ServerSocket(port);
		
		System.out.println("서버 시작 ~!");
		System.out.println("클라이언트의 접속을 대기중 ~!");
		// accept 메소드는 생성자에서 설정한 port 번호를 통해 접속하는
		// 클라이언트가 발생할 때 까지 대기하는 메소드
		// 클라이언트가 접속하면 해당 클라이언트와 데이터를 주고받기 위한
		// Socket 객체를 반환한다.
		Socket client = ss.accept();
		
		System.out.println("클라이언트 접속 ~!");
		
		client.close();
		ss.close();
		

	}

}
