package tje.util;

// 문자열을 분할할 수 있는 기능을 제공하는 클래스
import java.util.StringTokenizer;

public class StringTokenizer_01 {

	public static void main(String[] args) {
		// ; 을 기준으로 정보가 저장된 문자열 변수
		String subjects = "KOR;ENG;MATH";
		String scores = "100,90#95";

		// subjects 문자열 변수를 ;를 기준으로 분할할 수 있는
		// StringTokenizer 객체를 생성
		StringTokenizer stSubjects = new StringTokenizer(subjects, ";");
		// scores 문자열 변수를 ,와 #를 기준으로 분할할 수 있는
		// StringTokenizer 객체를 생성
		StringTokenizer stScores = new StringTokenizer(scores, ",#");
		
		// StringTokenizer는 분할된 문자열을 TOKEN으로 호칭하며
		// 반복문을 통해 각 토큰에 접근할 수 있다.
		// hasMoreTokens 메소드는 현재 접근할 수 있는 토큰의 존재 유무를
		// true 또는 false 값으로 반환
		while( stSubjects.hasMoreTokens() ) {
			// nextToken 메소드는 다음 토큰의 위치로 이동하여 해당 토큰의 값을 반환하는 메소드
			System.out.println(stSubjects.nextToken());
		}
		
		while( stScores.hasMoreTokens() ) {
			System.out.println(stScores.nextToken());
		}
	}

}
