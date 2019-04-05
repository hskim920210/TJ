package tje.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_07 {
	public static void main(String[] args) throws IOException {
		// 다수개의 스트림 클래스들이 조합된 스트림 객체 생성
		// BufferedReader 객체 생성 예제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;

		// BufferedReader 클래스의 객체를 사용하여
		// 기본 자료형의 타입을 읽어온 후, 형변환을 하는 예제
		System.out.print("정수 입력 : ");
		input = br.readLine();

		// 입력된 문자열을 정수로 변환
		int num = Integer.parseInt(input);
		System.out.printf("입력된 정수 : %d\n", num);
		
		System.out.print("실수 입력 : ");
		input = br.readLine();
		// 입력된 문자열을 실수로 변환
		double num_double = Double.parseDouble(input);
		System.out.printf("입력된 실수 : %.2f\n", num_double);
		
		System.out.println("문자 입력 : ");
//		input = br.readLine();
//		// 입력된 문자열을 문자로 변환
//		char single_ch = input.charAt(0);
		char single_ch = (char)br.read();
		// 엔터키에 해당되는 2개의 문제 (\r\n)을 제거
		br.skip(2);
		System.out.printf("입력된 문자 : %c\n", single_ch);
		
		// 스트림의 사용이 종료되면 반드시 close 메소드를 호출합니다.
		br.close();
		

	}
}
