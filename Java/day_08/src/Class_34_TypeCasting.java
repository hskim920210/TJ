class Casting_A {
	int num;
}

class Casting_B {
	int num;
}

public class Class_34_TypeCasting {
	public static void main(String[] args) {
		// 기본 자료형 간의 형변환은 자료형의 크기에 영향을 받는다.
		short s = 10;
		int i = s;

		// 4 Byte 크기의 int 타입의 정수를
		// 2 Byte 크기의 short 타입 변수에 대입할 수 없다.
		// s = i;

		i = 10000000;
		// 강제 형변환을 통한 값의 대입은 허용
		// (값의 안정성은 보장할 수 없다.)
		s = (short) i;

		System.out.printf("s = %d, i = %d\n", s, i);

		// 클래스의 레퍼런스 변수간의 형변환은 각 레퍼런스의 접근 범위에 영향을 받는다.

		// 서로 다른 클래스 객체간의 형 변환은 허용되지 않습니다.
		// 클래스의 레퍼런스는 해당 클래스의 멤버에 접근할 수 있는 권한을
		// 가진 변수입니다.
		// a1 레퍼런스 변수는 Casting_A 클래스의 타입의 객체에서 num 변수에 접근할 수 있는 변수
		// b1 레퍼런스 변수는 Casting_B 클래스의 타입의 객체에서 num 변수에 접근할 수 있는 변수
		Casting_A a1 = new Casting_A(); // A클래스의 num에 접근
		// Casting_B b1 = a1; // B클래스의 num에 접근
		
		Casting_B b2 = new Casting_B();
		// Casting_A a2 = b2;
	}

}
