package tje.io;

import java.io.IOException;

public class IO_03 {
	public static void main(String[] args) throws IOException {
		// InputStream 클래스의 read 메소드
		// read() : 입력 스트림으로부터 가장 앞에 위치한 1 바이트를 읽어옴
		// read(byte []) : 입력 스트림의 가장 앞부터 매개변수로 전달된
		// 배열의 크기만큼의 바이트를 읽어옴
		// read(byte [], int startIndex, int size) : 입력 스트림의
		// 가장 앞부터 size 크기만큼 데이터를 읽어옴. 저장은 매개변수로 전달된
		// 배열의 startIndex 위치부터 저장
		byte[] input = new byte[20];

		System.out.printf("키보드 입력을 실행하세요 : ");
		// 키보드의 입력 스트림으로부터 20 byte를 읽어들이는 코드
		// read 메소드의 실행이 종료된 후, 실제로 읽어들인 byte 수를 반환
		int size = System.in.read(input);

		System.out.printf("스트림으로부터 읽어온 바이트의 크기 : %d 바이트\n", size);

		for (int i = 0; i < size; i++)
			System.out.printf("%c", input[i]);

		System.out.println("프로그램 종료");
	}
}
