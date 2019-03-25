import java.util.Scanner;

public class Input_03 {

	public static void main(String[] args) {
		// 정수 2개와 사칙연산 기호를 입력받아 결과를 출력
		
		Scanner kb = new Scanner(System.in);
		int n1, n2;
		char buho;
		
		System.out.print("정수 1번 입력 : ");
		n1 = kb.nextInt();
		System.out.print("부호 입력 : ");
		buho = kb.next().charAt(0);
		System.out.print("정수 2번 입력 : ");
		n2 = kb.nextInt();
		
		// 처리과정. 입력과정과 처리과정은 별개다.
		int r ;
		if (buho == '+')
			r = n1 + n2;
		else if (buho == '-')
			r = n1 - n2;
		else if (buho == '*')
			r = n1 * n2;
		else if (buho == '/')
			r = n1 / n2;
		else
			r=0;
		
		
		
		// 출력
		System.out.printf("%d %c %d = %d\n", n1, buho, n2, r);

	}

}
