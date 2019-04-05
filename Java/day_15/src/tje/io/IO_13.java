package tje.io;

import java.io.*;

public class IO_13 {

	public static void main(String[] args) throws IOException {
		String dirPath = "D:\\dev\\java_se\\tools\\eclipse\\readme";
		File dir = new File(dirPath);
		
		
		String fileName = "readme_eclipse.html";
		File file = new File(dir, fileName);
		
		// 파일을 읽어오기 위한 문자 스트림 객체 생성
		// 문자스트림으로 오는 경우 굳이 인풋스트림으로 바꿀 필요가 없다.
		BufferedReader in =
				new BufferedReader(
						new FileReader(file));
		
		String input;
		while( (input = in.readLine()) != null )
			System.out.println(input);
		
		in.close();
		System.out.println("프로그램 종료");
		
		
//		BufferedReader in =
//				new BufferedReader(
//						new InputStreamReader(
//								new FileInputStream(file)));
				

	}

}
