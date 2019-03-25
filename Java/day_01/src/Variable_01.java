
public class Variable_01 {

	public static void main(String[] args) {
		// 변수 : 임의의 메모리 공간에 (RAM) 이름을 붙여 관리하는 방법. (프로그램이 실행되고 있는 동안 값을 저장하는 방법을 제공)
		
		// 변수를 선언하는 방법
		// 자료형  변수명;
		// 자료형 : 데이터의 타입
		// - 정수 : byte(1), short(2), int(4) = 기본형, long(8)
		// - 실수 : float(4), double(8) = 기본형
		// - 문자 : char(2) = 유니코드 지원
		// - 진리형 : boolean(1) = true, false 값만 저장 가능
		// - 문자열 : String 클래스를 사용
		
		// 4byte 크기의 메모리 영역에 정수를 저장할 수 있는 변수 num을 선언
		// 변수명은 첫글자를 소문자로 작성하는 것이 암묵적 룰.
		// 여러 단어로 구성된 경우 첫단어 첫글자는 소문자, 두번째 단어부터는 첫글자를 대문자로 작성.
		// ex) int inputNum;
		int num1;
		int num2;
		int num3;
		double num4 = 3.141592;
		
		// 변수에 값을 할당하기 위해서 대입연산자(=)을 사용
		num1 = 101; // 오른쪽에 있는것을 왼쪽에 넣어주겠다는 의미.
		num2 = 202;
		num3 = 303;
		
		System.out.printf("num = %d\n", num1);
		System.out.printf("%d + %d = %d\n", num1, num2, num3*(num1+num2));
		System.out.printf("원주율은 %f이다.\n", num4);
		System.out.printf("%s", "sierjgserjgpsoeirjgpseirgj\n");
		System.out.println("sierjgserjgpsoeirjgpseirgj");
		System.out.println(3.1546498);
		System.out.println(4.54684684);
		System.out.println("가나" + "다라");
		System.out.println("가나"+"+"+"다라");
		System.out.println(num1+"호");
		System.out.println(num1+num3);
		System.out.println(num1+num3+"호");
		System.out.println("Hi ~ "+(num1+num3)+"호");
		System.out.println("t"+"j"+"아"+"카"+'데'+'미');
		System.out.println("num1"+num1);
		System.out.println('1'+1);
		
		System.out.println('1'+'0'); // 1, 0에 연결된 문자가 출력되는 것 0 = 48, 1 = 49의 문자에 연결되어있음

	}

}
