import java.util.*;
public class Day05_Exercise {

	public static void main(String[] args) {
		// 5장
		
		// 1번 
		// 참조타입 변수의 메모리 생성 위치는 스택이 아닌 힙 영역이다.
		
		// 2번
		// 자바에서 참조되지 않는 객체는 직접 소멸코드를 작성하지 않아도 JVM에서 자동으로 제거한다.
		
		// 3번
		// 동일한 리터럴이어도 new로 생성한 String은 String으로 생성한 리터럴과 다른 객체를 참조한다.
		
		// 4번
		// 배열을 이미 선언 한 후 다른 실행문에서 중괄호를 사용한 배열 생성은 불가능하다.
		// 배열 변수를 미리 선언한 후 값을 나중에 결정하는 상황이라면 
		// 변수 = new int[] {값0,값1,...,값N} 과 같이 new와 중괄호를 사용한다.
		
		// 5번
		// boolean 타입의 배열의 초기값은 true가 아닌 false이다.
		
		
		
		// 6번
		int[][] array_06 = { {95,86}, {83,92,96}, {78,83,93,87,88} };
		// 이 때, array_06.length는 3이고, array[2].length는 5이다.
		System.out.println(array_06.length);
		System.out.println(array_06[2].length);
		
		
		
		// 7번
		int max_07 = 0;
		int[] array_07 = { 1, 5, 3, 8, 2 };
		
		for ( int i = 0 ; i < array_07.length; i++) {
			boolean b = array_07[i] > max_07;
			if ( b ) {
				max_07 = array_07[i];
			}
		}
		System.out.printf("최대값은 %d이다.\n", max_07);
		
		
		
		// 8번
		int[][] array_08 = { {95,86}, {83,92,96}, {78,83,93,87,88} };
		int sum_08 = 0;
		double avg_08 = 0.0;
		
		for ( int i = 0 ; i < array_08.length ; i++) {
			for ( int j = 0 ; j < array_08[i].length ; j++) {
				sum_08 += array_08[i][j];
			}
			
		}
		avg_08 = (double)sum_08/10;
		
		System.out.printf("총 합 : %d, 평균 : %.2f \n", sum_08, avg_08);
		
		
		
		// 9번
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		int min = 0;
		Scanner scanner = new Scanner(System.in);
		
		while (run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("------------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				System.out.print("학생수 : ");
				studentNum = scanner.nextInt();
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for ( int i = 0 ; i < scores.length ; i++ ) {
					System.out.printf("%d번 학생의 점수 입력 : ", i+1);
					scores[i] = scanner.nextInt();
				}
				for ( int i = 0 ; i < scores.length ; i++ ) {
				sum += scores[i];
				}
				avg = (double)sum/scores.length;
			} else if (selectNo == 3) {
				for ( int i = 0 ; i < scores.length ; i++) {
					System.out.printf("%d번째 학생의 성적 : %d\n", i+1, scores[i]);
				}
			} else if (selectNo == 4) { 
				for ( int i = 0 ; i < scores.length ; i++) {
					if ( scores[i] > max) {
						max = scores[i];
					} else if ( scores[i] < min ) {
						min = scores[i];
					}
				}
				System.out.printf("최고점수 : %d점\n평균점수 : %.2f점\n", max, avg);
			} else if (selectNo == 5) {
				run = false;
						System.out.println("프로그램 종료");
			}
		}
		
		

	}

}
