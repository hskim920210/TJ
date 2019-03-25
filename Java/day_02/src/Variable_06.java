
public class Variable_06 {

	public static void main(String[] args) {
		
		
		// 3과목의 성적 97 79 85
		// 3과목 성적을 변수에 저장한 후 총점과 평균 출력하기
		
		// 1. 입력 : 키보드입력, 파일입력, 네트워크 입력, 데이터베이스 ...
		// - 입력값을 저장하기 위한 변수의 선언
		int score_1 = 97;
		int score_2 = 79;
		int score_3 = 85;
		
		// 2. 처리 : 입력된 데이터를 사용하여 계산하는 작업
		// - 처리된 결과를 저장하기 위한 변수를 선언 (총점이랑 평균 저장할 변수 지정하기)
		int total = score_1 + score_2 + score_3;
		double avg1 = total/3;
		
		// 3. 출력 / 저장 / 전송
		// - 처리된 결과값을 모니터에 출력, 파일에 저장, 네트워크로 전송, 데이터베이스에 저장, 프린터에 출력, ...
		// printf 메소드를 사용하는 경우 자리수를 지정하여 출력할 수 있다.
		// %자리수의 정수값 : 정수값만큼 자리를 차지하여 출력 (음수의 값이 입력되는 경우 좌측정렬로 출력)
		System.out.printf("총점 : %-5d점, 평균 : %-7.2f점\n", total, avg1);
		// %뒤의 숫자는 총 자릿수, .2는 소숫점 뒤로 2자리까지만 출력
		
		
		
		
		// 내가 한 것
		
		int a = 97;
		int b = 79;
		int c = 85;
		
		int sum = a + b + c;
		int avg2 = (a + b + c)/3;
		
		System.out.printf("총점은 %d, 평균은 %d 이다.\n", (a+b+c), (a+b+c)/3);
		System.out.printf("총점은 %d, 평균은 %d 이다.\n", sum, avg2);

		
		
		
		System.out.println("총점은 " + (a+b+c) + "이고, 평균은 " + (a+b+c)/3 + "이다.");
		System.out.println("총점은 " + sum + "이고, 평균은 " + avg2 + "이다.");
		
		
		
		
		
		
		
	}

}
