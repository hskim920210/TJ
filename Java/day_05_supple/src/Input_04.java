import java.util.Scanner;

public class Input_04 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		// 반복문 - 구구단

		int dan;
		
		// 2 ~ 9 사이의 값이 입력될 때 까지 반복해서 입력

		do {
			System.out.print("원하는 단수을 입력하세요 : ");
			dan = kb.nextInt();
		} while( dan < 2 || dan > 9);

		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan*i);
		}
		
		// resolved : 오타거나 영역이 틀렸거나.

	}

}
