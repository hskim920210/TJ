import java.util.Scanner;

public class Input_02 {

	public static void main(String[] args) {
		// 정수 2개를 입력받아 합계를 출력
		
		Scanner kb = new Scanner(System.in);
		int n1, n2;
		
		System.out.print("정수 1번 입력 : ");
		n1 = kb.nextInt();
		System.out.print("정수 2번 입력 : ");
		n2 = kb.nextInt();
		
		// 처리과정
		int r1 = n1 + n2;
		int r2 = n1 * n2;
		double r3 = n1 / n2;
		int r4 = n1 % n2;
		
		
		
		// 출력
		System.out.printf("%d + %d = %d\n", n1, n2, r1);
		System.out.printf("%d * %d = %d\n", n1, n2, r2);
		System.out.printf("%d / %d = %.2f\n", n1, n2, r3);
		System.out.printf("%d %% %d = %d\n", n1, n2, r4);
		
		
		

	}

}
