package tje.net;

import java.net.*;
import java.io.*;

public class Server_02 {

	public static void main(String[] args) throws Exception {

		int port = 5050;
		ServerSocket ss = new ServerSocket(port);

		System.out.println("서버 시작 ~!");
		System.out.println("클라이언트의 접속을 대기중 ~!");

		Socket client = ss.accept();
		System.out.println("클라이언트 접속 ~!");

		// 원격지의 디바이스와 연결된 소켓 객체는
		// 데이터를 입출력 할 수 있는 바이트 스트림을 제공한다.
		InputStream is = client.getInputStream();
		OutputStream os = client.getOutputStream();

		// 문자 타입의 데이터를 입출력하기 위한
		// 스트림 객체 생성

		// 입력 스트림
		BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(is));

		// 출력 스트림
		PrintWriter out = 
				new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(os)));

		// 클라이언트의 메세지 수신
		String msg = in.readLine();
		System.out.printf("클라이언트 : %s\n", msg);
		
		// 클라이언트에게 메세지 전송
		out.println("Hello Client~!");
		// 버퍼에 있는 내용으 ㄹ클라이언트 측에 전달.
		out.flush();
		
		// 클라이언트와 관련된 모든 스트림 종료
		in.close();
		out.close();
		client.close();

		// 서버 소켓 종료
		ss.close();
	}

}
