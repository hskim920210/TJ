
public class Operator_02 {

	public static void main(String[] args) {
		// 관계연산자
		// 좌항과 우항의 크기를 비교하여 true(참) / false(거짓) 값을 반환하는 연산자.
		// >, <, >=(이상), <=(이하), ==(같음. =은 변수대입에 쓰여서), != (같지 않다. !는 not의 의미)
		// 관계식의 정의가 올바른 경우 true 반환, 틀린 경우 false가 반환
		int n1 = 10;
		int n2 = 5;
		boolean result;
		
		result = n1>n2;
		// printf 메소드의 %b는 boolean 타입의 값을 출력할 수 있다.
		System.out.printf("%d %s %d = %b\n", n1, ">", n2, result);
		System.out.println(n1 + " > " + n2 + " = " + result);
		
		result = n1<n2;
		System.out.printf("%d %s %d = %b\n", n1, "<", n2, result);
		
		result = n1>=n2;
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		
		result = n1<=n2;
		System.out.printf("%d %s %d = %b\n", n1, "<=", n2, result);
		
		result = n1==n2;
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result);
		
		result = n1!=n2;
		System.out.printf("%d %s %d = %b\n", n1, "!=", n2, result);
		
		
		
		
		
		
		
		
		

	}

}
