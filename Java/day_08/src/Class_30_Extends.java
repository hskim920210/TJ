
class SuperC {
	private int num_super;
	
	// 상속관계를 고려한 디폴트 생성자(더미 생성자)
	public SuperC() {}
	public SuperC(int num_super) {
		this.num_super = num_super;
	}
}

class SubC extends SuperC {
	private int num_sub;
	public SubC(int num_sub) {
		// 부모 클래스의 디폴트 생성자가 존재하지 않는 경우
		// 반드시 명시적으로 부모클래스의 매개변수를 선언한 생성자를 호출해야만
		// 컴파일 에러를 방지할 수 있다.
		
		// 부모 클래스의 int 타입을 매개변수로 전달받는 생성자를 명시적으로 호출하는 예제
		super(1);
		this.num_sub = num_sub;
	}
}

public class Class_30_Extends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
