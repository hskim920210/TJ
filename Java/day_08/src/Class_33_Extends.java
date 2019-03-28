
// +, - 기능을 가지고 있는 PlusMinusCalculator 클래스를 선언한 후
// main 메소드에서 테스트하세요.
// 1번째 정수를 입력 : 10
// 2번째 정수를 입력 : 5
// 부호를 입력하세요 : +
// 10 + 5 = 15

import java.util.Scanner;

class PlusMinusCalculator {
	public void plus(int n1, int n2) {
		int r = n1 + n2;
		System.out.printf("%d + %d = %d\n", n1, n2, r);
	}

	public void minus(int n1, int n2) {
		int r = n1 - n2;
		System.out.printf("%d - %d = %d\n", n1, n2, r);
	}
}

//PlusMinusCalculator 클래스를 상속받는 Calculator 클래스를 선언하세요.
//Calculator 클래스는 사칙연산과 나머지 연산을 제공할 수 있도록 구현하세요.

class Calculator extends PlusMinusCalculator {
	public void divide(int n1, int n2) {
		double r = (double)n1 / n2;
		System.out.printf("%d / %d = %.2f\n", n1, n2, r);
	}
	public void multiple(int n1, int n2) {
		int r = n1 * n2;
		System.out.printf("%d * %d = %d\n", n1, n2, r);
	}
	public void moduler(int n1, int n2) {
		int r = n1 % n2;
		System.out.printf("%d %% %d = %d\n", n1, n2, r);
	}
}

public class Class_33_Extends {

	public static void main(String[] args) {
		// PlusMinusCalculator pmc = new PlusMinusCalculator();
		Calculator cal = new Calculator();

		Scanner kb = new Scanner(System.in);

		// 입력과정...
		int n1, n2;
		System.out.print("1번째 정수를 입력 : ");
		n1 = kb.nextInt();
		System.out.print("2번째 정수를 입력 : ");
		n2 = kb.nextInt();
		// 부호 입력...
		char operator;
		System.out.print("부호를 입력하세요 : ");
		operator = kb.next().charAt(0);
		// 부호의 값에 따라서
		if (operator == '+') {
			// pmc.plus(n1, n2);
			cal.plus(n1, n2);
		} else if (operator == '-') {
			// pmc.minus(n1, n2);
			cal.minus(n1, n2);
		} else if (operator == '/') {
			// pmc.divide(n1, n2);
			cal.divide(n1, n2);
		} else if (operator == '*') {
			// pmc.multiple(n1, n2);
			cal.multiple(n1, n2);
		} else if (operator == '%') {
			// pmc.moduler(n1, n2);
			cal.moduler(n1, n2);
		}
	}
}
