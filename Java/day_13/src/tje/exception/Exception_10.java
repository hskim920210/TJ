package tje.exception;

import java.util.*;

public class Exception_10 {

	public static void main(String[] args) {

		String name;
		int age;

		// 리소스의 자동해제를 위한 문법( JDK 1.8 이상에서만 가능 )
		// 일반적으로 예외처리에는 입출력에 관련된 작입이 많음
		// 매번 finally 영역을 통해서 리소스를 해제하는 과정이
		// 번거롭기 때문에
		// try (입출력에 사용할 변수) 와 같이 리소스를 선언하는 경우
		// try 영역을 빠져나가는 순간 자동으로 close 메소드를 호출합니다.
		try (Scanner kb = new Scanner(System.in) ; Scanner kb1 = new Scanner(System.in)) {

			System.out.print("이름을 입력하세요 : ");
			name = kb.next();

			System.out.print("나이를 입력하세요 : ");
			age = kb.nextInt();

			System.out.printf("이름 : %s, 나이 : %d 입니다.\n", name, age);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("프로그램 종료");
	}

}
