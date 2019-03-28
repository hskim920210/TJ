// final 키워드
// 클래스, 멤버 메소드, 멤버 필드에 적용할 수 있는 키워드
// 제약에 관련된 기능을 제공하며, 적용되는 대상(클래스, 메소드, 필드)에 따라
// 차이가 있음.

// 1. 클래스에 final 키워드가 적용되는 경우
// - 상속이 금지되는 클래스의 선언 시 사용
final class FinalA {
}
// class FinalB extends FinalA {}

// 2. 메소드에 final 키워드가 적용되는 경우
// - 메소드 오버라이딩을 허용하지 않는 메소드의 선언 시 사용
// - 특정 클래스의 상속은 허용하되, 특정 메소드의 기능을 변경하지 못하도록
//   강제하는 경우에 사용
class FinalC {
	public final void finalMethod() {
	}
}

class FinalD extends FinalC {
	// public void finalMethod() {}
}

// 3. 멤버 필드에 final 키워드가 적용되는 경우
// - 상수의 속성을 가지는 변수를 생성하려는 경우에 사용됨.
// - 상수 : 값을 변경할 수 없는 변수
// - 주의사항 : final로 선언된 멤버필드는 반드시 초기화를
//   해야만 에러가 발생하지 않는다.
// - final 멤버필드의 초기화 방법
//		a. 변수의 선언 시 초기화 값을 대입하는 방법
//		b. 생성자 메소드에서 초기화 값을 대입하는 방법
class FinalE {
	// - 해당 클래스의 모든 객체들이 동일한 상수값을 가지게 됨
	// - 모든 객체가 동일한 상수 값을 참조하게 하는 경우
	// 일반적으로 static final 변수로 선언함
	// (메모리 낭비를 감소시키는 역할)
	// final int num1 = 10;
	static final int num1 = 10;
	final int num2;

	public FinalE(int num2) {
		// final 멤버 필드를 초기화 하는 경우
		// 변수의 선언과 동시에 값을 초기화 하는 방법
		// 또는 생성자 메소드에서 초기화 하는 방법 중
		// 하나만 선택해서 실행해야 한다.
		// this.num1 = 100;
		
		// - 생성자 메소드를 사용하여 final 변수를 초기화 하는 경우
		//   모든 객체들이 서로 다른 값을 가지는 상수를 사용할 수 있다.
		this.num2 = num2;
	}
	
	public void updateNum1(int num1) {
		// final 키워드가 적용된 멤버는 상수로 동작하기 때문에
		// 값을 수정할 수 없다.
		// this.num1 = num1;
	}
	
	public void updateNum2(int num2) {
		// final 키워드가 적용된 멤버는 상수로 동작하기 때문에
		// 값을 수정할 수 없다.
		// this.num2 = num2;
	}
	
}

public class Class_41_Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
