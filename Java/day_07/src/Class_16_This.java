
class ThisD {
	private int num1;
	private int num2;
	private int num3;

	public ThisD(int num1) {
		this.num1 = num1;
	}

	public ThisD(int num1, int num2) {
		// num1을 초기화 하는 코드가 중복되는 모습
		// this.num1 = num1;
		
		// num1 을 초기화하는 코드가 중복되는 모습
		// this.num1 = num1;
				
		// 생성자 사이에는 this를 활용하여 생성자간 
		// 호출을 할 수 있습니다.
		// this(생성자의 매개변수 ...)
				
		// 현재 클래스의 int 타입을 1개 전달받는 
		// 생성자를 호출
		this(num1); // 현재 내가 가진 생성자중에 인트타입 1개를 전달받는 생성자를 가져와라
		this.num2 = num2;
	}

	public ThisD(int num1, int num2, int num3) {
		// num1과 num2를 초기화 하는 코드가 중복되는 모습
		// this.num1 = num1;
		// this.num2 = num2;
		
		// 생성자 사이에는 this를 활용하여 생성자간 
		// 호출을 할 수 있습니다.
		// this(생성자의 매개변수 ...)
						
		// 현재 클래스의 int 타입을 1개 전달받는 
		// 생성자를 호출
		this(num1,num2); // 현재 내가 가진 생성자중에 인트타입 2개를 전달받는 생성자를 가져와라
		this.num3 = num3;
	}

}

public class Class_16_This {
	public static void main(String[] args) {
		ThisB obj = new ThisB(100);
		obj.showInfo();

	}

}
