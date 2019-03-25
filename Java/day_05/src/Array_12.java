
public class Array_12 {

	public static void main(String[] args) {
		// 배열의 정렬 (버블정렬)
		int [] arr = {50, 10, 5, 20, 7};
		
		// arr 배열을 오름차순으로 정렬
		// 정렬 시킬 위치의 인덱스를 제어하는 외부의 반복문		
		// 배열의 시작부터 마지막 -1번까지 반복
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			
			// 기준위치와 비교할 인덱스를 제어
			// 만약 기준위치가 0이라면 1~마지막요소까지 반복
			// 만약 기준위치가 3이라면 4~마지막요소까지 반복
			for ( int j = i+1 ; j < arr.length ; j++ ) {
				// 기준위치의 값은 가장 작은 값이 되야 하므로 비교대상보다 큰 경우 값을 교환합니다.
				if ( arr[i] > arr[j] ) {
					// SWAP 로직
					// 두 변수의 값을 교환하는 방법
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		System.out.println("정렬 후의 배열");
		for ( int i = 0 ; i < arr.length ; i++ )
			System.out.printf("%d ", arr[i]);
	}

}
