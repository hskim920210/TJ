
public class Method_01_Ex {

	public static void gugudan() {
		System.out.println("");
		for (int i = 2; i <= 9; i++) {
			System.out.printf("%d단을 출력합니다.\n", i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// 전체 구구단을 출력할 수 있는 gugudan 메소드를 정의하고 해당 메소드를 호출하여 구구단의 출력 결과를 확인하기.

		System.out.println("프로그램 시작");

		gugudan();

		System.out.println("프로그램 종료");

	}

}
