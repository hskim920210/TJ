
// static 멤버 변수의 활용
// 1. 공유 변수를 생성하고자 하는 경우
// - 특정 클래스의 모든 객체들이 동일한 값을 참조하는 경우 
//	 static 멤버 변수를 사용하여 처리할 수 있다.
// - 통장의 이자율과 같은 정보를 저장하는 경우 ( 특정 통장 클래스의 모든 객체는 동일한 이자율을 참조 )
// 2. 공용변수를 생성하고자 하는 경우
// - 프로그램 내부에서 공유하고자 하는 변수를 생성

class SharedInfo {
	// 프로그램에서 사용될 배열의 크기를 저장하는 static 변수
	public static int ARRAY_SIZE = 100;
}


public class Class_19_Static {

	public static void main(String[] args) {
		// static 변수의 값을 사용하여 배열을 생성하는 예제
		// (static 변수는 객체의 생성 없이 클래스의 이름으로 접근이 가능하다)
		int [] arr = new int[SharedInfo.ARRAY_SIZE];
		
		// static 키워드의 활용 예
		// Math 클래스의 PI 변수
		// static 멤버, 메소드를 가장 많이 활용하고 있는 클래스
		// 수학적인 계산에 필요한 값, 기능들을 static 멤버, 메소드로 제공하는 클래스
		// (객체의 생성없이 바로 활용할 수 있음)
		System.out.printf("원주율 : %f\n", Math.PI);
	}

}
