package tje.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_06 {
	public static void main(String[] args) throws IOException {
		// 자바의 입출력 클래스들은 다른 스트림 객체를 생성자의 매개변수로
		// 전달받아 해당 스트림 객체에 기능을 추가할 수 있다.
		// 데코레이션 패턴 ( 기본 객체에 다른 클래스의 기능을 추가하여 사용하는 패턴 )
		
		// 키보드로부터 데이터를 읽어올 수 있는 InputStream 객체를
		// 문자를 읽을 수 있도록 변경한 후, 버퍼를 사용하여 데이터를
		// 읽어올 수 있도록 변환
		
		// 1. 바이트 스트림을 문자 스트림으로 변환
		InputStreamReader isr = new InputStreamReader(System.in);
		// 2. 일반 문자 스트림을 버퍼의 기능을 추가
		// 버퍼 : 프로그램의 입출력 성능을 향상시키기 위해 사용되는 메모리
		// 버퍼를 사용하여 READ/WRITE 성능을 향상시킬 수 있다.
		BufferedReader br = new BufferedReader(isr);
		
		System.out.printf("메세지를 입력하세요 : ");
		String msg = br.readLine();
		
		System.out.printf("입력된 메세지는 %s 입니다.", msg);
		
		// 스트림은 메모리 누수 현상을 방지하기 위해서
		// 반드시 close 메소드를 호출하여 종료를 해야함
		// 하나의 스트림에 여러개의 스트림 클래스가 적용되는 경우
		// 가장 마지막에 생성된(가장 바깥쪽의 객체) 객체만 close합니다.
		// (연쇄적으로 close가 되므로 가장 바깥쪽을 닫기만 하면 된다.)
		br.close();
		
	}
}
