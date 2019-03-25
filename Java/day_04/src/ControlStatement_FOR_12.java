
public class ControlStatement_FOR_12 {

	public static void main(String[] args) {
		// 중첩된 구조의 반복문에서의 break, continue
		// break : IF 문을 제외한 첫번째 영역을 빠져나가는 명령
		// continue : IF 문을 제외한 첫번째 영역의 종료 지점으로 이동하는 명령

		// 중첩된 반복문을 종료하기 위한 기준변수
		boolean flag = false;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {

				// i의 값이 2이고, j의 값이 3일 때 반복을 종료
				if (i == 2 && j == 3) {
					// 반복문을 종료하기 위한 기준 변수의 값을 수정
					flag = true;
					break;
				}
				System.out.printf("i -> %d, j -> %d\n", i, j);
			}
			if (flag)
				break;
			System.out.println();
		}

	}

}
