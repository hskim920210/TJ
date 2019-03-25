import java.util.*;
public class Array_18 {

	public static void main(String[] args) {
		// 3명의 학생 성적을 처리할 수 있는 프로그램
		// 성적은 5과목, 사용자가 입력한 값으로 저장
		// 모든 학생의 입력이 끝난 후 각 학생의 총점과 평균  출력
		// 2차원 배열을 사용
		
		Scanner kb = new Scanner(System.in);
		
		// 학생들의 성적을 저장하기 위한 2차원 배열
		int [][] scores = new int [3][5];
		// 각 학생들의 총점을 저장하기 위한 1차원 배열
		int [] tot = new int [3];
		// 각 학생들의 평균을 저장하기 위한 1차원 배열
		double [] avg = new double [3];
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			System.out.printf("%d번째 학생 성적을 입력합니다.\n", i+1);
			for ( int j = 0 ; j < 5 ; j ++ ) {
				System.out.printf("%d번째 성적을 입력 : ", j+1);
				scores[i][j] = kb.nextInt();
				// 각 성적의 입력 후 총점 배열에 누적
				tot[i] += scores[i][j];
			}
			avg[i] = (double)tot[i]/5;
		}
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			System.out.printf("%d번째 학생의 총점 : %d점, 평균 : %.2f점\n", i+1, tot[i], avg[i]);
		}
		
		
		/* < 내가 한것 >
		int[][] array_scores = new int[3][5];
		double avg;
		
		
		int [][] array_tot = new int [1][3];
		
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			
			for ( int j = 0 ; j < 5 ; j++ ) {
				
				System.out.printf("%d번째 학생의 %d번째 과목 성적 : ", i+1, j+1);
				array_scores[i][j] = kb.nextInt();
				array_tot[0][0] += array_scores[0][j];
				array_tot[0][1] += array_scores[1][j];
				array_tot[0][2] += array_scores[2][j];

			}
			System.out.printf("%d번째 학생의 총점은 %d점, 평균은 %.2f점 입니다.\n\n", i+1, array_tot[0][i], array_tot[0][i]/3.0);
		}
		*/
	}

}
