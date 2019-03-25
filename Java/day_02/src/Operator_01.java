// 연산자
// 연산자는 자바 언어에서 사용할 수 있는 기호들의 정의
// +, -, %, >>, <<, &&, || ...
// 연산자의 대입되는 피연산자와 연산자의 반환값을 확인해야함.

public class Operator_01 {

	public static void main(String[] args) {
		// 산술연산자
		// +, -, *, /, %(나머지 연산자)
		int n1 = 10;
		int n2 = 7;
		// 산술연산의 결과를 저장하기 위한 변수
		int result;
		
		result = n1+n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		
		result = n1-n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		
		result = n1*n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		
		// 나누기 연산 : 정수사이에서의 연산인 경우 정수만 반환된다.
		result = n1/n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
		
		// 나머지 연산 : 좌항과 우항을 나눈 결과의 나머지 값을 반환.
		// 짝수 또는 배수를 판단하는 경우 활용
		result = n1%n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		
		
		byte b1 = 10;
		byte b2 = 7;
		// 자바에서 산술연산자는 정수 사이에서의 연산은 int가 반환된다.
		// 아래와 같이 byte 또는 short 타입의 변수에 산술연산의 결과를 대입받는 경우 컴파일 에러가 발생
		// byte b3 = b1 + b2; // int b4 = b1 + b2; 는 상관없다
		// 강제 형변환을 통해 산술연산의 결과를 byte 또는 short 타입의 변수로 대입할 수 있다.
		byte b3 = (byte)(b1 + b2);
		
		// 연산자의 좌항 또는 우항이 실수인 경우 해당 실수의 타입을 반환
		// 정수 + float -> float 반환
		// double + 정수 -> double
		// double + float -> double

	}

}
