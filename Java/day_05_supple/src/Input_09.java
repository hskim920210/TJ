import java.util.Scanner;

public class Input_09 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 실행 종료를 제어하는 변수
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;

		
		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			
			
			
			if ( selectNo == 1 ) {
				System.out.print("학생수> ");
				int sNo = scanner.nextInt();
				scores = new int[sNo];
			} else if ( selectNo == 2 ) {
				if (scores == null) {
					System.out.println("학생수를 먼저 입력하세요.");
					continue;
				}
				for ( int i = 0 ; i < scores.length ; i++ ) {
					System.out.printf("scores[%d] : ", i);
					scores[i] = scanner.nextInt();
				}
			} else if ( selectNo == 3 ) {
				if (scores == null) {
					System.out.println("점수를 먼저 입력하세요.");
					continue;
				}
				for ( int i = 0 ; i < scores.length ; i++) {
					System.out.printf("scores[%d] : %d\n", i, scores[i]);
				}
			} else if ( selectNo == 4 ) {
				if (scores == null) {
					System.out.println("점수를 먼저 입력하세요.");
					continue;
				}
				int max = scores[0];
				int tot = scores[0];
				for ( int i = 1 ; i < scores.length ; i++) {
					tot += scores[i];
					if ( scores[i] > max)
						max = scores[i];
				}
				double avg = (double)tot / scores.length;
				System.out.printf("최대값 : %d점\n", max);
				System.out.printf("평균 : %.2f점\n", avg);
			} else if ( selectNo == 5 )
				break;
			
			
	}
		System.out.println("프로그램 종료");
}
}
