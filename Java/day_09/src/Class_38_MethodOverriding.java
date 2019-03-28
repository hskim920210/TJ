// 메소드 오버로딩
// 1. 메소드의 이름이 동일해야 합니다.
// 2. 메소드의 메소드의 매개변수의 타입, 개수, 순서가 다를 경우
//    같은 이름의 메소드라도 다른 메소드로 인식합니다.

// 메소드 오버라이딩
// 1. 상속관계에서만 사용할 수 있습니다.
// 2. 부모클래스의 메소드의 원형과 반드시 일치해야 합니다.
//    (리턴값의타입, 메소드이름, 매개변수)
// 3. 접근지정자는 축소될 수 없습니다.( 다형성의 구현때문에... )
// 4. 예외처리 클래스를 상위클래스로 정의할 수 없습니다.
// 5. 부모클래스의 final로 정의된 메소드는 오버라이딩 할 수 없습니다. 
class Animal_3 {
	public void sound() {
		System.out.println("소리를 냅니다.");
	}
}

class Dog_3 extends Animal_3 {
	// 메소드 오버라이딩의 구현
	// 접근범위는 축소될 수 없다.
	// 부모클래스의 메소드가 public 으로 선언된 경우
	// 자식 클래스에서 오버라이딩을 할 때
	// 반드시 public 으로 선언해야함
	public void sound() {
		// super 키워드를 사용한 부모클래스의 메소드 호출
		// 메소드 오버라이딩을 구현하는 경우 
		// 부모 클래스의 메소드는 가려진다.
		// 만약, 자식클래스에서 부모클래스의 오버라이딩된
		// 메소드를 호출하려는 경우 super.메소드명() 으로 실행할 수 있다.
		
		super.sound();
		
		System.out.println("멍 ~ 멍 ~ !");
	}
}

class Cat_3 extends Animal_3 {
	// 메소드 오버라이딩의 구현
	public void sound() {
		System.out.println("야용 ~ !");
	}
	// 메소드 오버로딩
	public void sound(int i) {
		System.out.println("야용 ~ !");
	}
	// 부모클래스의 메소드와 이름이 다른 경우
	// 메소드 오버라이딩이 아님
	// (새로운 메소드를 추가하는 것)
	public void sound1() {
		System.out.println("야용 ~ !");
	}
}

public class Class_38_MethodOverriding {
	public static void main(String[] args) {
		Dog_3 d = new Dog_3();
		Cat_3 c = new Cat_3();

		// 상속받는 메소드를 오버라이딩 하는 경우
		// 부모클래스의 메소드는 무시되고
		// 자식클래스에서 새롭게 정의한 메소드가 실행됩니다.
		d.sound();
		c.sound();
		
		// 클래스의 외부에서는 super 키워드를 사용하여
		// 부모클래스의 메소드를 호출할 수 없다.
		// d.super.sound();
	}
}
