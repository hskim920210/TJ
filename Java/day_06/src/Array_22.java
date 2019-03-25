
public class Array_22 {

	public static void main(String[] args) {
		// 다차원 배열의 복사
		int[][] arr = {{1,2,3},{4,5,6}};
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			for( int j = 0 ; j < arr[i].length ; j++ ) {
				System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
			}
		}
		
		// 이차원배열(다차원배열)은 clone 메소드의 결과로 실제 일차원 배열을 관리하고 있는 이차원 배열만 복사한다.
		// (이차원 배열의 내부에 있는 일차원 배열은 복사하지 않음. 형태만 복사)
		int[][] arr_copy = arr.clone();
		
		System.out.println("======================================");
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			for( int j = 0 ; j < arr[i].length ; j++ ) {
				System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
				System.out.printf("arr_copy[%d][%d] = %d\n", i, j, arr_copy[i][j]);
			}
		}
		
		// 복사한 2차원 변수를 사용하여 특정 요소의 값을 수정
		// 얕은 복사를 통한 배열의 복사
		// (실제 일차원 배열은 분리되지 않은 상태)
		// arr 배열변수와 공유하고 있는 1차원 배열의 값을 수정
		// 얕은 복사로 복사된 arr_copy의 값을 수정하게 되면 arr 배열 변수로도 수정된 값을 참조하게 된다.
		arr_copy[0][1] = 22222;
		
		System.out.println("======================================");
				
				for( int i = 0 ; i < arr.length ; i++ ) {
					for( int j = 0 ; j < arr[i].length ; j++ ) {
						System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
						System.out.printf("arr_copy[%d][%d] = %d\n", i, j, arr_copy[i][j]);
					}
				}
		
	}

}
