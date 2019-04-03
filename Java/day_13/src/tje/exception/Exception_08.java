package tje.exception;

// 예외(Exception) 처리
// try 영역 내부의 실행코드에서 
// 서로 다른 다수 개의 예외가 발생할 가능성이 있는 경우

/*
	 try { 
	 	예외가 발생할 가능성이 있는 코드
	 } catch(첫번째 예외처리 클래스명) {
	 	첫번째 예외처리 클래스 타입의 예외가 발생한 경우의 실행코드
	 } catch(두번째 예외처리 클래스명) {
	 	두번째 예외처리 클래스 타입의 예외가 발생한 경우의 실행코드
	 } catch(Exception e) {
	   	// Exception 클래스는 모든 예외처리 클래스의 최상위 부모클래스
		앞서 선언한 catch 구문에서 처리할 수 없는 예외가 발생한
		경우 처리할 실행코드
	 } 
*/

import java.util.*;

public class Exception_08 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n1, n2, result;

		try {
			// 잘못된 형식의 입력이 들어올 가능성이 있는 코드
			System.out.print("1번째 정수를 입력하세요 : ");
			n1 = kb.nextInt();
			
			if( n1 > 10 )
				kb.close();
			
			System.out.print("2번째 정수를 입력하세요 : ");
			n2 = kb.nextInt();

			// /0 의 위험성이 있는 코드
			result = n1 / n2;
			System.out.printf("%d / %d = %d\n", n1, n2, result);
		} catch (InputMismatchException e) {
			System.out.println("잘못된 형식의 입력이 들어옴");
		} catch (ArithmeticException e) {
			System.out.println("수학 연산에서 문제가 발생함");
		} catch (Exception e) {
			// Exception 클래스는 모든 예외처리 클래스의 최상위 부모클래스
			// 앞서 선언한 catch 구문에서 처리할 수 없는 예외가 발생한
			// 경우 처리할 실행코드
			System.out.println("예상하지 못한 예외가 발생하여 처리함");
			
			// 예외처리 클래스의 메소드
			// 1. getMessage 메소드
			// - 현재 발생한 예외에 관련된 설명을 문자열로 반환
			// - 예외의 타입에 따라 메세지가 제공되지 않을 수도 있다. (null 값이 반환될 수 있다.)
			// System.out.printf("Exception Message : %s\n", e.getMessage());
			
			// 2. printStackTrace 메소드
			// - 현재 발생된 예외의 발생 과정을 스택구조로 출력하는 메소드
			// - 일반적으로 예외를 처리하지 않았을 때 출력되는 문장과 동일
			// - 디버깅 시, 예외의 발생 과정을 추적하고자 하는 경우 사용됨.
			// e.printStackTrace();
			
			// 3. getClass 메소드
			// - 예외가 발생할 클래스의 타입을 반환
			System.out.printf("Exception Type : %s\n", e.getClass().getName());
		}
		kb.close();
		System.out.println("프로그램 종료");

	}

}
