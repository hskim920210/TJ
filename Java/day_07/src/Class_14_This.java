
class ThisC {
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	
	public ThisC(int num1, int num2, int num3, int num4, int num5) {
		// 생성자에서 this 키워드를 사용하여 멤버필드를 초기화하는 예
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
	}


}

public class Class_14_This {
	public static void main(String[] args) {
		ThisB obj = new ThisB(100);
		obj.showInfo();
		

	}

}
