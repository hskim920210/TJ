
public class Array_05 {

	public static void main(String[] args) {
		// 배열 변수의 선언과 생성방법
		
		// 1. 배열 변수를 선언한 후, 실재 배열 공간을 할당
		int[] arr_1;
		arr_1 = new int[5];
		
		// 2. 배열 변수의 선언과 배열의 생성을 동시에 진행
		int [] arr_2 = new int[5];
		
		// 3. 배열을 임의의 값으로 초기화 하여 생성하는 방법
		// 아래 코드는 5개의 배열을 생성한 후, 각 요소를 10,20,30,40,50로 초기화 하는 코드
		int [] arr_3 = new int[] {10,20,30,40,50};
		System.out.printf("arr_3[0] = %d\n", arr_3[0]);
		System.out.printf("arr_3[4] = %d\n", arr_3[4]);
		
		int [] arr_4 = {10,20,30,40,50};
		System.out.printf("arr_3[1] = %d\n", arr_4[1]);
		System.out.printf("arr_3[2] = %d\n", arr_4[2]);
	}

}
