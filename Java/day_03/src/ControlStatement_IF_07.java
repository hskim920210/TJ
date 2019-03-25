import java.util.Scanner;


public class ControlStatement_IF_07 {

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
		
		System.out.printf("\n입력하신 점수는 %d점, %d점, %d점으로\n총점은 %d이고 평균은 %.2f입니다.\n",a,b,c, d, e);
		
		if ( e >= 90 && e <= 100 )
			System.out.print("\n당신의 성적은 A입니다.");
		else if ( e >= 80 && e < 90)
			System.out.print("\n당신의 성적은 B입니다.");
		else if ( e >= 70 && e < 80)
			System.out.print("\n당신의 성적은 C입니다.");
		else if ( e >= 60 && e < 70)
			System.out.print("\n당신의 성적은 D입니다.");
		else if ( e < 60)
			System.out.print("\n당신의 성적은 F입니다."); // 메세지를 바꾸고 싶을 때 중복되는 출력을 다바꿔줘야해서 불편하다.
		
		// 특정 범위를 비교하여 if 문을 처리하는 경우의 처리방법
		// 1. 이상치 데이터를 비교
		// 2. 높은 데이터(낮은 데이터) 순으로 비교를 수행
		char grade;
		if (e<0 || e>100)
			grade = '?';
		else if (e>=90)
			grade = 'A';
		else if (e>=80)
			grade = 'B';
		else if (e>=70)
			grade = 'C';
		else if (e>=60)
			grade = 'D';
		else 
			grade = 'F';
		
		
		
		
		
		// 성적 처리 코드
		/*
		char grade;
		
		if ( e >= 90 && e <= 100 )
			grade = 'A';
		else if ( e >= 80 && e < 90 )
			grade = 'B';
		else if ( e >= 70 && e < 80 )
			grade = 'C';
		else if ( e >= 60 && e < 70 )
			grade = 'D';
		else
			grade = 'F';
		*/
		
		if (grade != '?')
			System.out.printf("\n성적 평가는 '%c'입니다.\n", grade);
		else
			System.out.printf("\n(ERROR)성적점수를 확인하세요. (%.2f)\n",e);
	}

}
