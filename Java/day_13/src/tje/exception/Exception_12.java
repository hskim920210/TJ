package tje.exception;

import java.util.*;

public class Exception_12 {

	public static void main(String[] args) throws Exception {
		Scanner kb = new Scanner(System.in);

		System.out.print("정수 입력 (10 이상만 입력) : ");
		int num = kb.nextInt();
		
		
		// 사용자가 10 미만의 값을 입력한 경우 강제로 예외를 방생시키는 예제
		if( num < 10 )
			throw new Exception("10 미만의 값이 입력되었습니다.");

		System.out.printf("입력된 정수는 %d 입니다.\n", num);

		kb.close();
		System.out.println("프로그램 종료");

	}

}
