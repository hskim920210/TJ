
// 기본입력(키보드 입력)을 처리하는 방법

// 키보드 입력을 처리하기 위한 선언문
import java.util.Scanner;

public class ControlStatement_IF_04 {

	public static void main(String[] args) {
		// 키보드 입력을 위한 변수를 선언
		// Scanner 의 변수 사용. sc는 아무거나 써도 괜찮음
		Scanner sc = new Scanner(System.in);
		
		int intNumber;
		System.out.print("정수를 입력하세요 : ");
		// Scanner 클래스의 nextInt 메소드
		// 입력된 정수를 int 타입으로 반환하는 메소드
		intNumber = sc.nextInt();
		System.out.printf("intNumber -> %d\n", intNumber);
		
		double doubleNumber;
		System.out.print("실수를 입력하세요 : ");
		// Scanner 클래스의 nextDouble 메소드
		// 입력된 실수를 double 타입으로 반환하는 메소드
		doubleNumber = sc.nextDouble();
		System.out.printf("doubleNumber -> %.3f\n", doubleNumber);
		
		String strName;
		System.out.print("이름을 입력하세요 : ");
		// Scanner 클래스의 next 메소드
		// 입력된 문자열을 String 타입으로 반환하는 메소드. 한글을 입력할 때 다 입력 후 클릭한번 해줘야 정상작동.
		strName = sc.next();
		System.out.printf("이름 -> %s\n", strName);
		
		char chGender;
		System.out.print("성별를 입력하세요(M/W) : ");
		// 문자를 입력받는 방법
		// Scanner 클래스의 next 메소드를 사용해서 문자열 입력받는다. 그리고 입력된 문자열에서 가장 앞의 한 글자를 추출하여 변수에 대입할 수 있다.
		// String 클래스의 charAt 메소드
		// 매개변수로 전달된 위치의 문자값을 반환
		// 0인 경우 가장 앞의 글자를 의미
		chGender = sc.next().charAt(0);
		System.out.printf("성별 -> %c\n", chGender);
		
		
		if( chGender == 'M' )
			System.out.println("남성");
		if( chGender == 'W' )
			System.out.println("여성");
		
		
		
		
		
		
		
		

	}

}
