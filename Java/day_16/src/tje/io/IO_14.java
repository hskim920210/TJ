package tje.io;

import java.io.*;

public class IO_14 {
	public static void main(String[] args) throws IOException {
		String dirPath = "D:\\dev\\java_se\\file_test";
		File dir = new File(dirPath);

		File file = new File(dir, "log.txt");

		// 키보드로부터 입력된 내용을 log.txt 파일에 출력하세요.

		// 키보드 입력 스트림
		BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(System.in)); // 이미 만들어진 바이트스트림인 시스템점인을 인풋스트림리더로 변환

		// 파일 출력 스트림
		// 문자 타입의 출력에 사용되는 PrintWriter 클래스
		// print, println, printf 와 같이 문자 타입을 출력할 때
		// 유용한 메소드들을 제공하는 클래스
		PrintWriter out = 
				new PrintWriter(
						new BufferedWriter(
								new FileWriter(file, true)), true);
		
		// PrintWriter 클래스의 생성자에서 boolean의 값을 전달하여
		// 자동으로 flush 메소드를 호출할 수 있도록 제어할 수 있다.
		// FileOutputStream, FileWriter 클래스의 생성자에서 boolean의 값을 전달하여
		// 새롭게 파일의 내용을 작성하거나, 기존의 내용에서 추가하여 파일을 작성할 수 있다.

		// 키보드로부터 입력된 문자열을 저장할 변수
		String msg;
		// 종료 여부의 값을 입력받을 변수
		char isExit;

		do {
			System.out.print("로그 메세지 입력 : ");
			// 키보드로부터 한줄의 문자열을 입력받음
			msg = in.readLine();
			// 입력된 문자열을 파일에 출력
			out.println(msg);
			
			// 버퍼에 출력된 문자열을 실제 파일로 출력
			// PrintWriter 클래스의 생성자 매개변수인
			// autoflush 값을 true 지정하는 경우
			// 모든 출력메소드의 실행 시 자동으로
			// flush 메소드가 호출됨
			// out.flush();

			System.out.print("종료? (y/n) : ");
			isExit = (char) in.read();
			
			// 입력버퍼에 남아있는 엔터키의 값 제거
			in.skip(2);
			
		} while (isExit != 'y' && isExit != 'Y');

		in.close();
		out.close();
		System.out.println("프로그램 종료");
	}
}
