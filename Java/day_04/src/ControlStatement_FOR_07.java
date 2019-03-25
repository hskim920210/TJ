
public class ControlStatement_FOR_07 {

	public static void main(String[] args) {
		// continue 키워드
		// if 문을 제외한 첫번째 영역의 종료지점으로 이동하는 명령 ( 빠져나가는 것이 아님 )
		// 반복문에서만 사용할 수 있다.
		// 반복문 내부에서 continue 키워드를 사용하면 현재의 반복을 중지하고 다음 반복으로 이동(건너뛰는)할 수 있다.

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1)
				continue;
			System.out.printf("i = %d\n", i);
		} // 브레이크는 반복문 마지막 중괄호 우측으로 이동, 컨티뉴는 반복문 마지막 중괄호 좌측으로 이동.

	}

}
