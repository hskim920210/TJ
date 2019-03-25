
public class ControlStatement_IF_03 {

	public static void main(String[] args) {
		// 제어문의 실행영역
		// 자바의 모든 제어문은 기본적으로 1개 실행문을 제어합니다.
		// 제어문 바로 뒤의 1개의 실행문 제어
		int number = 13;
		
		
		// 만약 다수개의 실행문을 제어문에 포함하고자 하는 경우 영역을 지정하여 처리할 수 있다.
		// 중괄호를 사용하여 정의
		if(number % 2 == 0) {
			System.out.println("짝수인 경우 실행코드 -1");
			System.out.println("짝수인 경우 실행코드 -2");
		}
	}

}
