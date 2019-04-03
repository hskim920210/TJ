package tje.exception;

// 예외(Exception) 처리 방법
// try {
//		예외가 발생할 가능성이 있는 실행 코드 ...
// } catch(예외클래스명 변수명) {
//		예외가 발생할 경우의 실행 코드 ...
// }

// try 영역에 선언된 실행문에서 예외가 발생하지 않는 경우 
// catch 구문은 실행되지 않습니다.
// 하지만 예외가 발생한 경우 try 영역을 더이상 실행하지 않고
// 즉시 catch 구문으로 이동하게 됩니다.
// 발생된 예외의 종류가 catch 절에 선언된 클래스와 동일하다면
// 해당 catch 절이 실행되면서 정상적으로 프로그램이 진행됩니다.
// 만약 catch 절에 선언된 예외클래스가 발생된 예외가 다르다면
// 예외를 처리할 수 없어 프로그램이 강제 종료됩니다.

import java.util.*;

public class Exception_04 {
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("1번째 정수 입력 : ");
		int n1 = kb.nextInt();
		System.out.print("2번째 정수 입력 : ");
		int n2 = kb.nextInt();
		
		try {
			
			// 예외가 발생할 가능성이 있는 코드.
			// 모든 프로그래밍 언어는 나눗셈 연산 시, 
			// 0을 나누게 되면 예외가 발생한다.
			int result = n1 / n2;
			System.out.printf("%d / %d = %d\n", n1, n2, result);
			
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException 타입의 예외가 발생하여 처리함");
		}
		
		System.out.println("프로그램 종료");
		kb.close();
		
	}

}
