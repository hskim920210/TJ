
public class Array_15 {

	public static void main(String[] args) {
		// 2차원 배열
		// 배열의 인덱스 연산이 2개 필요한 배열
		// 행/열의 개념을 적용
		
		// 2차원 배열의 변수 선언
		// 행과 열에 대한 []가 2개 사용됨
		int [][] arr;
		
		// 2차원 배열의 생성
		// 2차원배열변수명 = new 자료형[행의개수][열의개수]
		// 2차원배열변수명 = new 자료형[1차원배열의개수][1차원배열의크기]
		
		// 3행 2열의 배열 생성
		// (크기가 2인 1차원 배열이 3개 생성)
		arr = new int [3][2];
		
		arr[2][1] = 10;
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			for ( int j = 0 ; j < 2 ; j++ )
				System.out.printf("%d   ", arr[i][j]);
			System.out.println();
		}

	}

}
