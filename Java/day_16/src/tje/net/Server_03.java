package tje.net;

import java.io.*;
import java.net.*;

public class Server_03 {
	public static void main(String[] args) throws Exception {
		
		// 서버측과 데이터를 주고받을 수 있는 클라이언트 프로그램을 작성하세요.
		// 키보드로부터 입력된 문자열을 서버 측에 전달합니다.
		// 만약 전송할 데이터가 bye인 경우 또는 서버측에서 전달된 데이터가 bye인 경우
		// 프로그램을 종료합니다.
		// 입출력순서는
		// 클라이언트가 먼저 데이터를 전송한 후, 서버에서 메세지를 전송합니다.
				
		int port = 5050;		
		ServerSocket ss = new ServerSocket(port);
		
		System.out.println("서버 시작~!");
		System.out.println("클라이언트의 접속을 대기 중~!");
		
		Socket client = ss.accept();		
		System.out.println("클라이언트 접속~!");	

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
		String input_client;
		do {
			// 클라이언트 측의 메세지를 수신
			input_client = in.readLine();
			System.out.printf("클라이언트 : %s\n", input_client);
			
			if( input_client.equals("bye") )
				break;
			
			System.out.print("클라이언트에 전송할 메시지를 입력 : ");
			input_kb = kb.readLine();
			
			// 크라이언트 측에 데이터를 전송
			out.println(input_kb);
		} while( !input_kb.equals("bye") );
		
		// 키보드 스트림을 종료
		kb.close();
		
		// 클라이언트와 관련된 모든 스트림을 종료
		in.close();
		out.close();
		client.close();
		
		// 서버 소켓 종료		
		ss.close();
		
		System.out.println("프로그램 종료");
	}
}
