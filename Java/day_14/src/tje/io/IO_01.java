package tje.io;

import java.io.IOException;

// 입출력
// 자바에서 입출력은 스트림의 개념을 사용합니다.
// 스트림 : 단방향 통신
// 입력과 출력에 관한 스트림이 각각 클래스로 제공됩니다.
// 모든 입출력 클래스는 java.io 패키지에 정의되어 있습니다.

// 입출력 클래스
// 1. 바이트 타입
// - 이진데이터(눈으로 읽을 수 없는 데이터)
// - 이미지, 실행파일, 엑셀파일, 워드파일, 한글파일 등등
// - InputStream(입력의 최상위 부모클래스), 
// - OutputStream(출력의 최상위 부모클래스)

// 2. 문자 타입
// - 텍스트 데이터
// - txt 파일과 같은 내용을 처리할 수 있는 클래스
// - Reader(입력의 최상위 부모클래스)
// - Writer(출력의 최상위 부모클래스)

public class IO_01 {
	public static void main(String[] args) {
		// 기본 입력 - 키보드
		// System.in 객체를 사용하여 키보드의 입력을 처리할 수 있다.
		
		// 자바의 모든 입출력 작업은 명시적으로 예외 처리를 선언해야 한다.
		// (IOException 타입의 예외가 발생됨)
		// int input = System.in.read();
		try {
			// 바이트 입출력 클래스들은 스트림으로부터 
			// 1바이트씩 읽거나 쓸 수 있는 클래스
			// 기본입력을 제공하는 System.in 객체는
			// 키보드와 연결된 기본입력 스트림으로부터
			// 1바이트씩 읽어올 수 있는 객체
			// 읽어들이는 값은 문자 코드 값이 된다.
			// (아스키 코드만 올바르게 읽어올 수 있다.)
			System.out.print("정수를 입력하세요 : ");
			int input = System.in.read();

		} catch (IOException e) {
			System.out.println("입출력 작업에서 예외가 발생");
		}
	
		
		
	}
}
