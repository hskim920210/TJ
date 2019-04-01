package tje.object;

public class Object_03 {
	public static void main(String[] args) {

		// 일반적인 자료형의 변수들 (int, double, char) 은
		// 값의 비교를 위해 비교연산자(==)를 사용한다.
		int n1 = 10;
		int n2 = 7;

		if (n1 == n2)
			System.out.println("n1 변수와 n2 변수는 같습니다.\n");
		else
			System.out.println("n1 변수와 n2 변수는 다릅니다.\n");

		// 문자열 클래스의 객체를 선언한 후,
		// 비교 연산을 수행
		// new 연산자를 사용하여 객체를 생성하는 경우의 비교
		// new 연산자의 실행 과정
		// 1. 우항에 위치한 클래스의 객체를 HEAP 메모리에 로딩
		// 2. 생성자를 실행하여 객체의 초기화를 진행
		// 3. 생성된 객체의 참조값을 반환
		String s1 = new String("Hello");
		String s2 = new String("Hello");

		// 생성된 객체의 참조값을 저장하는 클래스의 레퍼런스 변수들은
		// 비교연산자(==)를 통해서 값의 같음을 확인할 수 없습니다.
		if (s1 == s2)
			System.out.println("s1 변수와 s2 변수는 같습니다.\n");
		else
			System.out.println("s1 변수와 s2 변수는 다릅니다.\n");

		// 실제 객체의 값을 비교하기 위한 equals 메소드를 사용하면
		// 참조값이 서로 다른 객체의 실제 데이터를 비교하여
		// 동일한 데이터를 가지고 있는지 확인할 수 있습니다.
		if (s1.equals(s2))
			System.out.println("s1 변수와 s2 변수는 같습니다.\n");
		else
			System.out.println("s1 변수와 s2 변수는 다릅니다.\n");

	}

}
