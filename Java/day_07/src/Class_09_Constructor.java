
class D {
	private int age;

	// 생성자는 메소드이므로 매개변수를 사용할 수 있다.
	// 생성자의 매개변수를 활용하는 경우
	// 각각의 객체마다 서로 다른 값을 가질 수 있다.
	public D(int input_age) {
		System.out.println("매개변수를 사용하는 생성자 실행");
		age = input_age;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int input_age) {
		age = input_age;
	}
}



public class Class_09_Constructor {
	public static void main(String[] args) {

		// 만약 클래스의 생성자를 사용자가 직접 작성하는 경우 컴파일러는 디폴트 생성자를 생성하지 않는다.
		// D d = new D();

		// 매개변수를 선언한 생성자를 통해 객체를 생성하는 코드
		D d1 = new D(10);
		D d2 = new D(22);
		D d3 = new D(33);
		System.out.println(d1.getAge());
		System.out.println(d2.getAge());
		System.out.println(d3.getAge());
	}

}
