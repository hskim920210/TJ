
public class Operator_03 {

	public static void main(String[] args) {
		// 논리연산자
		// 다수개의 관계식을 조합하여 하나의 boolean 값을 반환할 수 있는 연산자
		// AND(&&), OR(||), NOT(!)
		
		// AND 연산자 (&&)
		// 좌항과 우항의 관계식의 결과가 모두 참(true)인 경우만 true를 반환하는 연산자
		// 좌항의 결과가 false 인 경우 우항의 식을 비교하지 않는다. (dead code)
		System.out.printf("%5b && %5b -> %5b\n", false, false, false && false);
		System.out.printf("%5b && %5b -> %5b\n", false, true, false && true);
		System.out.printf("%5b && %5b -> %5b\n", true, false, true && false);
		System.out.printf("%5b && %5b -> %5b\n", true, true, true && true);
		System.out.println("false && false -> " + (false && false));
		
		// OR 연산자 (||)
		// 좌항과 우항의 관계식 중 하나라도 결과가(true)인 경우 true를 반환하는 연산자
		// 좌항의 결과가 true 인 경우 우항의 식을 비교하지 않는다. (dead code)
		System.out.printf("%5b || %5b -> %5b\n", false, false, false || false);
		System.out.printf("%5b || %5b -> %5b\n", false, true, false || true);
		System.out.printf("%5b || %5b -> %5b\n", true, false, true || false);
		System.out.printf("%5b || %5b -> %5b\n", true, true, true || true);
	
		// Not 연산자 (!)
		// 단항연산자 ( 하나의 식을 부정. 피연산자가 1개)
		// 관계식의 결과를 부정하는 값을 반환
		// ture -> false, false -> true
		System.out.printf("!%5b -> %5b\n", false, !false);
		System.out.printf("!%5b -> %5b\n", true, !true);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// 1. 입력
		int age = 22;
		int gender = 2; // 1 또는 3인 경우 남자, 2 또는 4인 경우 여자
		
		// 위의 두 변수를 사용하여 나이가 20대 이고 성별이 여자인 경우 판단하는 식을 작성하고 결과를 확인

		// 2. 처리
		boolean r1 = 20<=age && age<30; // 20대 여부를 판단
		boolean r_1 = age / 10 == 2; // 더 간단히 20대 여부를 판단.
		
		boolean r2 = gender == 2 || gender == 4; // 성별을 확인
		boolean r3 = r1 && r2;
		
		// 3. 출력
		System.out.printf("나이가 20대이고 성별이 여자인가? -> %5b\n", r3 ); //출력

	}

}
