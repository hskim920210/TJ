package tje.inner;

// 클래스의 선언 형태
// 1. 일반적인 클래스의 선언
//	- 파일 내부에 class 키워드를 사용하여 클래스를 선언
// 2. 익명(무명)
//	- 이름이 없는 클래스
// 3. 중첩클래스
//	- 다른 클래스의 내부에 선언되는 클래스

// 2개의 추상메소드를 포함하고 있는 부모클래스.
abstract class Inner_A { // 이걸 상속받는 애들은 무조건 밑에 메소드를 오버라이딩해야된다.
	public abstract void plus(int n1, int n2);

	public abstract void minus(int n1, int n2);
}

// 자식 클래스의 선언과 추상 메소드의 오버라이딩을 구현 
class Inner_Sub_A extends Inner_A {

	public void plus(int n1, int n2) {
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
	}

	public void minus(int n1, int n2) {
		System.out.printf("%d + %d = %d\n", n1, n2, n1 - n2);
	}

}

public class InnerClass_01 {

	public static void main(String[] args) {
		Inner_A a1 = new Inner_Sub_A();
		a1.plus(10, 7);
		a1.minus(10, 7);

		// 익명 클래스 또는 무명 클래스
		// 객체를 생성하면서 오버라이딩을 구현하는 클래스
		// 일반클래스, 추상클래스, 인터페이스 모두에 적용이 가능합니다.
		// 인터페이스나 추상클래스 타입의 객체를 생성하면서
		// 추상 메소드를 오버라이딩 할 수 있습니다.
		// '간단한 로직의 메소드 오버라이딩 이라면'
		// 클래스를 새롭게 만드는 것에 비해 코드 작성의
		// 효율을 높일 수 있습니다. 

		Inner_A a2 = new Inner_A() {
			public void plus(int n1, int n2) {
				System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
			}
			public void minus(int n1, int n2) {
				System.out.printf("%d - %d = %d\n", n1, n2, n1 - n2);
			}
		};
		a2.plus(100,70);
		a2.minus(100,70);
		
	}

}
