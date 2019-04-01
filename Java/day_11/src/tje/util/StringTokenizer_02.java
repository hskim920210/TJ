package tje.util;


// 문자열을 분할할 수 있는 기능을 제공하는 클래스
import java.util.StringTokenizer;

public class StringTokenizer_02 {

	public static void main(String[] args) {
		// ; 을 기준으로 정보가 저장된 문자열 변수
		String subjects = "KOR;ENG;MATH";
		String scores = "100,97#95";

		// StringTokenizer 클래스를 사용하여 위의 문자열 변수를 파싱한 후,
		// 아래와 같이 출력하세요
		// KOR  : 100 점
		// ENG  :  90 점
		// MATH :  95 점
		// tot  : 285 점
		// avg  : 95.00 점
		
		String [] subject_list ;
		int [] score_list;
		
		
		
		
//		int a;
//		int tot = 0;
//		double avg;
		
		
		StringTokenizer st2 = new StringTokenizer(scores, ",#");
		StringTokenizer st1 = new StringTokenizer(subjects, ";");
		
		subject_list = new String[st1.countTokens()];
		score_list = new int [st2.countTokens()];
		
		int index = 0;
		int tot = 0;
		
		while( st1.hasMoreTokens() ) {
			subject_list[index] = st1.nextToken();
			score_list[index] = Integer.parseInt(st2.nextToken());
			tot += score_list[index];
			
			System.out.printf("%5s : %3d\n", subject_list[index], score_list[index]);
		}
		double avg = (double)tot / score_list.length;
		
		System.out.printf("%5s : %d 점\n","TOT", tot);
		System.out.printf("%5s : %.2f 점\n","AVG", avg);
		
		
		
		
		
//		while ( stSubjects.hasMoreTokens() ) {
//			System.out.printf("%5s : %6s 점\n", stSubjects.nextToken(), stScores.nextToken());
//			a = Integer.parseInt(stScores.nextToken());
//			tot += a;
//					
//		}
//		avg = (double)tot/3;
//		
//		System.out.printf("총점 : %d\n 평균 : %.2f", tot, avg);
	}

}
