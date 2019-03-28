package package_2;

// 서로 다른 패키지에 작성된 클래스들은 참조될 수 없다.


// 만약 다른 패키지에 작성된 클래스를 사용하려는 경우
// import 선언을 사용하여 해당 클래스에 접근할 수 있습니다.
// import 패키지명.사용할클래스명;

import package_1.Package_02_Resource;

// 특정 패키지 내부에 모든 클래스를 접근하려는 경우
// * 를 사용하여 선언할 수 있다.
// import 패키지명.*;

public class Package_04 {

	public static void main(String[] args) {
		Package_02_Resource resource = new Package_02_Resource();

		// private 멤버는 클래스의 외부 접근이 제한된다.
		// resource.n1 = 10;
		
		// public 멤버는 위치에 상관없이 멤버에 접근할 수 있다.
		resource.n2 = 20;
		
		// 디폴트 접근지정자가 선언된 멤보는
		// 서로 다른 패키지의 클래스에서는 private으로 동작한다.
		// resource.n3 = 30;
	}

}
