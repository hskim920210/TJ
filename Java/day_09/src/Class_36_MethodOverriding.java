
// 부모클래스 정의되는 속성, 기능들은 
// 모든 자식클래스에서 동작해야하므로
// 일반적인 정의만 사용할 수 있습니다.
// 각각의 자식클래스에서는 
// 자기만의 독특한 기능을 제공할 수 없음
class Animal_1 {
	public void sound() {
		System.out.println("소리를 냅니다.");
	}
}
class Dog_1 extends Animal_1 {}
class Cat_1 extends Animal_1 {}

public class Class_36_MethodOverriding {
	public static void main(String[] args) {
		Dog_1 d = new Dog_1();
		Cat_1 c = new Cat_1();
		
		// 상속받는 메소드가 자식클래스에게 
		// 어울리지 않는 경우 !
		d.sound(); c.sound();
	}
}
