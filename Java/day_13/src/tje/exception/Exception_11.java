package tje.exception;

import java.util.*;

public class Exception_11 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		// nextInt 메소드는 입력된 데이터를
		// 정수로 변환하여 반환하는 메소드 입니다.
		// 이때, 정수 형태의 데이터가 아닌 경우
		// 강제로 예외를 발생시켜 프로그램을 종료하게 됩니다.
		// 예외는 사용자에 의해서 논리적인 판단에 의해
		// 강제로 발생시킬 수 있습니다.
		int num = kb.nextInt();

		System.out.printf("입력된 정수는 %d 입니다.\n", num);

		kb.close();
		System.out.println("프로그램 종료");

	}

}
