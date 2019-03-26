// 생성자
// 클래스의 객체가 생성될 때, 멤버필드의 
// 초기화를 위해서 사용되는 메소드
// 각각의 객체가 생성될 때, 서로 다른 값을 가지는
// 객체를 생성할 수 있게 합니다.

// 생성자의 특징
// 1. 메소드
// 2. 클래스의 이름과 동일한 이름을 갖는 메소드
// 3. 리턴값의 타입이 없는 메소드

class B {
	private int age;

	// 생성자 메소드 선언
	public B() {
		System.out.println("B 클래스의 생성자 실행!");
		age = 20;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int input_age) {
		age = input_age;
	}
	
	
}
public class Class_07_Constructor {
	public static void main(String[] args) {
		// 0. B클래스의 클래스 파일이 메모리에 로딩
		// 1. B클래스의 모든 멤버필드들이 HEAP 메모리에 로딩
		// 2. B클래스의 생성자가 호출
		// 3. 생성자의 실행 종료 후, HEAP 메모리에 생성된 객체의 참조값이 반환
		B b = new B();
		System.out.println(b.getAge());
		
		// 생성자는 각각의 객체가 생성될 때마다 호출되는 메소드다.
		B b1 = new B();
		System.out.println(b1.getAge());
		
		// 생성자 메소드는 객체가 생성될 때만 호출되는 메소드
		// 클래스의 레퍼런스 변수를 사용한 명시적인 호출은 허용되지 않는다.
		// b.B();
		// b1.B();
		
	}

}
