package tje.io;

import java.io.*;

public class IO_09 {
	public static void main(String[] args) throws Exception {
		// 파일 처리
		// File에 데이터를 출력하는 방법
		// FileOutputStream(이진데이터), FileWriter(문자데이터)

		String dirPath = "D:\\dev\\java_se\\temp\\file_test";
		File dir = new File(dirPath);

		if (!dir.exists())
			dir.mkdirs();

		// 파일 출력 스트림 객체는 해당 파일이 존재하지 않는 경우
		// 파일을 생성하여 스트림을 구성함.

		File file_binary = new File(dir, "binary_data.dat");
		File file_text = new File(dir, "text_data.txt");

		// 파일에 출력할 수 있는 스트림 객체 생성
		// 1. 이진데이터를 출력할 수 있는 스트림 객체 생성
		FileOutputStream fos = new FileOutputStream(file_binary);

		// 2. 문자데이터를 출력할 수 있는 스트림 객체 생성
		FileWriter fw = new FileWriter(file_text);

		// 파일에 내용을 출력
		// 1. 바이트 스트림을 통해서 출력
		fos.write(11);
		fos.write(22);

		// 2. 바이트 스트림을 통해서 출력
		fw.write(11);
		fw.write(22);
		fw.write("Hello~");
		fw.write("Java~");
		
		// 스트림을 종료
		fos.close();
		fw.close();
	}
}
