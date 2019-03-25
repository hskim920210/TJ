
public class ControlStatement_FOR_04 {

	public static void main(String[] args) {
		// 1 ~ 100 까지 정수들의 합계
		// 1 + 2 + 3 + ... + 100 = ?
		
		// 반복문을 사용하여 값을 누적하는 방법. 특정 변수에 연산의 결과를 반복해서 대입
		// 아래와 같잉 for 문에서 변수를 생성하는 경우 누적된 값을 for 문의 외부에서 사용할 수 없다.
		// for ( int i = 1 , sum = 0 ; i <= 100 ; i++ )
		//	sum += i;
		
		// for 문이 종료된 이후에도 특정 변수의 값을 사용하기 위해서는 for 문의 외부에서 변수를 생성해야 한다.
		int sum = 0;
		for ( int i = 1 ; i <= 10000 ; i++ )
				sum += i;
		
		System.out.printf("1 ~ 100 까지 정수들의 합계는 %d 입니다.\n", sum);

	}

}
