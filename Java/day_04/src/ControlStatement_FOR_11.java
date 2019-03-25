
public class ControlStatement_FOR_11 {

	public static void main(String[] args) {
		// 중첩된 구조의 반복문에서의 break, continue
		// break : IF 문을 제외한 첫번째 영역을 빠져나가는 명령
		// continue : IF 문을 제외한 첫번째 영역의 종료 지점으로 이동하는 명령

		// 중첩된 반복문을 종료하기 위한 기준변수
		boolean flag = false;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {

				// i의 값이 2이고, j의 값이 3일 때 반복을 종료
				if (i == 2 && j == 3)
					// 아래의 break는 내부의 반복문을 빠져나가는 명령
					// 전체 반복문을 종료할 수 없음
					break;

				System.out.printf("i -> %d, j -> %d\n", i, j);
			}
			System.out.println();
		}

	}

}
