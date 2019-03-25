import java.util.*;

public class ControlStatement_DO_WHILE_02 {

	public static void main(String[] args) {
		// do ~ while 반복문을 활용한 계산기 예제

		// 1. 입력
		Scanner kb = new Scanner(System.in);

		// 계산에 사용할 정수 두개를 저장할 변수
		int n1, n2;
		// 계산에 사용할 부호의 정보를 문자로 저장
		char operator;
		// 프로그램의 종료를 결정할 변수
		char isEnd;

		// 2. 처리
		do {
			System.out.print("1번째 정수를 입력 : ");
			n1 = kb.nextInt();
			System.out.print("계산 부호를 입력 : ");
			operator = kb.next().charAt(0);
			System.out.print("2번째 정수를 입력 : ");
			n2 = kb.nextInt();

			double result;
			// char 타입의 변수는 정수형이므로 switch 구문으로 처리할 수 있다.
			switch (operator) {
			case '+':
				result = n1 + n2;
				break;
			case '-':
				result = n1 - n2;
				break;
			case '*':
				result = n1 * n2;
				break;
			case '/':
				result = (double) n1 / n2;
				break;
			case '%':
				result = n1 % n2;
				break;
			default:
				operator = '$';
				result = 0;
			}

			if (operator != '$')
				System.out.printf("%d %c %d = %.2f\n", n1, operator, n2, result);
			else
				System.out.println("부호의 값을 정확히 입력하세요.");

			// 프로그램의 종료 처리
			System.out.print("프로그램 종료? (y/n) : ");
			isEnd = kb.next().charAt(0);

		} while (isEnd == 'n' || isEnd == 'N');

	}

}
