package tje.exception;

// 특정 메소드에서 논리적인 문제가 발생한 경우
// 강제로 예외를 생성하여 해당 예외를
// 메소드를 호출한 지점으로 반환시키는 방법
// throw와 throws 키워드를 활용
// throw 키워드는 우항에 생성된 예외처리클래스의 객체를 사용하여
// 실제 예외를 발생시키는 키워드
// throws 키워드는 메소드의 선언부에 지정되며
// 현재 메소드에서 발생할 가능성이 예외클래스를 지정
// throws 에 지정된 예외가 메소드 내부에서 발생되면
// 예외를 메소드를 호출한 지점으로 반환합니다.

public class Exception_13 {
	
	// 짝수인 경우만 출력을 실행하는 print 메소드의 정의
	// 만약 짝수가 전달되지 않은 경우
	// 예외를 발생시킴
	
	// throws 키워드
	// 특정 메소드의 실행 결과로 예외 객체가 반환될 가능성이 있는 경우
	// 메소드를 호출하는 쪽에서 사전에 예외 타입을 확인할 수 있도록 정의하는 문법
	// 만약 메소드의 내부에서 강제로 발생시키는 예외의 타입이
	// Exception 클래스 타입인 경우, 반드시 throws 를 통해
	// 예외를 정의해야만 메소드 내부에서 try ~ catch를 사용하지 않아도 된다.
	public static void print(int number) throws RuntimeException{
		if( number % 2 == 0 )
			System.out.printf("짝수가 입력되어 출력을 실행함");
		else {
			// 짝수가 입력되지 않은 경우 해당 메소드를 호출한 지점으로
			// 예외 객체를 반환하여 문제를 알림
			
			// 예외객체를 생성할 때 사용할 수 있는 부모클래스
			// 1. Exception 클래스
			// - 모든 예외 처리 클래스의 최상위 부모 클래스
			// - Exception 클래스를 직접 상속받는 자식 예외처리 클래스는
			//   반드시 명시적으로 예외를 처리해야만 문법에 문제가 없다.
			// throw new Exception("짝수만 전달하세요 !!!");
			
			// 2. RuntimeException 클래스
			// - 대다수 예외처리 클래스의 부모클래스
			// - RuntimeException 클래스를 직접 상속받는 자식 예외처리 클래스는
			//   명시적으로 예외를 처리하지 않아도 문법상 에러가 없다.
			throw new RuntimeException("짝수만 전달하세요 !!!");
		}
	}

	public static void main(String[] args) {
		print(11);
	}

}
