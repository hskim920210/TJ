
public class StringOperation {

	public static void main(String[] args) {
		// 문자열 결합
		// Java의 문자열은 + 연산을 허용합니다.
		// 어떠한 타입의 값이 문자열과 + 연산이 되면 문자열 결합이 된다.
		// 10 + " + " + 20
		System.out.println(10 + 20);
		
		// 10 + " + " + 20 을 하면
		// 1. "10 + " + 20
		// 2. "10 + 20"
		System.out.println(10 + "+" + 20);
		
		
		// 1. "10 + " + 20
		// 2. "10 + 20"
		// 3. "10+20=" 이란 문자열이 출력
		// 4. "10+20=10" 이 출력
		// 5. "10+20=1020" 이 출력
		System.out.println(10 + "+" + 20 + '=' + 10 + 20);

		// 우선순위를 변경할 수 있는 ()을 사용하여 연산의 결과를 출력 
		System.out.println(10 + "+" + 20 + "=" + (10 + 20));
		
		System.out.println("10"+"00"); 
		System.out.println('1'+'0'); 
		
		// 변수. 임의의 메모리 공간에 이름을 붙여 관리하는 방법
		// 숫자타입과 문자타입
		// 숫자는 자료형 byte, short, int, long이 있다. (정수) 
		//			1byte, 2byte, 4byte, 8byte
		// 실수형은 float, double이 있다.
		//		 4byte, 8byte
		
		// 문자는 아스키코드 - 멀티바이트 - 유니코드 (2바이트, java) => Char
		// 문자열은 String, 진리형은 Boolen
	}

}
