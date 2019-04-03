package tje.exception;

import java.util.*;

public class Exception_09 {

	public static void main(String[] args) {
		// 키보드 입력 작업을 처리하기 위환 Scanner 객체를 생성
		Scanner kb = new Scanner(System.in);

		String name; // 학생 이름
		int age; // 학생 나이

		try {
			System.out.print("이름을 입력하세요 : ");
			name = kb.next();
	
			System.out.print("나이를 입력하세요 : ");
			age = kb.nextInt();
	
			System.out.printf("이름 : %s, 나이 : %d 입니다.\n", name, age);
			
			// try 구문내부의 실행코드는 일반적으로 입출력에 관련된 작업이 많다.
			// 자바에서의 입출력은 스트림의 개념을 사용하고 있으며
			// 모든 입출력 작업 시, 스트림을 종료하는 코드가 필요하다.
			// 아래와 같이 try 영역에서 close 메소드를 호출하는 경우
			// 예외가 발생할 때 실행되지 못하는 문제가 있으므로
			// catch 절에서도 close를 실행해야 한다.
			
			// 예외가 발생하지 않은 경우 close 처리
			// kb.close();
			
		} catch(Exception e) {
			// 예외가 발생한 경우 close 처리
			// kb.close();
			e.printStackTrace();
		} finally {
			// 예외의 발생 여부와 관계없이 항상 실행되는 영역
			// 일반적으로 입출력에 관련된 스트림을 종료하는 코드를 작성.
			System.out.println("finally 실행");
			kb.close();
		}
		// Scanner 클래스를 활용하여 키보드 입력을 처리하는 경우
		// 반드시 사용한 이 후 close 메소드를 호출하여
		// 종료해야만 합니다.
		// kb.close();
		System.out.println("프로그램 종료");
	}

}
