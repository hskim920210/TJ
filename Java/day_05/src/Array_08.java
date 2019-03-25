import java.util.*;
public class Array_08 {

	public static void main(String[] args) {
		// 3 과목의 성적을 입력받아, 총점과 평균을 출력
		Scanner kb = new Scanner(System.in);
		
		int s1,s2,s3;
		System.out.print("1번째 성적 : ");
		s1=kb.nextInt();
		System.out.print("2번째 성적 : ");
		s2=kb.nextInt();
		System.out.print("3번째 성적 : ");
		s3=kb.nextInt();
		
		int tot = s1 + s2 + s3;
		double avg = (double) tot / 3;
		
		System.out.printf("총점 : %d 점, 평균 : %.2f 점\n", tot, avg);
		

	}

}
