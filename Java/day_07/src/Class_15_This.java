
class ThisB {
	private int num;
	
	public ThisB(int num) {
		// 클래스의 멤버필드명과 메소드의 지역변수명이 동일하다면
		// 메소드의 지역변수가 우선시 됩니다.
		// 아래의 코드는 지역변수 num에 지역변수 num의 값을 대입
		// (변화없음)
		// num = num;
		
		// 만약 명시적으로 클래스의 멤버필드를 호출하고자 하는 경우
		// this 키워드를 활용하여 처리할 수 있습니다.
		// 아래의 코드는 현재 생성자를 실행하고 있는 객체의 참조값을 
		// 사용하여 멤버필드 num에 지역변수 num의 값을 대입
		this.num = num;
	}
	
	public void showInfo() {
		System.out.printf("num = %d\n",num);
	}
}

public class Class_15_This {
	public static void main(String[] args) {
		ThisB obj = new ThisB(100);
		obj.showInfo();
		

	}

}
