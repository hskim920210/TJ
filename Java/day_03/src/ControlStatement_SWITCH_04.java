import java.util.Scanner;
public class ControlStatement_SWITCH_04 {

	public static void main(String[] args) {
		// 사용자로부터 3개의 성적 점수 입력받아 총점과 평균을 출력하세요. (키보드 입력을 사용)
		
		// 평균점수를 사용하여 성적의 평가를 출력하세요.
		// 90점 이상은 A, 80 B, 70 C, 60 D , 60 미만은 F
		
		Scanner kb = new Scanner(System.in);
		
		int a;
		System.out.print("첫번째 점수를 입력하세요. ");
		a = kb.nextInt();
		
		int b;
		System.out.print("두번째 점수를 입력하세요. ");
		b = kb.nextInt();
		
		int c;
		System.out.print("세번째 점수를 입력하세요. ");
		c = kb.nextInt();
		
		kb.close();

		int d = a + b + c;
		double e = d/3.0;
		double f = e/10;
		char grade;
		
		// 평균점수를 저장하고 있는 e는 실수형 double 이므로 switch 문에 전달될 수 없다.
		// 강제 형변환을 통해 정수형으로 변경한다.
		// 평균점수의 범위가 직접 작성하기에 힘드므로 범위를 축소
		// 평균점수를 정수형으로 변환한 후, /10 을 하여 10의자리만 추출
		// 평균점수는 0~10으로 압축
		// 99/10->9
		// 9/10->0	
		
		// e가 100보다 크거나 0보다 작을땐 -1, 그렇지 않으면 (int)e/10
		// 삼항 연산자로 정해준다. Operator_09.java 참고.
		switch( e>100 || e<0 ? -1 : (int)e / 10 ) {
			// 100점과 90점대의 평가를 한 곳에 처리
			case 10 :
			case 9 : grade = 'A'; break;
			case 8 : grade = 'B'; break;
			case 7 : grade = 'C'; break;
			case 6 : grade = 'D'; break;
			// 50 40 30 20 10 0 점 대의 평가를 한 곳에 처리
			case 5 :  
			case 4 :  
			case 3 :  
			case 2 :  
			case 1 :  
			case 0 : grade = 'F'; break; 
				default :
					grade = '?';
		}
			if (grade != '?')
				System.out.printf("성적 평가는 %c 입니다.\n", grade);
			else
				System.out.printf("(ERROR) 성적 점수를 확인하세요 (%.2f)\n", e);
			
			/* (내가 한 방법)
			switch ((int)f) {
				case 10 :
					if(f==10.0)
						System.out.println("성적 : 'A'");
					else
						System.out.println("ERROR : 점수를 잘못입력했습니다.");
					break;
				case 9 :
					System.out.println("성적 : 'A'");
					break;
				case 8 :
					System.out.println("성적 : 'B'");
					break;
				case 7 :
					System.out.println("성적 : 'C'");
					break;
				case 6 :
					System.out.println("성적 : 'D'");
					break;
				case 5 :
					System.out.println("성적 : 'F'");
					break;
				case 4 :
					System.out.println("성적 : 'F'");
					break;
				case 3 :
					System.out.println("성적 : 'F'");
					break;
				case 2 :
					System.out.println("성적 : 'F'");
					break;
				case 1 :
					System.out.println("성적 : 'F'");
					break;
				case 0 :
					System.out.println("성적 : 'F'");
					break;
				default :
					System.out.println("ERROR : 점수를 잘못입력했습니다.");
					break;
				*/
		
	}

}
