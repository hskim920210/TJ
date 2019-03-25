import java.util.Scanner;

public class ControlStatement_SWITCH_03 {

	public static void main(String[] args) {
		// 사용자에게 1~10사이의 정수를 입력받으세요
		// 입력된 정수부터 10 사이의 정수를 모두 출력하세요.
		// switch문을 사용하세요
		// <예시> 1~10 사이의 정수 입력을 5 => <5, 6, 7, 8, 9, 10> 출력
		Scanner kb = new Scanner(System.in);
		int a;
		System.out.println("1 ~ 10 사이의 정수를 입력하세요.");
		a = kb.nextInt();
		kb.close();
		
		String result = "<";
		
		switch(a) {
			case 1:
				result += "1, "; // result = result + "1, ";
			case 2:
				result += "2, "; 
			case 3:
				result += "3, "; 
			case 4:
				result += "4, "; 
			case 5:
				result += "5, "; 
			case 6:
				result += "6, "; 
			case 7:
				result += "7, "; 
			case 8:
				result += "8, "; 
			case 9:
				result += "9, "; 
			case 10:
				result += "10>"; 
				break;
			default :
				result += " ERROR : 잘못된 정수 >";
		}
		
		System.out.println(result);		
		
	
		/*		
		switch ( a ) {
			case 1:
				System.out.printf("<%d, %d, %d, %d, %d, %d, %d, %d, %d, %d>", a, ++a, ++a, ++a, ++a, ++a, ++a, ++a, ++a, ++a);
				break;
			case 2:
				System.out.printf("<%d, %d, %d, %d, %d, %d, %d, %d, %d>", a, ++a, ++a, ++a, ++a, ++a, ++a, ++a, ++a);
				break;
			case 3:
				System.out.printf("<%d, %d, %d, %d, %d, %d, %d, %d>", a, ++a, ++a, ++a, ++a, ++a, ++a, ++a);
				break;
			case 4:
				System.out.printf("<%d, %d, %d, %d, %d, %d, %d>", a, ++a, ++a, ++a, ++a, ++a, ++a);
				break;
			case 5:
				System.out.printf("<%d, %d, %d, %d, %d, %d>", a, ++a, ++a, ++a, ++a, ++a);
				break;
			case 6:
				System.out.printf("<%d, %d, %d, %d, %d>", a, ++a, ++a, ++a, ++a);
				break;
			case 7:
				System.out.printf("<%d, %d, %d, %d>", a, ++a, ++a, ++a);
				break;
			case 8:
				System.out.printf("<%d, %d, %d>", a, ++a, ++a);
				break;
			case 9:
				System.out.printf("<%d, %d>", a, ++a);
				break;
			case 10:
				System.out.printf("<%d>", a);
				break;
				
				default :
					System.out.println("숫자를 잘못입력하였습니다.");
					break;				
		}
		*/
		

	}

}
