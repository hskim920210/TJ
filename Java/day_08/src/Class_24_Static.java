
class StaticF {
	private static int num;
	
	// private 으로 정의된 static 멤버를 초기화 하기 위한 static 블럭
	// static 메소드와 달리 호출되어야면 실행되는 것이 아닌
	// 클래스가 로딩되는 시점에 자동으로 실행되는 영역
	static {
		System.out.println("STATIC 블럭 실행");
		num = 700;
	}
	

	
	// static 멤버 num의 값을 초기화 하기 위한 메소드의 선언
	public static void initNum() {
		num = 100;
	}
	
	// static 멤버 num의 값을 설정하기 위한 메소드의 선언
	public static void setNum(int num) {
		// static 메소드의 매개변수가 static 멤버 필드와 이름이 중복되는 경우
		// this 가 아닌 클래스의 이름을 명시하여 접근한다.
		StaticF.num = num;
	}
	
	public static int getNum() {
		return num;
	}
}

public class Class_24_Static {

	public static void main(String[] args) {
		System.out.println("main 실행");
		// static 멤버의 값을 초기화하지 않는 경우 기본 값은 0 또는 null(레퍼런스 변수인 경우)
		System.out.println(StaticF.getNum());
		
		// private 으로 정의된 static 멤버의 값을 초기화 하기 위한 메소드의 호출
		// ( 반드시 호출되어야만 실행 )
		StaticF.initNum();
		
		System.out.println(StaticF.getNum());

		System.out.println("main 종료");
	}

}
