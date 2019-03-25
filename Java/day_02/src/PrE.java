import java.util.Scanner;

public class PrE {
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		char G;
		System.out.print("성별을 입력하세요. (M 또는 W) : " );
		G = kb.next().charAt(0);
		

		
		String N;
		System.out.print("이름을 입력하세요 : ");
		N = kb.next();
		
		
		int a;
		System.out.print("수학 점수 : ");
		a = kb.nextInt();
		System.out.printf("%s님(%c)께서 수학 점수를 %d점 입력하셨습니다.\n",N,G, a);
		
		int b;
		System.out.print("영어 점수 : ");
		b = kb.nextInt();
		System.out.printf("%s님(%c)께서 영어 점수를 %d점 입력하셨습니다.\n",N,G, b);
		
		int c;
		System.out.print("국어 점수 : ");
		c = kb.nextInt();
		System.out.printf("%s님(%c)께서 국어 점수를 %d점 입력하셨습니다.\n",N,G, c);
		
		int s = a + b + c;
		double g = s/3.0;
		
		char e;
		System.out.print("총점과 평균을 확인하려면 Enter를 누르세요.");
		e = kb.next().charAt(0);
		
		
		
		System.out.printf("%s님(%c)의 총점은 %d이고, 평균은 %.2f입니다.",N,G,s,g );

		
		
		
	}
}
