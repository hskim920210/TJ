import java.util.*;

public class ControlStatement_FOR_06_Example_1 {

	public static void main(String[] args) {
		// 성적처리를 위한 프로그램을 작성한다.
		// 3 과목의 성적을 입력받아 총점, 평균을 계산하여 출력
		// 사용자가 종료를 원할 때 까지 반복
		// <예시>
		// 성적처리를 시작합니다.
		// 1번째 성적을 입력하세요 : 100
		// 2번째 성적을 입력하세요 : 100
		// 3번째 성적을 입력하세요 : 100
		// 총점 : 300점, 평균 : 100.00점
		// 종료? (y/n) : n
		// 1번째 성적을 입력하세요 : 90
		// 2번째 성적을 입력하세요 : 90
		// 3번째 성적을 입력하세요 : 90
		// 총점 : 270점, 평균 : 90.00점
		// 종료? (y/n) : n
		// 프로그램 종료
		Scanner kb = new Scanner(System.in);
		/*
		 * System.out.print("성적 처리를 시작합니다.\n"); char e; int sum = 0; for ( int k = 1 ;
		 * ;k++ ) { if (k == 4) { System.out.printf("총점 : %d, 평균 : %.2f", sum, sum/3.0);
		 * break; } System.out.printf("%d번째 성적을 입력하세요. : \n",k); int x = kb.nextInt();
		 * sum += x; } System.out.print("종료? (y/n) : "); e = kb.
		 */

		System.out.println("성적처리를 시작합니다.");

		for (;;) {
			// 1. 입력
			int s1, s2, s3;
			System.out.print("1번째 성적을 입력하세요. : ");
			s1 = kb.nextInt();
			System.out.print("2번째 성적을 입력하세요. : ");
			s2 = kb.nextInt();
			System.out.print("3번째 성적을 입력하세요. : ");
			s3 = kb.nextInt();

			int tot;
			double avg;

			tot = s1 + s2 + s3;
			avg = (double) tot / 3;

			System.out.printf("총점 : %d점, 평균 : %.2f점 \n", tot, avg);

			// 반복의 종료처리
			System.out.print("종료 ? (y/n) : ");
			char isExit = kb.next().charAt(0); // charAt(0)은 가장 앞에있는 문자를 가져옴

			if (isExit == 'y' || isExit == 'Y')
				break;
		}

		System.out.println("프로그램 종료");
		kb.close();

	}

}
