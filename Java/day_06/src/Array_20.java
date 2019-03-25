
public class Array_20 {

	public static void main(String[] args) {
		// 서로 다른 크기의 1차원 배열을 포함하는 2차원 배열
		// 자바에서 사용되는 다차원 배열은 서로 다른 크기의 하위 배열을 포함할 수 있다.
		
		// 2차원 배열 변수 선언
		//  - 1차원 배열을 관리하는 배열
		int [][] arr;
		
		// 2차원 배열 변수 arr에 1차원 배열을 3개 관리할 수 있는 배열 변수를 할당
		arr = new int[3][];
		
		// 1차원 배열을 생성하여 arr에 할당하는 코드
		arr[0] = new int [5];
		arr[1] = new int [3];
		arr[2] = new int [2];
		
		int value = 100;
		
		// 2차원 배열의 모든 요소를 순회하는 반복문의 정의
		for ( int i = 0 ; i < arr.length ; i++ ) {
			
			// 각각의 1차원 배열의 모든 요소를 순회하는 반복문의 정의
			for ( int j = 0 ; j < arr[i].length ; j++ ) {
				arr[i][j] = value++;
				System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
			}
			System.out.println();
		}

	}

}
