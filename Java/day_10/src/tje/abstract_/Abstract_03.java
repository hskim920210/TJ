package tje.abstract_;

// 추상 클래스는 추상 메소드를 포함할 수 있는 클래스
// 추상 클래스는 일반 클래스와 동일하게 일반 멤버변수
// 일반 메소드, 생성자 등을 포함할 수 있습니다.
// 단, 추상 메소드를 포함할 수 있는 특징이 추가된 클래스입니다.

abstract class Abstract_A {
	public int n1;
	private int n2;
	int n3;
	protected int n4;

	public Abstract_A() {
		System.out.println("추상클래스 Abstract_A의 생성자 실행");
	}

	public void printInfo() {
		System.out.println("Abstract_A 클래스의 printInfo 메소드 실행");
	}
}

public class Abstract_03 {
	public static void main(String[] args) {

		// 추상 클래스는 추상메소드를 포함하고 있지 않아도,
		// 객체를 생성할 수 없습니다.
		// 추상클래스는 상속을 통한 다형성 구현을 위해서
		// 사용됩니다.
		// Abstract_A a = new Abstract_A();
	}
}
