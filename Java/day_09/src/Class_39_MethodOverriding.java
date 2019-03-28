
class Animal {
	public void sound() {
		System.out.println("소리를 냅니다.");
	}
}

class Dog extends Animal {

	public void sound() {

		super.sound();

		System.out.println("멍 ~ 멍 ~ !");
	}
}

class Cat extends Animal {

	public void sound() {
		super.sound();
		System.out.println("야용 ~ !");
	}

	public void sound(int i) {
		System.out.println("야용 ~ !");
	}

	public void sound1() {
		System.out.println("야용 ~ !");
	}
}

public class Class_39_MethodOverriding {
	public static void main(String[] args) {
		Dog d = new Dog();
		Cat c = new Cat();

		d.sound();
		c.sound();

		// 부모 클래스의 레퍼런스 변수는
		// 자식 클래스의 객체를 참조할 수 있다.
		// 부모가 자식을 참조해야 하기 때문에 자식의 필드 접근지정자는 부모보다 넓어야
		Animal a1 = new Dog();
		Animal a2 = new Cat();
		
		// 메소드 오버라이딩을 구현하는 경우 
		// 오버라이딩 된 메소드는 부모클래스의
		// 레퍼런스 변수를 통해서도 실행된다.
		a1.sound();
		a2.sound();
		
	}
}
