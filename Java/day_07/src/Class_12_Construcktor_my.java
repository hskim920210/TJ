import java.util.Scanner;

class Student_my {
	Scanner kb = new Scanner(System.in);
	int sum = 0;
	double avg;
	private String s;
	private char d;
	int a;

	public Student_my(String name) {
		s = name;
	}

	public void input() {
		do {
			System.out.printf("국어 성적을 입력 (0 ~ 100) : ");
			a = kb.nextInt();
		} while (a < 0 || a > 100);
		sum += a;
		do {
			System.out.printf("영어 성적을 입력 (0 ~ 100) : ");
			a = kb.nextInt();
		} while (a < 0 || a > 100);
		sum += a;
		do {
			System.out.printf("수학 성적을 입력 (0 ~ 100) : ");
			a = kb.nextInt();
		} while (a < 0 || a > 100);
		sum += a;
		avg = (double) sum / 3;
		if (avg >= 90)
			d = 'A';
		else if (avg >= 80)
			d = 'B';
		else if (avg >= 70)
			d = 'B';
		else if (avg >= 60)
			d = 'B';
		else
			d = 'F';
	}

	public void output() {
		System.out.println("--------------------------");
		System.out.printf("%s 학생의 성적 정보를 출력합니다.\n", s);
		System.out.printf("총점 : %d 점, 평균 : %.2f 점\n", sum, avg);
		System.out.printf("등급 : %c\n", d);
		System.out.println("--------------------------");
	}
}

public class Class_12_Construcktor_my {

	public static void main(String[] args) {
		// 아래의 코드가 실행될 수 있도록 클래스를 작성하세요.
		// 실행 모습
		// 국어 성적을 입력 : 100
		// 영어 성적을 입력 : 100
		// 수학 성적을 입력 : 100
		// ----------------------------
		// 아무개 학생의 성적 정보를 출력합니다.
		// 총점 : 300 점, 평균 100.00 점
		// 등급 : A
		// ----------------------------

		Student_my s = new Student_my("아무개");
		s.input();
		s.output();

	}

}
