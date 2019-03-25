import java.util.Scanner;

public class ControlStatement_IF_05 {

	public static void main(String[] args) {
		// 키보드 입력 기능을 사용하여 사용자에게 3개의 성적점수를 입력받으세요.
		// 입력된 성적 점수를 사용하여 총점과 평균을 출력하세요.
		// 예시
		// 1번째 100, 200번째 100, 300번째 100
		// 처리괄과 : 총점은 300점, 평균은 100.00점 입니다.
		
		Scanner sc = new Scanner(System.in);
		
		int score_1;
		System.out.print("첫번째 성적을 입력하세요 : ");
		score_1 = sc.nextInt();
		
		int score_2;
		System.out.print("두번째 성적을 입력하세요 : ");
		score_2 = sc.nextInt();
		
		int score_3;
		System.out.print("세번째 성적을 입력하세요 : ");
		score_3 = sc.nextInt();
		
		int sum = score_1 + score_2 + score_3;
		double avg = sum/3.0;
		System.out.println("총점은 "+sum+"점 입니다.");
		System.out.printf("총점은 %.2f점 입니다.", avg);		
		
		// 키보드 입력 처리를 종료. 스트림을 종료해주는 명령. 닫히지 않으면 메모리 유수가 일어날 수 있다.
		sc.close();

		/*
		 * // 1. 입력
		 * // - 변수를 선언
		 * Scanner keyboard = new Scanner(System.in);
		 * int score_1, score_2, score_3;
		 * // - 변수에 값을 대입
		 * System.out.print("1번째 성적을 입력하세요 : ");
		 * score_1 = keyboard.nextInt();
		 * System.out.print("2번째 성적을 입력하세요 : ");
		 * score_2 = keyboard.nextInt();
		 * System.out.print("3번째 성적을 입력하세요 : ");
		 * score_3 = keyboard.nextInt();
		 * 
		 * // 2. 처리
		 * // - 변수를 선언
		 * int tot;
		 * double avg;
		 * // - 처리 과정 실행 및 변수에 값을 대입
		 * tot = score_1 + score_2 + score_3
		 * avg = tot/3.0
		 * 
		 * // 3. 출력 및 저장
		 * // - 입력된 변수 및 처리된 변수의 값을 사용하여 출력 및 저장
		 * System.out.printf("처리괄과 : 총점은 %d점, 평균은 %.2f점 입니다.\n", tot, avg);
		 */
		
		
		
	}

}
