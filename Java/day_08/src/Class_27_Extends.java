// 상속의 구현
// extends 키워드의 사용
// class SubClass명 extends SuperClass명
// 상속을 받는 클래스 : 서브클래스, 자식클래스, 하위클래스
// 상속을 해주는 클래스 : 슈퍼클래스, 부모클래스, 상위클래스

class 자동차 {
	double 엔진;
	double 배기량;
	int 도어개수;
}

class K7 extends 자동차 {}

public class Class_27_Extends {

	public static void main(String[] args) {
		// 상속을 구현한 자식클래스의 객체를 생성
		K7 car = new K7();

		// 자식 클래스는 부모 클래스로부터 상속받은 멤버들을 사용할 수 있다.
		System.out.printf("엔진 : %f\n", car.엔진);
		System.out.printf("배기량 : %f\n", car.배기량);
		System.out.printf("도어개수 : %d\n", car.도어개수);
	}

}
