import java.util.*;

public class ControlStatement_FOR_10_Example_05 {

	public static void main(String[] args) {
		// 중첩된 반복문을 활용하여 학생의 성적을 처리하는 프로그램 작성
		// <예시>
		// 학생수 입력 : 3
		// 과목수 입력 : 3
		// 1번째 학생의 1번째 성적 :
		// 1번째 학생의 2번째 성적 :
		// 1번째 학생의 3번째 성적 :
		// 1번째 학생의 총점은 300점, 평균은 100점
		// 2번째 학생의 1번째 성적 :
		// 2번째 학생의 2번째 성적 :
		// 2번째 학생의 3번째 성적 :
		// 2번째 학생의 총점은
		// ...
		// 바깥쪽이 1번할때 성적은 전체가 돈다.

		Scanner kb = new Scanner(System.in);

		int a, b; // 같은 변수 한번에 바꾸는법 : 우클릭 -> refactor -> rename
		int sum;

		System.out.print("학생 수 입력 : ");
		a = kb.nextInt();
		System.out.print("과목 수 입력 : ");
		b = kb.nextInt();
		System.out.println();

		for (int i = 1; i <= a; i++) {
			System.out.printf("<%d번째 학생 성적을  처리합니다.>\n", i);
			// 처리 과정 중 새로운 입력 정보가 발생!
			sum = 0;
			for (int j = 1; j <= b; j++) {
				System.out.printf("%d번째 학생의 %d번째 성적 : ", i, j);
				sum += kb.nextInt();
			}
			double avg = (double) sum / b;
			System.out.printf("%d번째 학생의 총점 : %d점, 평균 : %.2f점\n\n", i, sum, avg);
		}
		System.out.println("프로그램 종료");
		kb.close();
	}
}
