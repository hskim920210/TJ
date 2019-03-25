import java.util.Scanner;
public class Array_03 {

	public static void main(String[] args) {
		// HEAP 메모리 영역
		// 프로그램의 구동 중 동적으로 생성되는 변수들이 저장되는 영역
		
		// HEAP 메모리 영역은 new 연산자를 통해 사용할 수 있다.
		// new : 클래스의 객체, 배열 객체를 생성할 때 사용하는 연산자. 오른쪽에 있는애를 동적으로 만들어주는 명령
		// kb.nextInt() 에서 .은 힙메모리에있는 주소를 참조하라는 뜻
		
		// 1. 동적으로 생성되는 변수를 저장 ( 배열, 클래스의 변수들 )
		// 2. 초기화가 지원 ( 0, 0.0, false, null )
		// 3. 메모리의 자동해제 지원
		//  - 언제 해제가 되는지 결정할 수 없음
		//  - 가비지컬렉터 ( HEAP 메모리에 저장된 사용되지 않는 변수들을 수거하는 역할 )
		//  - 가비지컬렉터의 스케쥴링 정책에 따라서 자동 해제됨
		//  - System.gc(); 는 가비지컬렉터를 실행하는 코드이다.
		//  - 가비지컬렉터에 의해서 수거되는 변수는 어떠한 어디에서도 참조되지 않는 변수
		Scanner kb = new Scanner(System.in);
		
		// 레퍼런스 변수
		// - 클래스, 배열 타입의 변수
		// - 레퍼런스 변수는 HEAP 메모리를 참조하는 변수
		// - 일반 자료형(int, double)과 다르게 실제 값이 아닌 HEAP 메모리의 참조값을 저장하는 변수
		
		// HEAP 메모리에 변수를 생성하는 방법
		// new 연산자를 사용하여 메모리 공간을 할당할 수 있다.
		// 레퍼런스변수명 = new 생성할타입();
		
		
		// String 클래스 타입의 레퍼런스 변수 s1, s2변수를 선언한 후 각각 HEAP 메모리에 HELLO 문자열을 저장한 후 참조값을 전달
		String s1 = new String("Hello"); // => "Hello"가 있는 HEAP 메모리의 번지가 s1로 들어감.
		String s2 = new String("Hello");
		
		System.out.printf("s1 = %s, s2 = %s\n", s1, s2);
		
		// 위에 선언된 String 클래스의 s1, s2는 각각 생성된 문자열의 참조값을 저장하고 있는 레퍼런스 변수입니다.
		// s1, s2는 서로 다른 위치를 참고하고 있기 때문에 비교 연산자 == 을 사용하면 false를 반환한다.
		if (s1 == s2) { // s1과 s2가 갖고있는 메모리 번지수가 같냐고 판단
			System.out.println("EQUAL~!");
		} else {
			System.out.println("NOT EQUAL~!");
		}
		
	
		
		// String 클래스의 레퍼런스를 사용해서 실제 문자열이 동일한지 비교하기 위해 사용하는 equals 메소드
		if (s1.equals(s2)) {  
			System.out.println("EQUAL~!");
		} else {
			System.out.println("NOT EQUAL~!");
		}

		
		// 레퍼런스 변수의 초기화
		// 레퍼런스 변수는 HEAP 메모리의 참조값 또는 null 값으로 초기화를 할 수 있다.
		String s3 = null;
		
		// null 값은 레퍼런스 변수를 초기화할 때 사용하는 값으로 다른 위치를 참조하고 있지 않은 경우 사용된다.
		
		// null 값은 비교의 대상이 될 수 있다.
		if ( s3 == null ) {
			System.out.println("s3 변수는 문자열이 할당되지 않았습니다.");
		} else {
			System.out.println(s3);
		}

		// 레퍼런스 변수가 null 값을 가지는 경우 접근 연산자를 사용할 수 없다.
		// (NullPointException이 발생)
		System.out.println(s3.equals(s1));
		
	}

}
