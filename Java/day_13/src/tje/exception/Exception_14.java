package tje.exception;

// 메소드 오버라이딩
// 부모클래스의 메소드를 자식클래스에서 재정의하는 문법
// 규칙
// 1. 메소드의 원형이 동일해야 한다. (리턴값의 타입, 메소드명, 매개변수)
// 2. 접근지정자의 범위는 축소될 수 없다.
//	  (부모클래스의 레퍼런스를 사용하여 접근될 수 있기 때문에
//	      부모클래스의 래퍼런스가 인지하고 있는 접근범위를 축소할 수 없다.)
// 3. 부모클래스의 메소드에서 throws 하는 예외처리 클래스보다
//	    상위 클래스를 throws 할 수 없다.

class Super {
	public void print() throws NullPointerException {}
}

class Sub extends Super {
	// public void print() throws Exception {}
}

public class Exception_14 {

	public static void main(String[] args) {
		Super s = new Sub();
		
		s.print();
		// 부모클래스의 레퍼런스 변수가 인지하는 모습
		// NullPointerException e = s.print();
		// NullPointerException e = throws new NullPointerException();
		// 실제 실행되는 모습
		// 자식클래스의 레퍼런스가 부모클래스의 객체를 참조하는 형태가 되므로 
		// 자식클래스에서 오버라이딩하는 메소드는 부모클래스에서 throws 하는 
		// 예외클래스보다 상위클래스를 throws 할 수 없다.
		// NullPointerException e = throws new Exception();
	}

}
