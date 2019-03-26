
class Second {
	// 클래스의 멤버필드 선언
	String name;
	int age;
	
	// 클래스의 멤버메소드 선언
	// 해당 클래스가 제공할 수 있는 기능을 정의하기 위해 메소드 선언
	void input(String input_name, int input_age) {
		// 클래스의 멤버메소드에서는 멤버필드에 접근할 수 있다.
		name = input_name;
		age = input_age;
	}
	
	void output() {
		System.out.printf("이름은 %s, 나이는 %d 입니다. \n", name, age);
	}
}


public class Class_02_Define {

	public static void main(String[] args) {
		Second s = new Second();
		
		s.input("아무개", 22);
		s.output();

	}

}
