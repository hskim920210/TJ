import java.util.Scanner;

public class ControlStatement_FOR_02_Example {

	public static void main(String[] args) {
		// 사용자에게 2 개의 정수를 입력받아 2개의 정수 중 작은 값부터 시작하여 큰 값까지 홀수만 출력하세요
		// 1 번째 정수 : 5
		// 2 번째 정수 : 10
		// 결과 : 5 7 9
		
		Scanner kb = new Scanner(System.in);
		int a, b, c, d ;
		System.out.print("첫번째 정수 : ");
		a = kb.nextInt();
		System.out.print("두번째 정수 : ");
		b = kb.nextInt();
		kb.close();
		
		
		// 입력된 두개의 정수를 작은값(시작값) 큰값(종료값)으로 분류
		int start, end;
		
		if ( a > b ) {
			start = b;
			end = a;
		} else {
			start = a;
			end = b;
		}
		
		// 종료값을 저장하는 변수를 홀수로 변경
		end = end%2 == 0 ? end - 1 : end;
		
		System.out.print("결과 : ");
		for ( int i = start ; i <= end ; i++ ) {
			if ( i % 2 == 1 )
				// 종료값이 아니라면 쉼포를 출력
				System.out.printf("%d%c ", i, i == end ? ' ' : ','); // ("%d%s, i, i != end ? ", " : "\n"); 으로도 가능하다.
		}
		
		
		/* ( 내가 한것 )
		if (a>b) {
			c = b; 
			d = a; }
		else {
			c = a;
			d = b; }
		
		
		
		
		for (  ; c < d ; c+=1) {
			if ( c % 2 == 1 )
				System.out.printf("%d, ", c);
		}
		*/
		
		
				

	}

}
