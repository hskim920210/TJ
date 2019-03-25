
public class Array_16 {

	public static void main(String[] args) {
		// 2차원 배열의 선언 및 초기화 방법
		// 1. 2차원 배열의 변수를 선언한 후 2차원 배열을 할당하는 방법
		int [][] arr_1;
		// 0으로 초기화된  2행 3열의 배열이 반환
		arr_1 = new int[2][3];
		
		// 2. 2차원 배열의 선언과 동시에 2차원 배열을 할당하는 방법
		// 0으로 초기화된 2행 3열의 배열이 반환
		int[][] arr_2 = new int[2][3];
		
		System.out.println(arr_1[0][0]);
		System.out.println(arr_2[0][0]);
		
		// 2차원의 생성시 초기값을 지정하는 방법
		// { {1차원 배열의 요소}, {1차원 배열의 요소}}
		int [][] arr_3 = new int[][] {{1,2,3},{4,5,6}};
		
		System.out.println(arr_3[1][1]);
		
		int [][] arr_4 = {{1,2,3},{4,5,6}};
		
		System.out.println(arr_4[1][1]);
		

	}

}
