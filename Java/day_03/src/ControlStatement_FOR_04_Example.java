import java.util.Scanner;
public class ControlStatement_FOR_04_Example {

	public static void main(String[] args) {
		// 사용자에게 3개의 정수를 입력받아 입력된 정수의 합계, 평균, 최대값, 최소값을 출력
		// 값의 입력은 반복문으로 처리
		
		
		// 1. 입력 및 처리
		Scanner kb = new Scanner(System.in);
		// 3개의 정수값을 입력받기 위한 num 변수
		int num;
		// 합계, 최대값, 최소값
		// 합계변수는 값을 누적해야 하므로 반드시 초기화가 필요하다.
		int sum = 0, max = 0, min = 0;
		// 평균
		double avg;
		
		for (int i = 1 ; i <= 3 ; i++) {
			System.out.printf("%d 번째 정수 입력 : ", i);
			num = kb.nextInt();
			sum += num;
			
			// 최대값과 최소값을 계산하는 코드
			// 주의사항 : 최대값과 최소값을 구하기 위해서 입력되는 값 중 최초로 입력된 값으로 초기화를 진행해야 한다.
			if ( i == 1 ) {
				max = min = num;
			} else {
				if ( num > max )
					max = num;
				if ( min > num )
					min = num;
			}
		}
		avg = (double)sum/3;
		
		
		
		System.out.printf("합계 : %d, 평균 : %.2f\n", sum, avg);
		System.out.printf("최대 : %d, 최소 : %d\n", max, min);
		
				
				
		/*
		System.out.print("첫번째 점수 : ");
		a = kb.nextInt();
		System.out.print("두번째 점수 : ");
		*/

	}

}
