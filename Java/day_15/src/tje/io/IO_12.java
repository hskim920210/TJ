package tje.io;

import java.io.*;

public class IO_12 {
	public static void main(String[] args) throws Exception {
		// 파일 처리
		// File에 데이터를 버퍼를 사용해서 입력받는 방법
		// BufferedInputStream(이진데이터), BufferedReader(문자데이터)
		
		String dirPath = "D:\\dev\\java_se\\file_test";
		File dir = new File(dirPath);
		
		if( !dir.exists() )
			dir.mkdirs();	
		
		File file_binary = new File(dir, "binary_data_using_buffer.dat");
		File file_text = new File(dir, "text_data_using_buffer.txt");
		
		// 파일에 출력할 수 있는 스트림 객체 생성
		// 1. 이진데이터를 입력받을 수 있는 스트림 객체 생성
		BufferedInputStream bis = 
				new BufferedInputStream(
						new FileInputStream(file_binary));

		// 2. 문자데이터를 입력받을 수 있는 스트림 객체 생성
		BufferedReader br = 
				new BufferedReader(
						new FileReader(file_text));
		
		int input_binary;
		while( (input_binary = bis.read()) != -1 )
			System.out.println(input_binary);
		
		String input_text;
		while( (input_text = br.readLine()) != null )
			System.out.println(input_text);
				
		// 스트림을 종료
		bis.close();
		br.close();
	}
}
