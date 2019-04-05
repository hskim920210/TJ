package tje.io;

import java.io.*;

public class IO_10 {
	public static void main(String[] args) throws Exception {
		// 파일 처리
		// File로부터 데이터를 입력받는 방법
		// FileInputStream(이진데이터), FileReader(문자데이터)

		String dirPath = "D:\\dev\\java_se\\temp\\file_test";
		File dir = new File(dirPath);

		if (!dir.exists())
			dir.mkdirs();

		File file_binary = new File(dir, "binary_data.dat");
		File file_text = new File(dir, "text_data.txt");

		// 파일에로부터 입력받을 수 있는 스트림 객체 생성
		// 주의사항 : 파일 출력 스트림의 경우 파일이 존재하지 않으면
		// 생성한 후 스트림을 생성
		// 반면, 입력스트림은 파일이 존재하지 않으면 예외가 발생.

		// 1. 이진데이터를 입력받을 수 있는 스트림 객체 생성
		FileInputStream fis = new FileInputStream(file_binary);

		// 2. 문자데이터를 출력할 수 있는 스트림 객체 생성
		FileReader fr = new FileReader(file_text);

		// 파일로부터 내용을 입력받는 코드

//		int data_binary = fis.read();
//		System.out.println(data_binary);
//		data_binary = fis.read();
//		System.out.println(data_binary);
//		data_binary = fis.read();
//		// 파일의 끝에 도착하면 -1값이 반환
//		System.out.println(data_binary);

		// 바이트 스트림을 사용하여 파일의 끝까지 1byte 씩 읽어오는 코드
		int data_binary;
		while ((data_binary = fis.read()) != -1)
			System.out.println(data_binary);

		// 문자 스트림을 사용하여 파일의 끝까지 2byte 씩 읽어오는 코드
		
		
		// 주의사항
		// 만약 텍스트 파일의 내용을 한 글자씩 읽어들이는 경우
		// 반드시 int 타입으로 문자값을 전달 받아야합니다.
		// 파일에 끝에 도달하면 -1 값이 반환하지만
		// char 은 부호가 없는 자료형이므로 -값을 처리할 수 없음
		// 무조건 양수로만 취급하여 반복을 빠져나올 수 없습니다.
		int data_text;
		while ((data_text = fr.read()) != -1)
			System.out.println((char) data_text);

		fis.close();
		fr.close();

		System.out.println("프로그램 종료");

	}
}
