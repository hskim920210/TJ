
public class Array_07 {

	public static void main(String[] args) {
		// 배열의 활용
		// 반복문을 활용한 배열의 값 입력 및 출력
		// 인덱스의 값을 변경하면서 반복을 통해 값을 입력, 출력
		int [] arr = new int[100];
		
		// 배열은 하나의 변수명과 인덱스를 조합하여 각 요소에 접근하는 방법을 사용한다.
		// for 반복문을 사용하여 인덱스의 값을 증가시켜나가면서 특정 배열의 모든 요소를 순회하는 방법을 사용한다.
		
		// arr 배열의 첫번째 요소부터 마지막 요소까지 접근하기 위한 반복문
		for ( int i = 0 ; i < 100 ; i++ ) {
			// 배열의 인덱스 연산은 변수를 사용할 수 있다.
			arr[i] = 100 + i;
			System.out.printf("arr[%2d] = %d\n", i, arr[i]);
		}

	}

}
