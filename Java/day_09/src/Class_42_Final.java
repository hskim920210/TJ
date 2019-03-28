import java.util.Scanner;

class Color {
	public static final int WHITE = 1;
	public static final int BLUE = 2;
	public static final int RED = 3;
	
}

class SharedInfo {
	public static final int ARRAY_SIZE = 100;
}

public class Class_42_Final {
	public static void main(String[] args) {
		// 공용변수로 사용하기 위해 static 변수를 사용하는 예제
		int [] array = new int[SharedInfo.ARRAY_SIZE];
		// final 키워드를 추가하여 공용변수의 값이 변경되는 것을 방지
		// SharedInfo.ARRAY_SIZE = 1;
		
		Scanner kb = new Scanner(System.in);
		int input;
		
		System.out.println("1. 하얀색");
		System.out.println("2. 파란색");
		System.out.println("3. 빨간색");
		System.out.print("색상을 선택하세요 : ");
		input = kb.nextInt();
		
		// static final 멤버를 사용하여 switch문을 작성하는 예제
		// 단순 정수를 사용하는 경우보다 의미를 명확하게 전달할 수 있다.
		switch ( input ) {
			// case 1: break;
			case Color.WHITE : break;
			// case 2: break;
			case Color.BLUE : break;
			// case 3: break;
			case Color.RED : break;
			default:
			
		}
	}

}
