
public class Array_06 {

	public static void main(String[] args) {
		// 배열 변수의 선언
		// [] 를 사용하여 배열 변수를 선언할 수 있다.
		// 1. 자료형 [] 배열변수명;
		// 2. 자료형 배열변수명 [];
		
		// 크기가 3인 배열 생성
		int [] arr_1 = new int[3];
		int arr_2 [] = new int[3];
		
		// 두 개의 배열 변수를 선언하는 코드
		int [] arr_3, arr_4;
		arr_3 = new int[3];
		arr_4 = new int[3];
		// 한 개의 배열 변수와 int 타입 변수를 선언하는 코드
		int arr_5 [], arr_6;
		arr_5 = new int[3];

		
		// arr_6은 정수형 변수이기 때문에 배열을 할당받을 수 없습니다.
		// arr_6 = new int[3]; 안된다
		arr_6 = 10;
	}

}
