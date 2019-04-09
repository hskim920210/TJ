package tje.net;

import java.net.*;
import java.io.*;
import java.util.*;

class NoticeServer extends Thread {
	private ArrayList<ClientSocket> clients;
	public NoticeServer(ArrayList<ClientSocket> clients) {
		this.clients = clients;
	}
	
	public void run() {
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		String msg;
		while(true) {
			System.out.print("공지 메세지를 입력 : ");
			try {
				msg = kb.readLine();
				
				if( this.clients.size() > 0 ) {
					for( int i = 0 ; i < clients.size() ; i++ )
						this.clients.get(i).send(msg);
				}
				
				if( msg.equals("bye") )
					break;
			} catch (IOException e) {
				System.out.println();
			}
		}
	}
}

class ClientSocket {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public ClientSocket(Socket socket) {
		this.socket = socket;
		// 생성자로 전달된 Socket 객체를 사용하여 스트림 생성
		try {
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("스트림 객체 생성에서 예외가 발생");
		}
	}
	
	public void send(String msg) {
		this.out.println(msg);
	}
}

public class Server_06 {
	public static void main(String[] args) {
		// 다중 클라이언트의 접속을 처리할 수 있는 서버 프로그램
		
		// 1. 다수개의 클라이언트(Socket)을 저장할 수 있는 변수
		// - 컬렉션 타입의 변수
		ArrayList<ClientSocket> clients = new ArrayList<ClientSocket>();
		
		// 모든 클라이언트에게 공지사항을 전달할 수 있는 쓰레드를 실행
		new NoticeServer(clients).start();
		
		
		int port = 7070;
		ServerSocket server = null;

		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			System.out.printf("다른 프로세스에서 포트번호(%d)를 사용하고 있습니다.\n", port);
			return;
		}

		// 2. 다중 클라이언트를 처리하기 위해서 accept 메소드의 반복처리
		while(true) {
		System.out.println("클라이언트의 접속을 대기중...");
		Socket socket = null;
		try {
			
			socket = server.accept();
			clients.add(new ClientSocket(socket));
			System.out.println("클라이언트가 접속됨");
			
		} catch (IOException e) {
			System.out.println("accept 메소드에서 예외가 발생");
				try {
				server.close();
				} catch (IOException e1) {
				System.out.println("서버의 종료 과정에서 예외가 발생");
				}
			return;
			}
		}

	}
}
