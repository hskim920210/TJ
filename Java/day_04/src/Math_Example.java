
public class Math_Example {

	public static void main(String[] args) {
		// 난수를 사용한 랜덤 숫자 추출
		// 1. Math 클래스의 random 메소드를 사용
		// 2. java.util.Random 클래스를 사용
		
		// 난수 : 무작이뤼로 추출되는 임의의 수
		// (0 보다 크고 1보다 작은 수)
		// Math.random()를 사용하여 double 타입의 난수를 반환받을 수 있음
		
		// 난수를 사용해서 1 ~ 6 사이의 값을 생성
		// 난수 * 6 -> 0 ~ 6 사이의 값이 생성 ( 0, 6은 나오지 않음)
		// 난수 * 6 + 1 -> 1 ~ 7 사이의 수가 생성
		// (int)(난수 * 6 + 1 ) -> 1 ~ 6에 해당하는 정수 반환
		
		for ( int i = 1 ; i <= 10 ; i++ ) {
			int r1, r2;
			r1 = (int)(Math.random()*6+1);
			r2 = (int)(Math.random()*6+1);
			System.out.printf("r1 : %d, r2 : %d\n", r1, r2);
		}

	}

}
