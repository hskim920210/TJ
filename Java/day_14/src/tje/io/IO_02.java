package tje.io;

// enter : \r\n
// \n : 10, \r : 13

import java.io.*;

public class IO_02 {
	public static void main(String[] args) throws IOException {
		// 입력 스트림의 동작방식
		// 입력 스트림의 겨우 데이터를 입력받을 버퍼를 검색하여
		// 해당 버퍼에 내용이 존재하지 않는 경우 버퍼에 데이터가 쌓일 때 까지 대기함
		// (키보드 입력의 경우 사용자가 데이터를 입력하고 엔터키 입력할 때 까지 대기)
		
		// 연결된 버퍼에 데이터가 존재하는 경우, 해당 버퍼에서
		// 바이트 스트림은 1byte씩 데이터를 읽어오고,
		// 문자 스트림의 경우 2byte씩 데이터를 읽어옴
		
		int input;
		
		System.out.print("키보드 입력을 실행하세요 : ");
		input = System.in.read();
		System.out.printf("입력된 값 : %d\n", input);
		System.out.printf("입력된 문자 : %c\n", input);
		
		System.out.print("키보드 입력을 실행하세요 : ");
		input = System.in.read();
		System.out.printf("입력된 값 : %d\n", input);
		System.out.printf("입력된 문자 : %c\n", input);
		
		System.out.print("키보드 입력을 실행하세요 : ");
		input = System.in.read();
		System.out.printf("입력된 값 : %d\n", input);
		System.out.printf("입력된 문자 : %c\n", input);
	}
}
