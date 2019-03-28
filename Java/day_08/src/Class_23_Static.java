
class StaticE {
	private int num_normal;
	private static int num_static;

	public StaticE(int num_normal, int num_static) {
		this.num_normal = num_normal;
		this.num_static = num_static;
	}

	// 일반 메소드의 선언
	// 일반 메소드는 클래스의 객체를 참조하고 있는 레퍼런스 변수의
	// 참조값을 this로 전달받아 해당 객체의 멤버에 접근할 수 있는 메소드
	public void showInfo_normal() {
		System.out.printf("num_normal = %d, num_static = %d\n", num_normal, num_static);
	}

	// static 메소드에서는 this 를 사용할 수 없습니다.
	// static 메소드는 클래스의 이름으로 직접 접근할 수 있는 메소드로서
	// 객체의 참조값을 나타내는 this 를 전달받을 수 없습니다.
	// 이러한 이유로 static 메소드의 내부에서는 this 를 사용해야 하는
	// 일반 멤버필드, 일반 메소드 호출을 할 수 없습니다.
	public static void showInfo_static() {
		// static 메소드 내부에서는 this를 사용할 수 없다.
		// 객체의 레퍼런스 변수가 아닌 클래스의 이름으로 직접 호출되기 때문에 ...
		// System.out.printf("num_normal = %d, num_static = %d\n", num_normal,num_static);
		System.out.printf("num_static = %d\n", num_static);
		
		// 일반 메소드를 호출하기 위해서는 숨겨진 매개변수
		// this를 전달해야하지만, static 메소드 내부에서는
		// this를 사용할 수 없기 때문에 일반 메소드에 this 값을
		// 전달할 수 없습니다.
		// showInfo_normal();
		
		// static 메소드 내부에서는 static 멤버 필드, 멤버 메소드만을 사용할 수 있다.
	}
}

public class Class_23_Static {

	public static void main(String[] args) {
		// 클래스의 일반 멤버 메소드를 사용하기 위해서는 반드시 객체를 생성한 후 호출해야 한다.
		// StaticE.showInfo_normal();

		// 일반 멤버 메소드는 클래스의 이름으로 접근이 허용되지 않는다.
		// 반드시 객체를 생성한 후 호출해야 한다.
		StaticE obj = new StaticE(10, 20);
		obj.showInfo_normal();

		// 반면 static 메소드는 객체의 생성 없이 클래스의 이름으로 호출할 수 있는 메소드다.
		StaticE.showInfo_static();

	}

}
