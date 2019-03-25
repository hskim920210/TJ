
public class ControlStatement_FOR_10_Example_03 {

	public static void main(String[] args) {
		// 중첩된 구조의 반복문의 예제
		// 구구단 출력

		// 외부의 반복문
		// 단수를 제어하는 반복문 ( 2 ~ 9까지 반복 )

		// 2의 배수들의 곱만 출력
		for (int i = 2; i <= 9; i++) {
			System.out.printf("%d 단을 출력합니다.\n", i);
			// 내부의 반복문
			// 단수에 곱해지는 수를 제어하는 반복문 ( 1 ~ 9까지 반복 )
			for (int j = 1; j <= 9; j++) {

				/*
				 * if ( (i%2==0 && j%2==0) || (i%2==1 && j%2==1) ) {
				 * System.out.printf("%d * %d = %d\n",i ,j, i*j); }
				 */
				// boolean flag_even = i % 2 == 0 && j % 2 == 0;
				// boolean flag_odd = i % 2 == 1 && j % 2 == 1;
				// if (flag_even || flag_odd)
				// System.out.printf("%d * %d = %d\n", i, j, i * j);
				
				
				if (i % 2 == j % 2)
					System.out.printf("%d * %d = %d\n", i, j, i * j);

			}
			System.out.println();
		}
	}
}
