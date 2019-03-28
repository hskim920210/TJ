
public class Class_21_Static {
	public static void main(String[] args) {
		// static 메소드
		// static 멤버 필드와 같이 프로그램의 구동전에 메모리에 로딩되어
		// 객체의 생성없이 클래스의 이름을 사용해 호출할 수 있는 메소드

		// 1. 간단한 공용기능을 제공하기 위해서(Math 클래스)
		// 2. private 접근지정자가 선언된 static 멤버를 초기화하기 위해서

		// 공용기능을 static 메소드로 제공하는 예
		// Math 클래스의 활용
		int num = -10;

		System.out.printf("num 변수의 제곱근 값 : %f\n", Math.sqrt(num));
		System.out.printf("num 변수의 sin 값 : %f\n", Math.sin(num));
		System.out.printf("num 변수의 제곱 값 : %f\n", Math.pow(num, 2));
		System.out.printf("num 변수의 절댓값 : %d\n", Math.abs(num));

		// Integer 클래스 (기본 타입의 자료형인 int의 래퍼 클래스)
		// Integer 클래스의 parseInt 메소드는
		// 문자열로 되어있는 정수값을 int 타입으로 반환
		String strNum1 = "757";
		String strNum2 = "3";
		String strNum3;
		String strResult = strNum1 + strNum2;
		System.out.printf("%s + %s = %s\n", strNum1, strNum2, strResult);

		// 문자열로 저장된 757을 정수형으로 변경하여 반환하는 parseInt 메소드
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.printf("%d + %d = %d\n", num1, num2, result);

		// Double 클래스 (기본 타입의 자료형인 int의 래퍼 클래스)
		// Double 클래스의 parseDouble 메소드는
		// 문자열로 되어있는 실수값을 double 타입으로 반환
		strNum1 = "10.719";
		strNum2 = "7.315";

		double d1 = Double.parseDouble(strNum1);
		double d2 = Double.parseDouble(strNum2);
		double resultd = d1 + d2;
		System.out.printf("%f + %f = %f\n", d1, d2, resultd);
	}

}
