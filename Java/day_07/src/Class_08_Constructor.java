
class C {
	private int age;
	
	// 만약 클래스를 정의하면서 '생성자를 작성하지 않은 경우'
	// 자바 컴파일러에 의해서 아래와 같은 생성자 코드가 추가된다.
	// 디폴트 생성자 : 매개변수가 없고, 실행코드가 없는 기본 생성자
	// public C() {}
	
	public int getAge() {
		return age;
	}

	public void setAge(int input_age) {
		age = input_age;
	}
}

public class Class_08_Constructor {
	public static void main(String[] args) {
		// 디폴트 생성자를 통해서 객체가 생성되는 예제
		C c = new C();

	}

}
