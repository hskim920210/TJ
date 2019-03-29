package tje.interface_;

// 인터페이스 간의 상속
// 인터페이스는 부모 인터페이스를 선언할 수 있다.
// interface 자식인터페이스 extends 부모인터페이스1, 부모인터페이스2, ...

interface Inter_Super_A {
	public abstract void test_1();
}
interface Inter_Super_B{
	public abstract void test_2();
}

// 인터페이스는 다중 상속이 가능하다.
// 인터페이스를 상속받는 자식인터페이스는 부모인터페이스의 
// 추상메소드를 포함하고 있다.
interface Inter_Sub extends Inter_Super_A, Inter_Super_B {
	public abstract void test_3();
}

// 인터페이스 간 상속을 구현하고 있는 인터페이스를
// 클래스에서 구현하는 경우 부모 인터페이스의
// 추상메소드를 포함하여 오버라이딩을 구현해야 한다.
class Inter_Sub_Class_1 implements Inter_Sub {
	public void test_1() {}
	public void test_2() {}
	public void test_3() {}
}

public class Interface_03 {
	public static void main(String[] args) {
		// 자식 클래스의 객체 생성
		Inter_Sub_Class_1 obj = new Inter_Sub_Class_1();
		
		// 부모 인터페이스의 레퍼런스 변수를 사용하여
		// 자식클래스의 객체를 참조
		Inter_Super_A a = obj;
		Inter_Super_B b = obj;
		Inter_Sub s = obj;
		
		// 각 부모 인터페이스의 레퍼런스 변수는
		// 해당 인터페이스에 선언된 멤버에만 접근이 가능하다.
		
		a.test_1();     // a.test_2(); a.test_3();
		b.test_2();     // b.test_1(); b.test_3();
		s.test_1();		s.test_2();		s.test_3();
	}
}
