package tje.interface_;

class Super_A {
}

class Super_B {
}

// 자바언어에서 제공하는 상속 기능은
// 단일 상속만을 지원합니다.
// 하나의 클래스는 하나의 부모 클래스를 가질 수 있습니다.
// (여러 개의 클래스를 상속할 수 없음)
// class Sub_A extends Super_A, Super_B {}

// 다중 상속을 지원하기 위한 인터페이스
// 인터페이스도 클래스 -> 제약이 있는 클래스 
// 인터페이스는 멤버 필드로 public static final 멤버만 가질 수 있습니다.
// 인터페이스는 멤버 메소드로 public abstract 메소드만 가질 수 있습니다.

//인터페이스의 정의 방법
//interface 인터페이스명 {
//	   멤버변수 ...(public static final)
//	   멤버메소드 ...(public abstract)
//}

interface Inter_A {
	// 일반 멤버필드의 선언이 제한됨
	// public int n1;

	// 생성자의 선언이 불가능.
//	public Inter_A() {
//		System.out.println("Inter_A 생성자 실행");
//	}

	// 일반 메소드의 선언이 제한됨
	// public void printInfo() {}

	// 인터페이스 내부에 선언할 수 있는 요소
	// 1. public static final 멤버변수
	public static final int num = 10;

	// 2. public abstract 멤버메소드
	public abstract void test();
}

// 인터페이스를 상속받는 클래스의 선언
// (인터페이스를 구현하는 클래스의 선언)
// class 자식클래스명 implements 부모인터페이스명 
class Sub_A implements Inter_A {
	@Override
	public void test() {
		System.out.println("Sub_A 클래스의 test 메소드 실행");		
	}
}

public class Interface_01 {
	public static void main(String[] args) {
		// 인터페이스는 객체를 생성할 수 없다.
		// 1. 생성자의 부재
		// 2. 추상메소드를 포함할 수 있어서 ...
		// Inter_A i = new Inter_A();
		
		// 상속을 통한 다형성 구현에만 인터페이스가 활용됨
		// 부모 인터페이스의 레퍼런스를 사용하여
		// 자식클래스의 객체를 참조
		Inter_A i = new Sub_A();
		// 부모 인터페이스의 레퍼런스를 사용하여
		// 자식 클래스의 오버라이딩 된 메소드를 호출
		i.test();

	}

}
