package package_1;

// 동일한 패키지 내부의 클래스들은
// 서로 간의 참조가 가능하다.

public class Package_03 {

	public static void main(String[] args) {
		// 동일한 패키지 내부의 클래스를 사용하여 객체를 생성하는 코드
		Package_02_Resource resource = new Package_02_Resource();

		// private 멤버는 클래스의 외부 접근이 제한된다.
		// resource.n1 = 10;
		
		// public 멤버는 위치에 상관 없이 멤버에 접근할 수 있다.
		resource.n2 = 20;
		
		// 디폴트 접근지정자가 선언된 멤버는
		// 동일한 패키지의 클래스에서는 public처럼 접근할 수 있다.
		resource.n3 = 30;
		
	}

}
