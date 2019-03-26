
class E {
	// 생성자는 메소드다.
	// 리턴값의 타입이 없고, 클래스의 이름과 동일한 이름을 가진 메소드.
	// 생성자는 메소드 오버로딩을 적용할 수 있다.

	// 생성자 오버로딩
	// 생성자는 메소드이므로 메소드 오버로딩을 적용할 수 있다.
	// 메소드 오버로딩 : 동일한 이름의 메소드라도 매개변수의 개수, 타입이 서로 다르다면
	// 서로 다른 메소드로 인지시켜주는 문법

	// 매개변수를 선언하지 않은 디폴트 생성자
	public E() {
		System.out.println("E() 생성자 실행");
	}

	// int 타입을 매개변수로 전달받는 생성자
	public E(int i) {
		System.out.println("E(int i) 생성자 실행");
	}

	// double 타입을 매개변수로 전달받는 생성자
	public E(double d) {
		System.out.println("E(double d) 생성자 실행");
	}
}

public class Class_10_Constructor {

	public static void main(String[] args) {
		new E();
		new E(10);
		new E(1.1);
	}

}
