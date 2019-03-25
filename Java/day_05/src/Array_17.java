
public class Array_17 {

	public static void main(String[] args) {
		// 2차원 배열과 반복문
		// 2차원 배열은 행과 열을 나타내는 2개의 인덱스를 사용하는 배열
		// 2차원 배열의 각 요소에 접근하는 반복문을 중첩된 형태를 사용한다.
		// 일반적으로 외부의 반복문은 2차원 배열의 행을 제어
		// 내부의 반복문은 열을 제어한다.

		int[][] arr = new int[2][5];
		int value = 10;

		// 행의 인덱스를 제어하는 반복문
		for (int i = 0; i < 2; i++) {

			// 열의 인덱스를 제어하는 반복문
			for (int j = 0; j < 5; j++) {
				arr[i][j] = value++;
				System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
			}
			System.out.println();
		}
	}

}
