
public class Variable_07 {

	public static void main(String[] args) {
		
		
		// 3과목의 성적 97 79 85
		// 3과목 성적을 변수에 저장한 후 총점과 평균 출력하기
		
		// 1. 입력 : 키보드입력, 파일입력, 네트워크 입력, 데이터베이스 ...
		// - 입력값을 저장하기 위한 변수의 선언
		int score_1 = 97;
		int score_2 = 80;
		int score_3 = 85;
		
		// 2. 처리 : 입력된 데이터를 사용하여 계산하는 작업
		// - 처리된 결과를 저장하기 위한 변수를 선언 (총점이랑 평균 저장할 변수 지정하기)
		int total = score_1 + score_2 + score_3;
		// 나누기 연산 시 주의사항.
		// /연산의 좌항과 우항이 모두 정수인 경우 반환되는 값은 정수가 된다. (소수점 이하는 무시됨)
		// 만약 소수점 이하의 값이 필요하다면 / 연산의 좌항 또는 우항을 실수형으로 변경해야함. (강제 형변환을 사용)
		// (double)(total/3)은 이미 괄호가 먼저 계산되어 정수가 됨. 그래서 total 또는 3 둘중 하나에 더블을 붙여준다.
		double avg = total/(double)3;
		double avg1 = (double)total/(double)3;
		double avg2 = (double)total/3;
		
		System.out.printf("총점 : %-5d점, 평균 : %-7.2f점\n", total, avg);
		System.out.printf("총점 : %-5d점, 평균 : %-7.2f점\n", total, avg1);
		System.out.printf("총점 : %-5d점, 평균 : %-7.2f점\n", total, avg2);
		
		System.out.printf("%3.2f",(double)2/3);
	}

}
