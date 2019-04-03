package tje.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_06 {

	public static void main(String[] args) {
		// 예외가 발생할 가능성이 있는 코드.
		Scanner kb = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		
		// try 영역에서 생성된 변수는 try 구문이 종료된 후 접근할 수 없다.
		// try 구문이 정상적으로 종료한 경우 짝수/홀수를 출력하기 위해 변수를 선언
		// try 구문 내부에서 초기화 하는 코드는 실행되지 않을 가능성이 있기 때문에 초기화를 진행
		int num = 0;
		
		try {
			num = kb.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("InputMismatchException 예외가 발생하여 처리함");
			System.out.println("프로그램 종료");
			return;
		}
		
		if( num % 2 == 0 )
			System.out.println("짝수입니다.");
		else 
			System.out.println("홀수입니다.");

		System.out.println("프로그램 종료");
		kb.close();

	}

}
