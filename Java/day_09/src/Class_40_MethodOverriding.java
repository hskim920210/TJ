// 부모 클래스의 선언
class Student {
	public void study() {
		System.out.println("열심히 공부합니다.");
	}
}

class Student_A extends Student {
	public void study() {
		System.out.println("10분간 쉬었다가 열심히 공부합니다.");
	}

}

class Student_B extends Student {
	public void study() {
		System.out.println("20분간 쉬었다가 열심히 공부합니다.");
	}

}

class Student_C extends Student {
	public void study() {
		System.out.println("내일부터 열심히 공부합니다.");
	}

}

public class Class_40_MethodOverriding {
	public static void main(String[] args) {

		Student_A a1 = new Student_A();
		Student_B b1 = new Student_B();
		Student_C c1 = new Student_C();

		a1.study();
		b1.study();
		c1.study();
		
		// 부모클래스의 배열 선언
		// 부모클래스의 레퍼런스 변수는
		// 자식클래스의 객체를 참조할 수 있으므로
		// 모든 자식클래스의 객체들을 저장할 수 있는
		// 타입이 됩니다.
		Student [] students = new Student[3];
		students[0] = a1;
		students[1] = b1;
		students[2] = c1;
		
		
		for(int i = 0 ; i < students.length ; i++ ) {
			students[i].study(); // 똑같은 코드임에도 불구하고 다른기능을 부를 수 있따.
		}
	}

}
