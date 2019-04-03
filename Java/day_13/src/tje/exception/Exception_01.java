package tje.exception;

// 예외(Exception) 처리
// 에러 : 잘못된 것, 에러가 존재하는 경우 실행될 수 없음
// 예외 : 잘못된 것, 
//  특정 상황 또는 조건이 만족되는 경우 프로그램이 종료되는 현상
// 예외는 다양한 상황에 대해서 발생하는 현상으로 모든 예외를 대처할 수 없음
// 다만, 예외가 발생한 경우 프로그램이 종료되지 않고 저장과 같은 기능을 제공
// 할 수 있어야함.
// (예외가 발생해도 프로그램이 강제종료되지 않고 사용자에게 선택권을 주어야함)

// 예외처리 : 예외가 발생한 경우 프로그램이 강제 종료되지 않도록 방지하는 것

import java.util.*;

public class Exception_01 {
	public static void main(String[] args) {
		// 예외가 발생할 가능성이 있는 코드.
		Scanner kb = new Scanner(System.in);
		
		System.out.print("1번째 정수 입력 : ");
		int n1 = kb.nextInt();
		System.out.print("2번째 정수 입력 : ");
		int n2 = kb.nextInt();
		
		// 모든 프로그래밍 언어는 나눗셈 연산 시, 
		// 0을 나누게 되면 예외가 발생한다.
		
		int result = n1 / n2;
		
		System.out.printf("%d / %d = %d\n", n1, n2, result);
		
		kb.close();
		
	}

}
