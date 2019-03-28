// static 메소드
// static 멤버 필드와 같이 프로그램의 구동전에 메모리에 로딩되어
// 객체의 생성없이 클래스의 이름을 사용해 호출할 수 있는 메소드

// 1. 간단한 공용기능을 제공하기 위해서(Math 클래스)
// 2. private 접근지정자가 선언된 static 멤버를 초기화하기 위해서

class StaticD {
	// 외부에서의 접근이 차단된 static 멤버필드
	private static int ARRAY_SIZE = 17;

	// private 으로 정의된 static 멤버를 참조하기 위한 static 메소드
	public static int getARRAY_SIZE() {
		return ARRAY_SIZE;
	}
}

public class Class_22_Static {
	public static void main(String[] args) {
		// private 으로 정의된 static 멤버는 외부에서의 참조가 허용되지 않는다.
		// System.out.printf("배열의 크기 : %d\n", staticD.ARRAY_SIZE);

		// static 메소드는 객체의 생성없이 클래스의 이름으로
		// 사용할 수 있는 메소드
		// private static 멤버의 값을 반환받는 예제
		System.out.printf("배열의 크기 : %d\n", StaticD.getARRAY_SIZE());

	}
}
