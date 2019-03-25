import java.util.*;
public class Array_10 {

	public static void main(String[] args) {
		// 배열의 크기는 프로그램에서 중요한 정보이다.
		// 배열의 크기에 따라 반복의 횟수나 특정 인덱스의 값을 참조하는 것이 수시로 바뀌기 때문이다.
		// 배열은 이러한 문제를 해결하기 위해 length 라는 속성을 제공한다.
		// 배열의 이름.length -> 배열의 크기가 정수타입으로 리턴.
		
		
		// 3 과목의 성적을 입력받아, 총점과 평균을 출력
		// (배열을 활용하여 처리)
		Scanner kb = new Scanner(System.in);
		// 성적점수를 저장하기 위한 배열 선언
		int [] scores = new int[5];
		// 총점을 저장하기 위한 변수
		// (반복을 통해서 누적되기 때문에 반드시 초기화 !)
		int tot = 0;
		double avg ;
		for ( int i = 0 ; i < scores.length ; i++ ) { // scores라는 배열이 가진 크기값으로 바뀜
			System.out.printf("%d번째 성적 : ", i+1);
			// 인덱스의 값을 변경하면서 값을 입력
			scores[i] = kb.nextInt();
			// 입려된 값을 총점에 누적
			tot += scores[i];
		}
		avg = (double) tot / scores.length;
		
		System.out.printf("총점 : %d 점, 평균 : %.2f 점\n", tot, avg);
		

	}

}
