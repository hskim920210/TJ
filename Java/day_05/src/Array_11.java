import java.util.*;
public class Array_11 {

	public static void main(String[] args) {
		// 사용자에게 배열의 크기를 입력받아 배열을 생성하고,
		// 각 요소에 값을 입력받아 총점/평균을 출력
		// 최대값,최소값 출력
		// (예시)
		// 배열의 크기를 입력하세요 : 3
		// 1번째 점수 : 10
		// 2번째 점수 : 20
		// 3번째 점수 : 30
		// 입력된 점수 : < 10 20 30 >
		// 합계 : 60, 평균 : 20.00, 최대 : 30, 최소 : 10
		
		Scanner kb = new Scanner(System.in);
		
		// 1. 입력
		int array_size ;
		int [] numbers;
		
		System.out.print("배열의 크기를 입력하세요 : ");
		array_size = kb.nextInt();
		
		// 배열의 크기를 입력받은 후, 입력된 정수를 사용하여 배열을 생성
		numbers = new int[array_size];
		
		// 반복문을 사용하여 입력된 값을 배열에 저장
		for ( int i = 0 ; i < numbers.length ; i++ ) {
			System.out.printf("%d번째 점수 : ", i+1);
			numbers[i]=kb.nextInt();
		}
		
		// 2. 처리
		int tot, max, min;
		double avg;
		
		// 사용자가 입력한 정수 중 첫번째 값을 사용하여 총점, 최대, 최소값을 초기화시킨다.
		tot = max = min = numbers[0];
		
		// 배열의 첫번째 요소는 위의 코드에 의해 처리된 상태이므로 인덱스의 값을 1부터 시작
		for ( int i = 1 ; i < numbers.length ; i++ ) {
			tot += numbers[i];
			
			if ( numbers[i] > max )
				max = numbers[i];
			
			if ( min > numbers[i] )
				min = numbers[i];
		}
		avg = (double) tot / numbers.length;
		
		// 3. 출력 및 저장
		System.out.print("입력된 정수 : < ");
		for ( int i = 0 ; i < numbers.length ; i++ )
			System.out.printf("%d ", numbers[i]);
		System.out.println(">");
		
		System.out.printf("합계 : %d, 평균 : %.2f, 최대 : %d, 최소 : %d\n", tot, avg, max, min);
		
		
		
		
		
		
		
		
		
		
		
		
		/*           < 내가 하다 망한것 >
		int a, sum;
		sum = 0;
		double avg;
		int maxi, mini;
		maxi = 0;
		mini = 0;
		int max = 0; int min = 0;
		System.out.print("배열의 크기를 입력하세요 : ");
		a = kb.nextInt();
		
		int [] scores = new int[a];
		
		for ( int i = 0 ; i < scores.length ; i++) {
			System.out.printf("%d번째 점수를 입력하세요 : ", i+1);
			sum += kb.nextInt();
			
			for ( int j = 0 ; j <= i ; j++ ) {
				if (scores[i] >= scores[j]) {
					max+=i;
				} else if (scores[j] <= scores[i]) {
					min+=j;
				} mini += scores[min];
			} maxi += scores[max]; 
		}
		avg = (double) sum / scores.length;
		
		System.out.printf("합계 : %d, 평균 : %.2f, 최대 : %d, 최소 : %d", sum, avg, maxi, mini);
		
		*/
	}

}
