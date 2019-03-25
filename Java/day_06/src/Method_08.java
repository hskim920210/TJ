import java.util.Scanner;

// 꼭 다시해보자
public class Method_08 {

	public static int getStudentNumber(Scanner kb) {
		System.out.print("학생 수를 입력하세요. : ");
		return kb.nextInt();
	}

	public static int getSubjectNumber(Scanner kb) {
		System.out.print("과목 수를 입력하세요. :");
		return kb.nextInt();
	}

	public static void input(Scanner kb, int[][] scores) {
		// 다차원 배열에 성적을 입력받는 역할
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d번째 학생의 성적입력을 시작합니다.\n", i + 1);
			input(kb, scores[i]);
		}
	}

	public static void input(Scanner kb, int[] scores) {
		// 일차원 배열에 성적을 입력받는 역할
		for (int i = 0; i < scores.length; i++) {
			do {
				System.out.printf("%d번째 성적을 입력하세요. (0점 ~ 100점) : ", i + 1);
				scores[i] = kb.nextInt();
			} while (scores[i] < 0 || scores[i] > 100);
		}
	}

	public static void output(int[][] scores) {
		System.out.println("=================");
		System.out.println("성적 출력을 시작합니다.");
		System.out.println("=================");

		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d번째 학생의 총점 : %d점, 평균 : %.2f점 입니다.\n", i + 1, getTotal(scores[i]),
					getAverage(scores[i]));
			System.out.printf("%d번째 학생의 등급 : %c\n", i + 1, getGrade(scores[i]));
		}
	}

	public static int getTotal(int[] scores) {
		int tot = 0;
		for (int i = 0; i < scores.length; i++) {
			tot += scores[i];
		}
		return tot;
	}

	public static double getAverage(int[] scores) {
		return (double) getTotal(scores) / scores.length;
	}

	public static char getGrade(int[] scores) {
		double avg = getAverage(scores);
		char grade;
		if (avg >= 90)
			grade = 'A';
		else if (avg >= 80)
			grade = 'B';
		else if (avg >= 70)
			grade = 'C';
		else if (avg >= 60)
			grade = 'D';
		else
			grade = 'F';
		return grade;
	}

	public static void main(String[] args) {
		// 사용자에게 학생수를 입력받은 후 과목수를 입력받으세요.
		// 입력된 학생 수에 맞춰 과목 점수를 입력받고
		// 총점과 평균은 출력하세요.
		// 평가는 - 입니다 까지 출력 (ABCDF)
		Scanner kb = new Scanner(System.in);
		int[][] scores;

		scores = new int[getStudentNumber(kb)][getSubjectNumber(kb)];
		// System.out.println(scores.length);
		// System.out.println(scores[0].length);

		input(kb, scores);
		output(scores);

		kb.close();
		System.out.println("프로그램 종료");

	}

}
