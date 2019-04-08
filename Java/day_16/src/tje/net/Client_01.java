package tje.net;

import java.io.IOException;
import java.net.*;

public class Client_01 {

	public static void main(String[] args) throws Exception {
		
		// Socket 클래스
		// 원격지의 디바이스로 접속할 수 있는 클래스
		// 원격지 디바이스의 IP 주소, PORT 번호를 사용하여 접속할 수 있다.
		String ip = "192.168.0.68"; // 네트워크 장비로 나갔다 다시 돌아오는 방식
		
		// 만약 현재 PC에서 서버와 클라이언트가 공존하는 경우
		// 127.0.0.1 또는 localhost 값을 사용하여 접속할 수 잇다. // 그냥 내컴퓨터 내부에서 다이렉트로 연결
		
		// 포트번호 설정
		// 포트번호 중 0 ~ 1023 까지는 시스템의 어플리케이션이 일반적으로 사용하는
		// 번호이므로 충돌을 피하기 위해서 다른 번호를 사용하는 것이 좋다.
		int port = 5050;
		
		// 서버와의 연결
		// Socket 클래스의 객체를 생성하여 서버와 연결할 수 있다.
		Socket client = new Socket(ip, port);
		
		// 소케 객체의 생성 시 예외가 발생하는 경우
		// 1. 서버 소켓이 대기하고 있지 않은 경우
		// 2. 주소 및 포트번호가 잘못된 경우
		
		// 통신이 연결된 지점
		// 소켓이 예외없이 생성된 경우 통신이 연결되었음을 의미
		System.out.println("서버와 접속 완료");

	}

}
