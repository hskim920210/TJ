package tje.io;

import java.io.*;

public class IO_11 {
	public static void main(String[] args) throws Exception {
		// 파일 처리
		// File에 데이터를 버퍼를 사용해서 출력하는 방법
		// BufferedOutputStream(이진데이터), BufferedWriter(문자데이터)
		
		String dirPath = "D:\\dev\\java_se\\file_test";
		File dir = new File(dirPath);
		
		if( !dir.exists() )
			dir.mkdirs();	
		
		File file_binary = new File(dir, "binary_data_using_buffer.dat");
		File file_text = new File(dir, "text_data_using_buffer.txt");
		
		// 파일에 출력할 수 있는 스트림 객체 생성
		// 1. 이진데이터를 출력할 수 있는 스트림 객체 생성
		BufferedOutputStream bos = 
				new BufferedOutputStream(
						new FileOutputStream(file_binary));
				
		// 2. 문자데이터를 출력할 수 있는 스트림 객체 생성
		BufferedWriter bw = 
				new BufferedWriter(
						new FileWriter(file_text));
		
		// 버퍼에 내용을 출력
		// 버퍼에 출력된 데이터는 해당 스트림이 close 되거나
		// 해당 스트림 객체에 대해서 flush 메소드가 호출되면
		// 실제 스트림을 통해서 출력됩니다.
		bos.write(11);
		bos.write(22);
		
		// flush 메소드는 버퍼에 쌓여있는 데이터를 출력하는 메소드
		// (버퍼를 비우는 명령을 실행)
		bos.flush();

		bw.write("Hello~");
		bw.write("Java~");
		
		// flush 메소드는 버퍼에 쌓여있는 데이터를 출력하는 메소드
		// (버퍼를 비우는 명령을 실행)
		bw.flush();
		
		// 스트림을 종료
		bw.close();
		bw.close();
	}
}