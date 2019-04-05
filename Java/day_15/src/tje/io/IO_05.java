package tje.io;

import java.io.IOException;
import java.io.InputStreamReader;

public class IO_05 {
	public static void main(String[] args) throws IOException {
		// 문자 스트림
		// 스트림으로부터 2바이트의 데이터를 읽어들여 문자로 변환하는 스트림.
		
		// 일반적으로 문자 스트림은 문자 스트림 클래스의 객체를 생성하여
		// 입력을 수행
		
		// 반면, 'System.in 과 같이 기존에 생성되어있는 바이트 스트림이
		// 존재하는 경우 해당 바이트 스트림의 객체를 사용하여 
		// 문자 스트림으로 변환할 수 있다.'
		
		// 바이트 스트림 객체를 문자 스트림으로 변환하는 방법
		// InputStreamReader 클래스를 사용
		// InputStreamReader 클래스는 '바이트 스트림의 객체를 생성자의
		// 매개변수로 전달받아 해당 바이트 스트림을 문자 스트림으로 변환'
		
		// 기본입력 바이트 스트림을 문자 스트림으로 변환하는 과정
		// 아래와 같은 경우, isr 변수를 사용하여 키보드로부터 문자 값을 읽을 수 있다.
		InputStreamReader isr = new InputStreamReader(System.in);
		
		System.out.print("문자를 입력하세요. : ");
		char ch = (char)isr.read();
		System.out.printf("입력된 문자는 %c 입니다.\n", ch);
		
		// 만약, 기존의 입력에서 처리하지 못한 엔터키 값이 존재하는 경우
		// 아래와 같이 해결할 수 있다.
		// skip 메소드는 스트림의 데이터 중, 매개변수에 해당되는 개수만큼
		// 삭제하는 기능을 제공한다.
		isr.skip(2);
		
		char [] msg = new char[20];
		System.out.print("메세지를 입력하세요. : ");
		int size = isr.read(msg);
		
		System.out.printf("입력된 글자 개수는 %d 입니다.\n", size);
		for( int i = 0 ; i < size ; i++ ) {
			System.out.printf("%c", msg[i]);
		}
		
		
		
	}
}
