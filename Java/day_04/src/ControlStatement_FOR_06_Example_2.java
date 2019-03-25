import java.util.*;

public class ControlStatement_FOR_06_Example_2 {

	public static void main(String[] args) {
		// 사용자에게 정수 한개를 입력받는다.
		// - 정수는 1000 이상의 값을 입력받아야.
		// - 1000 미만의 값을 입력하면 다시 입력받아야.

		Scanner kb = new Scanner(System.in);
		int num;

		for (;;) {
			System.out.print("1000 이상의 정수를 입력하세요. : ");
			num = kb.nextInt();
			if (num >= 1000)
				break;
		}

		// 1000 이상의 값이 올바르게 입력된 경우
		// 1에서 입력된 값까지의 3의 배수들의 합계를 계산.
		// 합계에 사용된 3의 배수의 개수?

		int tot = 0, count = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 3 == 0) {
				// 합계
				tot += i;
				// 카운팅
				count++;
			}
		}
		System.out.printf("1 ~ %d까지의 3의 배수들의 합계는 %d,\n", num, tot);
		System.out.printf("1 ~ %d까지의 3의 배수들의 개수는 %d,\n", num, count);
	}

}
