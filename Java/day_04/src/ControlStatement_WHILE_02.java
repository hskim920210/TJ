import java.util.*;
public class ControlStatement_WHILE_02 {

	public static void main(String[] args) {
		// 사용자가 100을 입력할 때 까지 반복해서 입력받는 예제
		Scanner kb = new Scanner(System.in);
		
		// while 문을 사용한 무한루프 정의
		while ( true ) {
			System.out.print("프로그램을 종료하려면 100을 입력하세요 : ");
			if (kb.nextInt() == 100)
				break;
		}
		
		
		
		/*
		//System.out.print("프로그램을 종료하려면 100을 입력하세요 : ");
		while ( kb.nextInt() != 100 ) {
			System.out.print("프로그램을 종료하려면 100을 입력하세요 : ");
		}
		*/
		System.out.println("프로그램 종료");
		

	}

}
