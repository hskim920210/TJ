package tje.interface_;

// 부모 인터페이스
interface Inter_D {
	public abstract void test_1();
}

// 부모 클래스
abstract class Super_D {
	public abstract void test_2();
}

// 클래스와 인터페이스를 동시에 다중 상속 받을 수 있다.
// class 자식클래스명 extends 부모클래스명 implements 부모인터페이스명
class Sub_D extends Super_D implements Inter_D {
	public void test_1() {
	}

	public void test_2() {
	}

}

public class Interface_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
