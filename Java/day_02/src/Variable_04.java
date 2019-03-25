
public class Variable_04 {

	public static void main(String[] args) {
		// 자료형에 따른 변수의 초기화 값
		
		// 1. 문자 타입의 변수를 초기화 하는 방법
		// - 문자열을 정의하는 경우 쌍따옴표를 사용 ( "문자열 값" )
		// - 문자값을 정의하는 경우 작은따옴표를 사용 ( 'A' )
		// - 문자값을 정의할 때는 반드시 1개의 글자만을 사용
		char ch1 = 'A';
		System.out.printf("ch1 = %c\n", ch1);
		// 자바는 유니코드를 지원하므로 한글도 저장이 가능
		char ch2 = '가';
		System.out.printf("ch2 = %c\n", ch2);
		System.out.printf("ch2 = %s\n", ch2);
		
		// 강제형변환
		// 특정 타입을 원하는 타입으로 변경하는 방법
		// (변경할 타입)값 또는 변수
		// 문자는 정수로 저장되며, A -> 65, a -> 97, 0 -> 48
		System.out.printf("ch1 = %d\n", (int)ch1);
		System.out.printf("ch2 = %d\n", (int)ch2);
		System.out.printf("ch1 = %f\n", (double)ch1);
		// System.out.printf("ch1 = %f\n", (int)ch1);
		
		System.out.printf("A=%d, a=%f, 0=%d\n", (int)'A', (double)'a', (int)'0');
		
		// 문자값을 저장하는 char 타입은 부호를 지원하지 않는다. (항상 양수, 0~65xxx)
		// 문자 코드표는 음수의 값이 존재하지 않는다.
		// char ch3 = -127;
		
		// 문자 코드값을 사용한 대소문자 변환
		char ch4 = 'A';
		// 대문자를 소문자로 변경하는 경우 값을 증가하여 처리할 수 있다.
		// 대문자와 소문자의 차이를 더해준다.
		System.out.printf("변환 전 : %c, 변환 후 : %c\n", ch4, ch4+32);
		System.out.printf("변환 전 : %c, 변환 후 : %c\n", ch4, ch4+'a'-'A');
		
		char n1 = '7';
		char n2 = '5';
		System.out.println((int)n1);
		System.out.println((int)n2);
		// 문자로 저장된 숫자를 실제 정수로 변환하기 위해서 문자 0 값에 해당되는 값만큼 감소
		System.out.printf("%c+%c=%d\n", n1, n2, n1-'0'+n2-'0');
		
		System.out.println("5"+(int)'7'); // 555
		System.out.println('7'+"5");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
