package tje.abstract_;

// 추상클래스
// 상속을 통한 다형성의 구현에 강제성을 부여하기 위한 클래스

// 일반적인 상속을 통한 다형성 구현의 문제점
// 강제성의 부재
// 상속을 통해 다형성을 구현하고자 하여도, 하위클래스에서 메소드 오버라이딩을 구현하지
// 않으면 다형성을 구현할 수 없습니다.
// 이때, 오버라이딩을 구현하지 않는것이 문법상 문제가 없다는 점이 강제성의 부재입니다.

class Animal_A {
	// 메소드 오버라이딩을 통한 다형성 구현을 위한 메소드의 선언
	// (부모클래스의 sound 메소드는 형태만 선언됨)
	public void sound() {}
}

class Dog_A extends Animal_A {
	// 메소드 오버라이딩을 구현하고 있는 강아지 클래스
	@Override
	public void sound() {
		System.out.println("멍멍 ~ !");
	}
}

// 메소드 오버라이딩을 구현하지 않은 고양이 클래스
class Cat_A extends Animal_A {}


public class Abstract_01 {

	public static void main(String[] args) {
		Animal_A [] animals = new Animal_A[3];
		
		animals[0] = new Dog_A();
		animals[1] = new Cat_A();
		animals[2] = new Dog_A();
		
		for( int i = 0 ; i < animals.length ; i++ )
			// 다형성을 통한 메소드 실행
			// 실제 객체의 타입에 따라 서로 다른 동작을 실행
			// 강아지 : 멍멍 ~ !
			// 고양이 : 
			animals[i].sound();
		

	}

}
