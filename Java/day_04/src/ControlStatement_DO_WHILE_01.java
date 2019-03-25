
public class ControlStatement_DO_WHILE_01 {

	public static void main(String[] args) {
		// do ~ while 반복문
		// while문과 마찬가지로 조건식을 기준으로 반복의 여부를 결정할 수 있는 문법

		// 형식 :
		// do {
		// 반복할 실행문
		// } while( 조건식 );

		// for, while 반복문은 조건에 따라 한번도 실행이 안될 수 있다.

		// 반면, do ~ while 반복문은 한번의 실행을 보장하는 반복문. 대부분의 프로그램 실행에 do ~ while이 쓰인다.

		int i = 1;

		do {
			System.out.printf("i = %d\n", i);
		} while (true); // do ~ while 반복문의 정의 마지막은 ; 으로 마무리

	}

}
