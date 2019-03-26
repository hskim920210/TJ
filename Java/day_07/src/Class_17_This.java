
class ThisE {
	private int num1;
	private int num2;
	private int num3;

	public ThisE(int num1) {
		this.num1 = num1;
	}

	public ThisE(int num1, int num2) {
		// this 키워드를 통한 생성자의 호출은 생성자 내부의 첫번째 실행문으로만 가능하다.
		// 특정 생성자의 실행을 한번으로 강제하기 위한 문법
		// 상속 문법과 관련이 있다.
		this(num1);
		this.num2 = num2;
		// this(num1);
	}

	public ThisE(int num1, int num2, int num3) {
		// this 키워드를 통한 생성자의 호출은 생성자 내부의 첫번째 실행문으로만 가능하다.
		this(num1, num2);
		this.num3 = num3;
		// this(num1, num2);
	}

}

public class Class_17_This {
	public static void main(String[] args) {
		ThisB obj = new ThisB(100);
		obj.showInfo();

	}

}
