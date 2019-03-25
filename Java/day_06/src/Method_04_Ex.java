
public class Method_04_Ex {

	public static void gugudanByNumber(int dan, int[][] gugudan) {
		// 구구단의 결과를 2차원 배열에 저장
		for (int i = 0; i < gugudan.length; i++) {
			// 단수를 저장
			gugudan[i][0] = dan;
			gugudan[i][1] = i + 1;
			gugudan[i][2] = dan * (i + 1);
		}

//		System.out.printf("%d단 저장 실행 시작\n", i);
//		for ( int k = 1 ; k <= gugudan[i].length ; k++ ) {
//		gugudan[k][k]=i*k;
//		}
//		System.out.printf("%d단 저장 실행 완료\n", i);

	}

	public static void main(String[] args) {
		// 구구단의 결과를 저장할 수 있는 배열을 선언하세요.
		// EX) 2, 1, 2
		// 2, 2, 4
		// main 메소드에 선언된 이차원 배열을 gugudanByNumber 라는 메소드에 전달하여
		// 각 구구단의 결과를 저장하고 main 메소드에서 출력하도록 구현하세요.

		int[][] gugudan;

		for (int i = 2; i < 10; i++) {
			gugudan = new int[9][3];
			gugudanByNumber(i, gugudan);
			for (int j = 0; j < gugudan.length; j++) {
				System.out.printf("%d * %d = %d\n", gugudan[j][0], gugudan[j][1], gugudan[j][2]);
			}
		}

	}

}
