import java.util.Scanner;

public class Input_07 {

	public static void main(String[] args) {
		// 사용자에게 정수 1개 입력
		// 반드시 양수만 입력받기
		// 1부터 사용자가 입력한 정수까지 출력
		
		Scanner kb = new Scanner(System.in);
		int a;
		int sum = 0;
		do {
			System.out.print("양의 정수를 입력하세요 : ");
			a = kb.nextInt();
		} while ( a <= 0);
		
		// 아래의 for문을 수정하여 사용자가 입력한 정수까지의 소수만 출력하세요.
		// 소수 : 1과 자기자신 외에 나누어 떨어지지 않는 수
		
		
		out:
		for ( int i = 2 ; i <= a ; i++) {
			
			for (int j = 2 ; j < i / 2 ; j++) {
				if (i % j == 0 )
					continue out;
			}						
			System.out.printf("%d ", i);
		}

	}

}
