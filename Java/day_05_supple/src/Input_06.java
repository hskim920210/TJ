import java.util.Scanner;

public class Input_06 {

	public static void main(String[] args) {
		// 사용자에게 정수 n1, n2 2개를 입력받기
		// 입력된 정수 n1에서 n2까지 홀수 출력
		// 1번째 정수 : 1
		// 2번째 정수 : 5
		// 1 3 5
		// 1번째 정수 : 10
		// 2번째 정수 : 3
		// 9 7 5 3
		
		Scanner kb = new Scanner(System.in);
		
		// 1. 입력
		int n1, n2;
		System.out.printf("1번째 정수 : ");
		n1 = kb.nextInt();
		System.out.printf("2번째 정수 : ");
		n2 = kb.nextInt();
		// i <= n2
		for ( int i = n1 ; (n1 < n2 && i <=n2) || (n1>n2 && i>=n2) ; i = (n1 > n2 ? i-1 : i+1 )) {
			if ( i%2 == 1 ) {
				System.out.printf("%d ", i);
			}
		}
		
		
		/*
		
		int n1,n2;
		int min = 0;
		
		
		for ( int i = 0 ; i < 2 ; i++) {
			System.out.printf("%d번째 정수 : ", i+1);
			if ( i == 0 ) {
			n1 = kb.nextInt();
			} else if ( i == 1 ) {
				n2 = kb.nextInt();
			}
		}
		
		if ( min > n1 ) {
			
		}
		
		*/

	}

}
