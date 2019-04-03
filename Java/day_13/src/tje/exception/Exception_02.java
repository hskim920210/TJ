package tje.exception;

import java.util.Scanner;

public class Exception_02 {

	public static void main(String[] args) {
		// 예외가 발생할 가능성이 있는 코드.
		Scanner kb = new Scanner(System.in);

		System.out.print("메세지를 입력하세요. (5글자 이상) : ");
		String msg = kb.next();

		if( msg.length() < 5 )
			msg = null;
		
		// java.lang.NullPointException 예외 발생 가능성이 있다.
		// 레퍼런스 변수에 null 값이 대입된 상태에서 접근 연산을 실행하는 경우 발생되는 예외
		System.out.printf("입력된 문자열의 길이는 %d 입니다.\n", msg.length());

		kb.close();

	}

}
