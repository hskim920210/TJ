import java.util.*;

public class Day04_Exercise {

	public static void main(String[] args) {
		// 4장

		// 1번
		// 조건문은 if, switch문이 있다.
		// 반복문은 for, while, do ~ while 문이 있다.
		
		
		

		// 2번
		// switch문은 정수타입 변수나 정수값을 산출하는 연산식만 올 수 있어서 double은 올 수 없다.
		
		
		

		// 3번
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0)
				sum += i;
		}
		System.out.printf("총 합은 %d이다.\n", sum);
		
		
		

		// 4번
		int num1 = (int) (Math.random() * 6) + 1;
		int num2 = (int) (Math.random() * 6) + 1;
		System.out.printf("(%d,%d)\n\n", num1, num2); // (눈1,눈2) 형태로 출력

		while (num1 + num2 != 5) {
			num1 = (int) (Math.random() * 6) + 1;
			num2 = (int) (Math.random() * 6) + 1;
			System.out.printf("(%d,%d)\n", num1, num2); // 두 눈의 합이 5가 나올 때 까지의 출력
		}
		System.out.println("프로그램 종료");

		
		
		
		// 5번
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60)
					System.out.printf("해는 (%d,%d)이다.\n", x, y);
			}
		}

		
		
		
		// 6번
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j<=i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		
		
		
		// 7번
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료 |");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int a = sc.nextInt();
			
			if (a == 1) {
				System.out.print("예금액 : ");
				balance += sc.nextInt();
				System.out.printf("예금액은 %d원 입니다.\n", balance);
			}
			else if (a == 2) {
				System.out.print("출금액 : ");
				int out = sc.nextInt();
				balance = balance - out;
				System.out.printf("잔고는 %d원 입니다.\n", balance);
			}
			else if (a == 3) {
				System.out.printf("잔고 : %d\n", balance);
			}
			else if (a == 4) {
				break;
			}
		}
		System.out.println("프로그램 종료");

	}

}
