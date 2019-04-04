package tje.io;

import java.io.IOException;

public class IO_04_Ex_1 {
	public static void main(String[] args) throws IOException {
		// 키보드 입력스트림으로부터 모든 데이터를
		// 읽어올 때까지 반복을 수행하는 코드
		byte[] input = new byte[20];
		int size;
		
		do {
			System.out.printf("키보드 입력을 실행하세요 : ");
			size = System.in.read(input);
			for( int i = 0 ; i < input.length ; i++ )
				System.out.printf("%d ", input[i]);
			System.out.println();
			
			// 키보드 입력을 처리하느 ㄴ경우 종료문자를 전달받아야만
			// -1 값을 전달받을 수 있다. (시스템에 따라 다르며 일반적으로 Ctrl + z)
		} while( size != -1 );
		
		System.out.println("프로그램 종료");
	}
}
