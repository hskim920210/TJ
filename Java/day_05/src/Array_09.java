import java.util.*;
public class Array_09 {

	public static void main(String[] args) {
		// 3 과목의 성적을 입력받아, 총점과 평균을 출력
		// (배열을 활용하여 처리)
		Scanner kb = new Scanner(System.in);
		// 성적점수를 저장하기 위한 배열 선언
		int [] scores = new int[3];
		// 총점을 저장하기 위한 변수
		// (반복을 통해서 누적되기 때문에 반드시 초기화 !)
		int tot = 0;
		double avg ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			System.out.printf("%d번째 성적 : ", i+1);
			// 인덱스의 값을 변경하면서 값을 입력
			scores[i] = kb.nextInt();
			// 입려된 값을 총점에 누적
			tot += scores[i];
		}
		avg = (double) tot / 3;
		
		System.out.printf("총점 : %d 점, 평균 : %.2f 점\n", tot, avg);
		

	}

}
