import java.util.*;

public class ControlStatement_DO_WHILE_03 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		do {
			System.out.print("프로그램을 종료하려면 100을 입력하세요 : ");
		} while (kb.nextInt() != 100);
		System.out.println("프로그램 종료");

		// 아래 코드를 위에처럼 do ~ while로 바꿔서 사용 가능
		/*
		   System.out.print("프로그램을 종료하려면 100을 입력하세요 : "); 
		   while ( kb.nextInt() != 100 )
		       { System.out.print("프로그램을 종료하려면 100을 입력하세요 : "); }
		   System.out.println("프로그램 종료");
		 */
	}
}