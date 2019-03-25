
public class Array_02 {

	public static void main(String[] args) {
		// STACK 메모리 영역 종이컵 버리는것 생각하면됨
		// 프로그램의 구동 중 생성되는 지역변수들이 저장되는 영역
		// 1. 모든 지역변수들이 저장
		// 2. 초기화가 지원되지 않음
		// 3. 특정 메소드가 실행될 때 사용되는 공간
		// 4. 메소드의 실행이 종료되면 자동으로 해제되는 공간
		
		// STACK에 저장되는 지역변수의 선언
		int local;
		
		// STACK에 저장되는 변수는 초기화가 지원되지 않기 때문에 반드시 초기화를 한 이후에 사용해야 한다.
		// System.out.println(local);
		
		local = 0;
		System.out.println(local);
	}

}
