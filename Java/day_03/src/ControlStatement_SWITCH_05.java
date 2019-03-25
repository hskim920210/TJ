import java.util.Scanner;

public class ControlStatement_SWITCH_05 {

	public static void main(String[] args) {
		// 사용자에게 1~12 사이 정수를 입력받으세요.
		// 입력된 정수에 해당되는 월의 날자 수를 출력하세요.
		// EX) 1~12월 중 하나를 입력하세요 : 5
		//		입력된 5월은 '31'일 까지 있습니다.
		// switch문 사용
		
		Scanner kb = new Scanner(System.in);
		
		int a, b;
		System.out.print("1~12월 중 하나를 입력하세요 : ");
		a = kb.nextInt();
		kb.close();
		
		
		
		// 31일인 달  : 1 3 5 7 8 10 12, 28인 달 : 2, 나머지는 30일
		switch (a) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
				b = 31;
				break;
			case 4:	case 6:	case 9:	case 11:	
				b = 30;
				break;
			case 2:
				b = 28;
				break;
			default:
				b = -1;
				break;
		}
		
		if ( b != -1 )
			System.out.printf("입력된 %d월은 '%d'일 까지 있습니다.\n", a, b);
		else
			System.out.printf("(ERROR) 1~12 사이의 정수만 입력하세요. (%d)\n", a);

	}

}
