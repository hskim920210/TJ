
public class ControlStatement_FOR_13 {

	public static void main(String[] args) {
		// 중첩된 구조의 반복문에서의 break, continue
		// break : IF 문을 제외한 첫번째 영역을 빠져나가는 명령
		// continue : IF 문을 제외한 첫번째 영역의 종료 지점으로 이동하는 명령

		// 중첩된 반복문을 종료하기 위한 라벨

		boolean flag = false;

		out: for (int i = 1; i <= 3; i++) {

			in: for (int j = 1; j <= 3; j++) {

				// out 영역을 빠져나가는 명령
				// break out;
				// out 영역의 종료지점으로 이동
				if (i == 2 && j == 2) {
					continue out;
				}
				System.out.printf("i -> %d, j -> %d\n", i, j);
			}
			System.out.println();
		} // countinue out; 은 이 중괄호 왼쪽으로 이동됨. 이제 다시 i++ 한 뒤 i <== 3 인지 확인

	}

}
