import java.util.Scanner;

public class Method_02_Ex {
	
	
	public static void gugudan_one(int dan) {
		System.out.println("");

			System.out.printf("%d단을 출력합니다.\n", dan);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", dan, j, dan * j);
			}
			System.out.println("");
		}

	public static void main(String[] args) {
		// 정수 한개를 매개변수로 전달받아 해당 정수의 구구단을 출력할 수 있는 메소드를 정의하기.
		// (메소드명 : gugudan_one)
		// 사용자에게 정수를 입력받아 앞서 정의한 gugudan_one 메소드를 사용하여
		// 해당 정수의 구구단을 출력하세요.
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("출력하고자 하는 단수를 입력하세요 : ");
		int input = kb.nextInt();
		
		gugudan_one(input);
		
		System.out.println("프로그램 종료");
		
		kb.close();
		

	}

}
