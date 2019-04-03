package tje.exception;

import java.util.Scanner;

public class Exception_03 {

	public static void main(String[] args) {
		// 예외가 발생할 가능성이 있는 코드.
		Scanner kb = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int num = kb.nextInt();

		if( num % 2 == 0 )
			System.out.println("짝수입니다.");
		else 
			System.out.println("홀수입니다.");

		kb.close();

	}

}
