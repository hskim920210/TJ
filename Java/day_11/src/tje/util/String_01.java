package tje.util;

public class String_01 {

	public static void main(String[] args) {
		// String 클래스
		// 문자열의 값을 저장하기 위해 사용되는 클래스 중 하나
		// 문자열의 참조값을 사용하여 문자열 값을 저장하는 방식을 사용

		// String 클래스의 특징
		// 불변객체 : 저장하고 있는 문자열을 수정할 수 없는 타입
		// 단순히 문자열 값을 참조만 할 수 있는 타입.

		// String 클래스의 객체 생성 방법
		// 1. String 변수명 = 문자열값;

		// 단순히 문자열의 대입은 상수공간을 참조

		// - 문자열 상수의 값을 참조하는 방식
		// - 아래의 두 변수는 동일한 상수 영역의 문자열을 참조
		String str1 = "Hello";
		String str2 = "Hello";

		// 동일한 영역을 참조하는 변수이므로
		// 비교연산자를 통해서도 같음을 확인할 수 있다.
		if (str1 == str2)
			System.out.println("str1 변수와 str2 변수는 같습니다.");
		else
			System.out.println("str1 변수와 str2 변수는 다릅니다.");

		// 문자열이 연산될 때 새로 메모리에 만들어 참조값만 반환시켜줌
		// String 타입의 객체에 변형이 일어나는 경우 ( 문자열 결합과 같은 연산 )
		// 기존의 문자열을 수정하지 않고 새로운 공간에
		// 변형된 문자열을 저장한 후 새롭게 생성된 문자열을 참조한다.
		str1 = str1 + "~!";
		// str1 과 동일한 공간을 참조하지 않고
		// 새롭게 ~! 문자열을 저장한 영역을
		// 생성한 후, str2에 대입
		str2 = str2 + "~!";

		// str1 변수와 str2 의 레퍼런스 값이 변경되었으므로
		// == 의 결과는 false가 됨.
		if (str1 == str2)
			System.out.println("str1 변수와 str2 변수는 같습니다.");
		else
			System.out.println("str1 변수와 str2 변수는 다릅니다.");
		
		
		
		System.out.println(str1);
		System.out.println(str2);
		
		// 서로 다른 공간을 참조하지만
		// 실제 문자열의 내용은 동일하므로
		// equals 메소드의 결과는 true
		if (str1.equals(str2))
			System.out.println("str1 변수와 str2 변수는 같습니다.");
		else
			System.out.println("str1 변수와 str2 변수는 다릅니다.");
	}

}
