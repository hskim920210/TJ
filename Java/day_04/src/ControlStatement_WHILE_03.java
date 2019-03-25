
public class ControlStatement_WHILE_03 {

	public static void main(String[] args) {
		// while 문을 사용하여 구구단 출력


		int i = 2;
		int j = 1;

		while (i <= 9) {
			System.out.printf("%d단을 시작합니다.\n", i);
			while (j <= 9) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
				j++;
			}
			j = 1;
			System.out.println();
			i++;
		}
		
		System.out.println("구구단 종료");

	}

}
