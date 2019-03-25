
public class Variable_05 {

	public static void main(String[] args) {
		// 실수형 변수의 초기화
		// float(4), double(8, 기본형)
		float f;

		
		// 실수의 기본형에 관련된 에러
		// 자바에서 사용되는 모든 실수는 크기에 관계없이 double형으로 인식된다.
		
		// 아래와 같이 float 타입의 변수에 실수를 대입하는 경우 타입 미스매치 에러가 발생한다.
		// float 타입의 변수에 값을 할당하는 방법
		// 1. 강제형변환
		f = (float)1.1;
		// 2. float 타입의 실수값을 선언하여 대입
		// - 실수값F
		f = 11.7f;
		f = 11.7F;
		
		// 정수형 변수의 초기화
		// byte(1), short(2), int(4, 기본형), long(8)
		System.out.println(Integer.MAX_VALUE);
		// 자바코드에서 작성되는 모든 정수는 int형으로 인식됩니다.
		// 아래와 같이 int 타입이 저장할 수 있는 영역을 벗어난 값은 에러가 발생된다.
		
		// 아래와 같이 숫자 뒤에 L을 사용하면 long 타입의 값이 됩니다.
		long num = 2147483648L;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
