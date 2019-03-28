// 클래스의 상속 문법
// 다수개의 클래스들이 중복되는 멤버필드, 멤버메소드를 포함하고 있는 경우
// 부모-자식 관계를 생성하여 코드의 중복을 방지할 수 있는 문법
// 코드의 재활용 방법(클래스에서 활용할 수 있는 재활용 방법)

// 코드의 중복이 발생하고 있는 클래스
/*
class Person_A {
	String name;
	int age;
	String address;
	String tel;
}

class Person_B {
	String name;
	int age;
	String address;
	String tel;
}
*/

// 코드의 중복이 발생하고 있는 클래스에서
// 중복되는 멤버들을 별도의 클래스로 선언한 후,
// 관계를 비교( is a, has a )
// is a 관계가 만족하는 경우 상속을 구현
// has a 관계가 만족하는 경우 멤버필드로 구현

// 중복되는 코드를 제거하기 위한 부모클래스의 정의
class Person {
	String name;
	int age;
	String address;
	String tel;
}

//상속을 구현한 자식클래스의 선언
//상속을 구현하는 방법
//class 자식클래스명 extends 부모클래스명

class Person_A extends Person {
}

class Person_B extends Person {
}

public class Class_26_Extends {

	public static void main(String[] args) {
		Person_A a = new Person_A();
		Person_B b = new Person_B();

		// 자식클래스는 부모클래스로부터 상속받은
		// 멤버를 사용할 수 있습니다.
		System.out.println(a.name);
		System.out.println(b.address);
	}

}
