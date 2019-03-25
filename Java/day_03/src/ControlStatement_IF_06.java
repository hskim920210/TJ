import java.util.Scanner;

public class ControlStatement_IF_06 {

	public static void main(String[] args) {
		// 조건식이 다수개인 경우의 if문 활용방법
		Scanner keyboard = new Scanner(System.in);
		
		int menu;
		System.out.println("1.라면  2.김밥  3.만두");
		System.out.print("원하는 메뉴를 선택하세요 : ");
		menu = keyboard.nextInt();
		keyboard.close();
		
		// System.out.println(menu);
		
		// 사용자가 입력한 메뉴에 따라 동작을 변경
		// if 문을 사용하여 처리하는 경우 모든 조건식이 매번 비교된다. (앞의 if문에서 실행이 되어도 비교가 실행)
		if ( menu == 1 )
			System.out.println("라면 입력");
		if ( menu == 2 )
			System.out.println("김밥 입력");
		if ( menu == 3 )
			System.out.println("만두 입력");
		
		// 다수개의 조건식이 사용되는 경우의 if문
		/*
		if ( 1번째 조건식 )
		 	 1번째 조건식이 참일 경우 실행문
		else if ( 2번째 조건식 )
		 	 2번째 조건식이 참일 경우 실행문
		...
		else
			모든 조건식이 거짓일 경우의 실행문		  
		 */
		
		if ( menu == 1 )
			System.out.println("라면 입력");
		else if ( menu == 2 )
			System.out.println("김밥 입력");
		else if ( menu == 3 )
			System.out.println("만두 입력");


	}

}
