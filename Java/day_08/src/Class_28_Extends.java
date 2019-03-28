
class SuperA {
	private int n1;
	public int n2;
	// 디폴트 접근 지정자
	// 기본적으로는 public 처럼 동작
	int n3;
}
class SubA extends SuperA {
	public void printInfo() {
		// 부모 클래스의 private 멤버는 자식클래스에서 접근할 수 없는 멤버이다.
		// System.out.printf("n1 = %d\n", n1);
		// 부모 클래스의 public, 디폴트 접근 지정자로 선언된 멤버는 자식클래스에서 접근할 수 있는 멤버이다.
		System.out.printf("n1 = %d\n", n2);
		System.out.printf("n1 = %d\n", n3);
	}
}

public class Class_28_Extends {

	public static void main(String[] args) {
	}
}
