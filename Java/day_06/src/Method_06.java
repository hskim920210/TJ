
public class Method_06 {
	// 메소드 오버로딩 .
	// 메소드의 이름은 같고, 매개변수의 타입, 개수, 순서가 다르면 서로 다른 메소드로 인지하는 문법
	// 일관된 메소드 이름을 사용하여 사용자에게 직관적인 이름을 알려준다.

	// 2개의 정수형 매개변수를 입력받아 가장 큰 수를 반환하는 max2 메소드
	public static int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

	// 3개의 정수형 매개변수를 입력받아 가장 큰 수를 반환하는 max3 메소드
	public static int max(int n1, int n2, int n3) {
		int r = n1 > n2 ? n1 : n2;
		return r > n3 ? r : n3;
	}

	// 4개의 정수형 매개변수를 입력받아 가장 큰 수를 반환하는 max4 메소드
	public static int max(int n1, int n2, int n3, int n4) {
		int r;
		if (n1 > n2)
			r = n1;
		else
			r = n2;
		if (n3 > r)
			r = n3;
		return r > n4 ? r : n4;
	}

	public static void main(String[] args) {
		System.out.println(max(10, 20));
		System.out.println(max(10, 20, 30));
		System.out.println(max(10, 20, 30, 40));

		// println 메소드는 동일한 이름을 사용해 다양한 매개변수를 사용할 수 있다.
		// 메소드 오버로딩의 예
		// System.out.println(1);
		// System.out.println("Hello");
	}

}
