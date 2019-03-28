// 상속받는 메소드가 자식클래스에게 어울리지 않는 경우!
// 메소드 오버라이딩
// 부모클래스에서 물려받은 메소드는 모든 자식클래스에게 동일하게 적용됩니다.
// 이때, 자식 클래스는 부모클래스에서 물려받은 메소드를 자신의 용도에 맞게 
// 재정의 할 수 있습니다.

// 메소드 오버라이딩
// 부모클래스의 메소드를 재정의하는 문법으로 자식클래스에서
// 부모클래스의 메소드의 원형을 다시 한번 정의하는 문법입니다.
// 메소드 오버라이딩을 구현하면, 부모클래스에서 물려받은 메소드는 무시되고,
// 새롭게 정의한 메소드가 사용됩니다.
class Animal_2 {
	public void sound() {
		System.out.println("소리를 냅니다.");
	}
}

class Dog_2 extends Animal_2 {
	// 메소드 오버라이딩의 구현
	public void sound() {
		System.out.println("멍 ~ 멍 ~ !");
	}
}

class Cat_2 extends Animal_2 {
	// 메소드 오버라이딩의 구현
	public void sound() {
		System.out.println("야용 ~ !");
	}
}

public class Class_37_MethodOverriding {
	public static void main(String[] args) {
		Dog_2 d = new Dog_2();
		Cat_2 c = new Cat_2();

		// 상속받는 메소드를 오버라이딩 하는 경우
		// 부모클래스의 메소드는 무시되고
		// 자식클래스에서 새롭게 정의한 메소드가 실행됩니다.
		d.sound();
		c.sound();
	}
}
