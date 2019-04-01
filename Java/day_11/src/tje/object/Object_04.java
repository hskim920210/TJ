package tje.object;

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		String info = "name : " + this.name + ", age : " + this.age;
		return info;
	}

	// 객체의 비교를 수행하기 위한 equals 메소드
	// 올바른 equals 메소드의 정의방법
	// 1. 매개변수로 전달된 Object 타입의 변수에 대해서
	// 	    타입 체크를 진행(현재 클래스와 동일한 타입인지를 비교)
	// 2. 동일한 타입이 전달되지 않았다면 return false
	// 3. 만약 동일한 타입이 전달되었다면 강제 형변환을 통해서 타입 변환
	// 4. 타입이 변환된 레퍼런스를 사용하여 멤버 필드의 값을 비교
	// 5. 비교결과를 반환
	public boolean equals(Object obj) {
		// 1. 타입체크
		if (!(obj instanceof Student))
			// 2. 동일한 타입이 아닌 경우 false 반환
			return false;

		// 3. 형변환
		Student target = (Student) obj;
		
		// 4. 타입이 변환된 레퍼런스를 사용하여 멤버값을 비교
		boolean result;
		boolean flag_name = this.name.equals(target.name);
		boolean flag_age = this.age == target.age;

		result = flag_name && flag_age;

		return result;
	}

}

public class Object_04 {

	public static void main(String[] args) {
		Student s1 = new Student("학생1", 20);
		Student s2 = new Student("학생2", 30);

		System.out.println("학생1 -> " + s1);
		System.out.println("학생2 -> " + s2);

		if (s1 == s2)
			System.out.println("s1 학생과 s2 학생은 같습니다.");
		else
			System.out.println("s1 학생과 s2 학생은 다릅니다.");

		if (s1.equals(s2))
			System.out.println("s1 학생과 s2 학생은 같습니다.");
		else
			System.out.println("s1 학생과 s2 학생은 다릅니다.");

		Student s3 = new Student("학생1", 20);

		System.out.println("학생1 -> " + s1);
		System.out.println("학생2 -> " + s3);

		// Object 클래스의 equals 메소드는 두 객체의
		// 데이터가 동일한지에 관련된 정보를 제공할 수 있는 명세를 지정합니다.
		// (Object 클래스의 equals 메소드는 기본적으로 두 객체의
		// 참조값을 비교하는 연산만을 수행)
		// 사용자 정의 클래스에서 객체의 같음을 비교할 수 있는
		// equals 메소드를 사용하기 위해서는 equals 메소드를
		// 오버라이딩 해야만 합니다.
		if (s1.equals(s3))
			System.out.println("s1 학생과 s2 학생은 같습니다.");
		else
			System.out.println("s1 학생과 s2 학생은 다릅니다.");

		String s4 = "학생4";

		if (s1.equals(s4))
			System.out.println("s1 학생과 s4 학생은 같습니다.");
		else
			System.out.println("s1 학생과 s4 학생은 다릅니다.");
		
		
	}

}
