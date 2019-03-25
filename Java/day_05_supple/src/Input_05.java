import java.util.Scanner;

public class Input_05 {

	public static void main(String[] args) {

		// 2개의 성적을 입력받아 총점과 평균을 출력
		// 성적은 반드시 0~100 사이의 수가 입력되어야
		Scanner kb = new Scanner(System.in);

		int score1, score2;

		do {
			System.out.print("첫번째 성적을 입력하세요. : ");
			score1 = kb.nextInt();
		} while (score1 < 0 || score1 > 100);

		while (true) {
			System.out.print("두번째 성적을 입력하세요. : ");
			score2 = kb.nextInt();
			if (score2 >= 0 && score2 <= 100) {
				break;
			}
		}

		int sum = score1 + score2;
		double avg = (double) sum / 2;

		System.out.printf("총점은 %d점, 평균은 %.2f점", sum, avg);

	}

}
