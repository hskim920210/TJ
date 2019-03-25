
public class ControlStatement_FOR_05 {

	public static void main(String[] args) {
		// break 키워드
		// switch 문과 반복문에서 사용할 수 있는 키워드
		// 현재 실행중인 영역을 빠져나가는 명령
		// (break 키워드를 감싸는 첫번째 영역이 if 문인 경우 무시되고 한단계 위의 영역을 빠져나감)

		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.printf("i=%d\n", i);
		}

	}

}
