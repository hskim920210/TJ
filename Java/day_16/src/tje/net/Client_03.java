package tje.net;

import java.io.*;
import java.net.*;

public class Client_03 {
	public static void main(String[] args) throws Exception {	

		// 서버측과 데이터를 주고받을 수 있는 클라이언트 프로그램을 작성하세요.
		// 키보드로부터 입력된 문자열을 서버 측에 전달합니다.
		// 만약 전송할 데이터가 bye인 경우 또는 서버측에서 전달된 데이터가 bye인 경우
		// 프로그램을 종료합니다.
		// 입출력순서는
		// 클라이언트가 먼저 데이터를 전송한 후, 서버에서 메세지를 전송합니다.
		
		String ip = "192.168.0.68";
		int port = 5050;
		
		// 서버와의 연결
		// Socket 클래스의 객체를 생성하여 서버와 연결할 수 있음
		Socket client = new Socket(ip, port);		

		System.out.println("서버와 연결 완료");

		// 키보드 입력 스트림
		BufferedReader kb = 
				new BufferedReader(
						new InputStreamReader(System.in));
		// 입력 스트림
		BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(
								client.getInputStream()));		
		// 출력 스트림(auto flush 속성 지정)
		PrintWriter out = 
				new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(
										client.getOutputStream())), true);
		
		String input_kb;
		String input_server;
		do {
			System.out.print("서버에 전송할 메시지를 입력 : ");
			input_kb = kb.readLine();
			
			// 서버 측에 데이터를 전송
			out.println(input_kb);
			
			if( input_kb.equals("bye") )
				break;
			
			// 서버 측의 응답을 수신
			input_server = in.readLine();
			System.out.printf("서버 : %s\n", input_server);
		} while( !input_server.equals("bye") );		
		
		// 키보드 스트림을 종료
		kb.close();
		
		// Socket에 관련된 스트림을 종료
		in.close();
		out.close();
		client.close();
		
		System.out.println("프로그램 종료");
	}
}
