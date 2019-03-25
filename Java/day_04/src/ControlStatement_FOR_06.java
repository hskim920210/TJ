import java.util.*;

public class ControlStatement_FOR_06 {

	public static void main(String[] args) {
		// 사용자가 100을 입력할 때 까지 계속 입력을 받기
		// 100이 입력되면 프로그램 종료

		// 1. 입력
		Scanner kb = new Scanner(System.in);

		// 2. 처리
		/*
		 * for( int in = 0 ; in != 100 ; ) { System.out.print("정수를 입력하세요 : "); in =
		 * kb.nextInt(); }
		 */

		// 아래와 같이 for 문의 조건식 영역을 작성하지 않는 경우 종료하지 않는 방복문을 만들 수 있다. (무한루프)
		for (int in;;) {
			System.out.print("정수를 입력하세요 : ");
			if ((in = kb.nextInt()) == 100) {
				// 키보드에서 입력된 정수가 100과 같은 경우 break를 실행하여 반복문을 빠져나감
				break;
			}
		}
		// 3. 출력 및 저장
		System.out.println("프로그램 종료");

	}
}
