// 빅데이터, 머신러닝

package tje.io;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class IO_13_Ex {

	public static void main(String[] args) throws IOException {
		// Java JDK가 설치된 디렉토리 내부의
		// THIRDPARTYLICENSEREADME.txt 파일을 읽어오기.
		// 파일 내부에 공백을 기준으로 사용된 각 단어의 카운트를 계산하고 출력
		// StringTokenizer 클래스를 사용하여 문자열을 공백을 기준으로 추출
		// HashMap 클래스를 사용하여 각 단어별 카운팅 계산.
		
		String dirPath = "C:\\Program Files\\Java\\jdk1.8.0_202";
		File dir = new File(dirPath);
		
		
		String fileName = "THIRDPARTYLICENSEREADME.txt";
		File file = new File(dir, fileName);
		
		// 파일을 읽어오기 위한 문자 스트림 객체 생성
		// 문자스트림으로 오는 경우 굳이 인풋스트림으로 바꿀 필요가 없다.
		BufferedReader in =
				new BufferedReader(
						new FileReader(file));
		
		HashMap<String, Integer> counter = new HashMap<>();
		
		
		String input;

		while( (input = in.readLine()) != null ) {
			StringTokenizer st = new StringTokenizer(input, " /`-;??<>,.=()\"'");
			
			while( st.hasMoreTokens() ) {
				String word = st.nextToken();
				// 모든 영문자를 소문자로 변경
				word = word.toLowerCase();
				
				int count = 1;
				
				if( counter.containsKey(word) )
					count = counter.get(word) + 1 ;
				
				counter.put(word, count);
			}
			
		}
			
		
		in.close();
		
		for( String key : counter.keySet() )
			System.out.printf("%s : %d\n", key, counter.get(key));

		

	}

}
