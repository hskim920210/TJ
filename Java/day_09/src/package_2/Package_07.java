package package_2;

import package_1.Package_06_Resource;

// 다른 패키지의 클래스를 상속하여 사용할 수 있다.
public class Package_07 extends Package_06_Resource {

	public void printInfo() {
		// private 멤버는 클래스의 외부 접근이 제한됩니다.
		// 상속과계를 구현하고 있는 경우에도 접근이 제한됨
		// n1 = 10;

		// public 멤버는 위치에 상관없이 멤버에 접근할 수 있습니다.
		n2 = 20;

		// 디폴트 접근지정자가 선언된 멤버는
		// 서로 다른 패키지의 클래스에서는 private으로 동작합니다.
		// n3 = 30;

		// 부모클래스의 protected 멤버는
		// 자식클래스에서 public 으로 동작합니다.
		// (다른 패키지의 자식클래스에서도 동일)
		n4 = 40;

	}

}
