
public class PrintMethods {

	public static void main(String[] args) {
		// 기본 출력 객체의 출력 메소드
		// 1. print 메소드
		//  - 매개변수를 화면에 출력하고, 자동으로 개행하지 않는 메소드
		// 매개변수 : 메소드의 소괄호 내부에 정의된 값
		System.out.print("Hello "); // -> Hello
		System.out.print("Java~!"); // -> Hello Java~!
		
		// 강제로 개행을 하고자 하는 경우 개행문자( \n )를 사용한다.
		System.out.print("Hello \n"); // -> Hello Java~!Hello \n
		System.out.print("Java~!\n"); // -> Hello Java~!Hello \nJava~!\n
		
		// 2. println 메소드
		// - 매개변수를 화면에 출력하고, 자동으로 개행하는 메소드
		// - 매개변수를 사용하지 않는 경우 개행만 실행
		System.out.println(); // 개행문자만 출력
		System.out.println("Hello Java~!");
		System.out.println("Javaaaaaaaa");
		
		// 3. printf 메소드
		// - 매개변수로 전달된 문자열을 사용하여 형식에 맞춰 출력할 수 있는 메소드
		// - printf("형식문자열", 값1, ... ,값N);
		// - 형식문자열 내부에 사용할 수 있는 서식
		// - 자동개행을 지원하지 않음
		// %d : 10진수의 정수값을 출력할 수 있는 서식
		// %f : 부동 소수점 값을 출력할 수 있는 서식
		// %s : 문자열 값을 출력할 수 있는 서식
		// %c : 하나의 문자값을 출력할 수 있는 양식
		System.out.printf("%d + %d = %d\n", 10, 2, 10+7);
		System.out.printf("제 이름은 %s 입니다.\n", "ㅁㄴㅇ");
		System.out.printf("원주율의 값은 %f 입니다.\n", 3.1464453687654);
		System.out.printf("오늘은 %c 요일입니다.\n", '토'); // %c는 하나의 문자. 문자를 사용할 때에는 작은 따옴표 ''를 쓴다.
		
		System.out.println();
		System.out.println("개행");
	}

}
