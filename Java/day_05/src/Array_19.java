
public class Array_19 {

	public static void main(String[] args) {
		// 다차원 배열은 차원의 개수와 일치하는 length 정보를 제공
		// (2차원 배열은 2개, 3차원 배열은 3개)

		int[][] arr = new int[7][12];

		// 2차원 배열의 이름을 사용하여 length에 접근하는 경우
		// 1차원 배열의 개수가 반환된다.
		System.out.printf("arr.length -> %d\n", arr.length);

		// 2차원 배열의 각 요소에 대해서 인덱스 연산으로 접근한 후 length속성을 사용하면 각 1차원 배열의 크기가 반환된다.
		System.out.printf("arr[0].length -> %d\n", arr.length);

		// 위에 선언된 이차원 배열 arr을 length 속성을 사용하여 값을 출력하세요.

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = i + j + 10;
				System.out.printf("(%d,%d)의 성분 값은 %d이다.\n", i + 1, j + 1, arr[i][j]);
			}
			System.out.println();
		}

	}

}
