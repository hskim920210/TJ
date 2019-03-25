
// if 문 : 조건식의 결과에 따라 실행문의 실행을 제어
// switch 문 : 정수 또는 정수를 반환하는 식의 결과를 사용하여 실행문을 분기하는 방법
/*
	switch( 정수/정수를 반환하는 식/변수 ) {
		case 값1 : // if ( 입력값 == 값1 ) 
			실행문;
			break;
		case 값2 : // else if ( 입력값 == 값2 )
			실행문;
			break;
		...
		default : // else
			실행문;
	}
*/

import java.util.Scanner;

public class ControlStatement_SWITCH_02 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int menu;
		System.out.println("1.라면  2.김밥  3.만두");
		System.out.print("원하는 메뉴를 선택하세요 : ");
		menu = kb.nextInt();
		kb.close();
		
		switch ( menu ) {
			// menu변수의 값이 1인 경우 실행되는 영역
			case 1: // if ( menu == 1 )
				System.out.println("오늘의 라면은 신라면");
				break;
			// menu변수의 값이 2인 경우 실행되는 영역
			case 2: // else if ( menu == 2 )
				System.out.println("오늘의 김밥은 치즈김밥");
				break;
			// menu변수의 값이 3인 경우 실행되는 영역
			case 3: // else if ( menu == 3 )
				System.out.println("오늘의 만두는 갈비만두");
				break;
			// menu변수의 값이 모든 case에 해당되지 않는 경우 실행되는 영역
			default : // else
				System.out.println("잘못된 번호를 선택했습니다.");
		}

	}

}
