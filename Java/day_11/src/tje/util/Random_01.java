package tje.util;

// 난수를 사용하여 임의의 수를 반환할 수 있는 클래스
// 난수 : 0 ~ 1 사이의 수
// (0 과 1은 포함되지 않음)
import java.util.Random;

public class Random_01 {

	public static void main(String[] args) {
		// Random r1 = new Random();
		// 생성자 매개변수로 seed 값을 설정하는 경우
		// 실행할 때마다 동일한 랜덤값이 반환됨
		
		Random r1 = new Random(10);
		
		double a = Math.random();
		
		System.out.println(a);
		for ( int i = 0 ; i < 10 ; i++ ) {
//			// Random 클래스의 nextInt 메소드
//			// 난수를 사용하여 임의의 정수를 반환하는 메소드
//			// 매개변수를 사용하지 않는 경우 범위가 정해지지 않은
//			// 임의의 숫자가 반환
//			// 반환되는 값의 범위 : 난수 * 매개변수
//			// (int)(Math.random()*45+1)
//			// nextInt(45)+1
			
//			int random_number = r1.nextInt();
//			System.out.printf("%d : %d\n", i+1, random_number);
			
			int random_number = r1.nextInt(7);
			System.out.printf("random_number -> %d\n", random_number);
		}
		
		

	}

}
