
public class ControlStatement_FOR_10 {

	public static void main(String[] args) {
		// 중첩된 구조의 반복문의 예제
		// 구구단 출력

		// 외부의 반복문
		// 단수를 제어하는 반복문 ( 2 ~ 9까지 반복 )
		for (int i = 2; i <= 9; i++) {

			// 내부의 반복문
			// 단수에 곱해지는 수를 제어하는 반복문 ( 1 ~ 9까지 반복 )
			for (int j = 1; j <= 9; j++) {

				System.out.printf("%d * %d = %d\n", i, j, i * j);

			}
		}
	}
}
