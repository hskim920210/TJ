// 제어문
// - 실행 코드의 흐름을 제어할 수 있는 문법
// 1. 분기문
// - 조건식의 결과에 따라서 실행문의 실행 여부를 제어하는 문법
// - if, switch
// 2. 반복문
// - 조건식의 결과에 따라서 실행문의 반복 여부를 제어하는 문법
// - for, while, do ~ while


public class ControlStatement_IF_01 {

	public static void main(String[] args) {
	
		// if문
		// 조건식을 기준으로 참일 경우와 거짓일 경우의 실행을 분기할 수 있는 문법
		// (삼항 연상자는 조건식의 결과에 따라서 값이 변경)
		// (if의 경우 조건식의 결과에 따라서 실행문의 실행 여부가 결정)
		
		// 형식
		// if( 조건식 - true/false의 값으로 분리되는 식 )
		//		조건식이 참일 경우의 실행문;
		
		int number = 17;
		
		if ( number % 2 == 0 ) // 나머지 연산의 결과가 0인 경우에만 실행
			System.out.printf("짝수 입니다.\n");
		if ( number % 2 == 1 ) // 나머지 연산의 결과가 1인 경우에만 실행
			System.out.printf("홀수 입니다.\n");
		
		// 주민등록번호의 7번째 자리의 정수
		int gender = 3;
		
		if ( gender == 1 || gender == 3 )
			System.out.printf("남자 입니다.\n");
		if ( gender == 2 || gender == 4 )
			System.out.printf("여자 입니다.\n");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
