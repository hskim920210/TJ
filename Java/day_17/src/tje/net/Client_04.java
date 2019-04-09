package tje.net;

import java.net.*;
import java.io.*;

public class Client_04 {
	public static void main(String[] args) {
		String host = "192.168.0.82";
		int port = 7070;
		
		// 서버에 연결
		Socket socket = null;
		
		try {
			socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			return;
		} catch (IOException e) {
			System.out.println("서버와 연결에 실패했습니다.");
			return;
		}
		
		// 서버와 연결 성공 지점
		System.out.println("서버와 연결되었습니다.");
		
		// 키보드 스트림
		BufferedReader kb = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		// 데이터 송수신을 위한 스트림 생성
		// 주의사항
		// 반드시 입출력 스트림의 생성순서는
		// 서버와 반대로 해야한다.
		// 예를 들어 서버에서 입력스트림을 먼저 생성하는 경우
		//		   클라이언트에서는 출력스트림을 먼저 생성한다.
		// 서버와 클라이언트 모두 입력  스트림을 먼저 생성하는 경우
		// 무한 블럭킹 현상에 빠진다. (객체 입출력인 경우 발생)
		BufferedReader socket_in = null;
		PrintWriter socket_out = null;
		
		try {
			socket_out =new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(socket.getOutputStream())), true);
			
			socket_in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
		} catch (IOException e) {
			System.out.println("서버와의 스트림 생성 실패");
			try {
				socket.close();
			} catch (IOException e1) {
				System.out.println("소켓 종료에서 예외가 발생하였습니다.");
			}
			return;
		}

		// 서버와 데이터를 주고받기 위한 준비가 완료
		
		// 서버와 데이터를 주고받는 과정에서의 주의사항
		// 입출력시 블럭킹 현상이 발생
		// 일반적으로 입력(서버에서 보내는 데이터를 받는 동작)은
		// 쓰레드로 처리
		new SimpleReceiverThread("서버", socket_in).start();
		
		String msg;
		do {
			System.out.print("서버에 전송할 메세지를 입력 : ");
			try {
				msg = kb.readLine();
			} catch (IOException e) {
				System.out.println("키보드 입력에서 예외가 발생");
				break;
			}
			
			socket_out.println(msg);
			// socket_out.flush();
			
		} while( !msg.equals("bye") );
		
		try {
			kb.close();
		} catch (IOException e1) {
			System.out.println("키보드 스트림 종료 과정에서 예외가 발생했습니다.");
		}
		socket_out.close();
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("소켓 종료과정에서 예외가 발생했습니다.");
		}
		
	}
}
