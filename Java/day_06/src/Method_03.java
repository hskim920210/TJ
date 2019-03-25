
public class Method_03 {
	
	// Call By Value 방식의 메소드 호출
	// 메소드를 호출할 때 전달하는 매개변수가 값인 경우를 의미 ( int, float, double ...)
	// 아래의 setNum 메소드를 실행하기 위해 main 메소드의 num 변수가 가진 10을 념겨주고,
	// setNum 메소드에서 해당 값을 777으로 수정했지만,
	// main 메소드의 num 변수의 값은 변경되지 않는다.
	// 값만 전달하는 메소드 호출이었기 때문에 .. (Stack 메모리의 구조 참고)
	
	// 1. 메소드의 매개변수는 지역변수다.
	// 2. 서로 다른 메소드에서 동일한 이름의 변수를 생성하는 것이 가능하다.	
	public static void setNum(int num) {
		num = 777;
		System.out.printf("(setNum) num = %d\n",num);
	}

	public static void main(String[] args) {
		
		int num = 10;
		
		System.out.printf("(main) num = %d\n",num);
		
		setNum(num);
		
		System.out.printf("(main) num = %d\n",num);
		
		System.out.println("프로그램 종료");
		

	}

}
