
public class ControlStatement_FOR_02 {

	public static void main(String[] args) {
		// 1 ~ 100 까지의 정수 중, 짝수만 출력
		
		// 초기화문과 증감문을 수정하여 처리
		/*
		for ( int i = 2 ; i < 101 ; i += 2)
			System.out.printf("i -> %d\n", i);
		*/
		
		// 제어문을 중첩하여 짝수만 출력하는 예제
		// 반복문 내부에는 다른 제어문을 활용할 수 있다.
		// if, switch, for, while, do ~ while 
		for ( int i = 1 ; i <= 100 ; i++ ) {
			if ( i % 2 == 0 )
				System.out.printf("i -> %d\n", i);
		}
	}

}
