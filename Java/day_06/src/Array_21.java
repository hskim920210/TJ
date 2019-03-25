
public class Array_21 {

	public static void main(String[] args) {
		// 배열의 복사
		// 1. 얕은 복사
		// - 배열의 형태만 복사
		// - 실제 데이터의 복사가 일어나지 않음
		// 2. 깊은 복사
		// - 배열의 형태 및 실제 데이터의 복사
		
		int [] arr = {1,2,3,4,5};
		
		for ( int i = 0 ; i < arr.length ; i ++ ) {
			System.out.printf("arr[%d] = %d\n", i , arr[i]);
		}
		
		// clone 메소드를 사용한 배열의 복사
		// 배열명.clone();
		// 해당 배열변수가 참조하고 있는 배열을 복사하여 복사된 지점의 레퍼런스(참조)값을 반환하는 메소드
		int [] arr_copy = arr.clone();
		
		System.out.println("==============================================");
		for ( int i = 0 ; i < arr.length ; i ++ ) {
			System.out.printf("arr[%d] = %d\n", i , arr[i]);
			System.out.printf("arr_copy[%d] = %d\n", i , arr_copy[i]);
		}
		
		arr_copy[2] = 300;
		
		// 복제된 배열의 요소 값을 변경한 이 후, 원본 데이터와 함께 출력
		// 1차원 배열의 경우 깊은 복사가 구현되기 때문에 arr_copy의 모든 요소 값을 수정하여도 arr의 데이터에는 영향이 없다.(완전 분리된 상태)
		System.out.println("==============================================");
		for ( int i = 0 ; i < arr.length ; i ++ ) {
			System.out.printf("arr[%d] = %d\n", i , arr[i]);
			System.out.printf("arr_copy[%d] = %d\n", i , arr_copy[i]);
		}
		
		
		
	}

}
