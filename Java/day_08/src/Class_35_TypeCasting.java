// 상속관계를 구현하고 있는 클래스 사이의 형변환
// 부모클래스
class SuperF {
	int superNum;
}

// 자식클래스
class SubF extends SuperF {
	int subNum;
}

public class Class_35_TypeCasting {

	public static void main(String[] args) {
		SuperF super_1 = new SuperF();
		// 부모클래스의 레퍼런스 변수 값을
		// 자식클래스의 레퍼런스 변수에 대입할 수 없습니다.
		// (자식클래스는 부모클래스를 확장한 개념이므로
		// 부모클래스의 레퍼런스 변수가 제공하는 접근 범위만으로는
		// 권한이 부족...)
		// SubF sub_1 = super_1;

		SubF sub_2 = new SubF();
		// 자식클래스의 레퍼런스 변수 값을
		// 부모클래스의 레퍼런스 변수에 대입할 수 있습니다.
		// 자식클래스의 레퍼런스 변수는 부모클래스의 멤버에
		// 접근할 수 있는 권한이 있으므로
		// 부모클래스의 접근 권한을 만족시킬 수 있습니다.
		SuperF super_2 = sub_2; // 부모클래스의 레퍼런스 변수는 자식클래스의 객체를 참조할 수 있다.

		// 부모 클래스는 자식 클래스의 객체를 참조할 수 있다.
		// 하지만 참조의 범위는 부모클래스의 멤버로 한정.
		super_2.superNum = 10;
		// 자식클래스의 멤버에는 접근할 수 없다. (에러)
		// super_2.subNum = 20;

		// 만약 부모클래스의 레퍼런스 변수가 자식클래스의 객체를
		// 참조하는 경우인 경우
		// 강제 캐스팅을 사용하여 자식클래스의 레퍼런스 변수에
		// 참조값을 대입할 수 있습니다.
		SubF sub_3 = (SubF) super_2;

		// 강제 캐스팅을 사용하여 부모클래스의 레퍼런스 값을
		// 자식클래스의 레퍼런스 변수에 대입할 수 있습니다.
		// 하지만 실제 타입이 자식클래스가 아닌 경우
		// 런타임 에러가 발생되어 프로그램이 종료
		SuperF super_3 = new SuperF();
		// 아래의 코드는 부모 클래스의 타입을 자식 클래스의 타입으로 변환할 수 없기 때문에 에러 발생
		// sub_3 = (SubF) super_3;

		// 강제 캐스팅을 사용한 형변환 시 에러를 방지하는 방법
		// instanceof 연산자
		// 레퍼런스변수 instanceof 클래스명
		// 해당 레퍼런스 변수가 실제 참조하는 곳이
		// 우항의 클래스 타입인 경우 true
		// 아니면 false 가 반환
		
		// super_3 레퍼런스 변수가 실제로 참조하고 있는 객체가
		// SubF 타입인 경우 true가 반환. 아닌 경우 false
		if ( super_3 instanceof SubF ) {
			System.out.println("형변환 가능");
			sub_3 = (SubF) super_3;
		} else
			System.out.println("형변환이 허용되지 않음");
	}

}
