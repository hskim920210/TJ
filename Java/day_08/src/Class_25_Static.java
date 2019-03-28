// 복습필요


// static 키워드는 객체지향에서 디자인 빈번하게 패턴에 활용되는 문법
// 싱글턴 패턴 : static 키워드를 활용하는 대표적인 디자인 패턴
//	- 특정 클래스의 객체를 반드시 1개만 생성할 수 있도록 강제하는 패턴

class SingletonEx {
	
	// 객체의 생성 시 자동으로 호출되는 메소드
	// 	- 생성자 메소드
	//	- 생성자의 접근을 제한하면 객체의 생성을 제한할 수 있다.
	//	- public으로 정의된 생성자는 객체의 생성을 제약없이 생성할 수 있다.
	//	- private으로 정의된 생성자는 객체의 생성을 외부에서 할 수 없도록 제약한다.
	// public SingletonEx() {}
	private SingletonEx() {
		System.out.println("SingletonEx 클래스의 객체 생성");
	}
	
	// 현재 클래스의 객체를 저장하는 변수
	private static SingletonEx instance = null;
	
	// 현재 클래스의 객체를 반환할 수 있는 static 메소드의 선언
	public static SingletonEx getInstance() {
		if ( instance == null )
			instance = new SingletonEx();
		
		return instance;
		
		// private으로 정의된 생성자는 클래스의 내부에서는 자유롭게 접근할 수 있다.
		// return new SingletonEx();
	}
	
}

public class Class_25_Static {
	public static void main(String[] args) {
		// private 으로 정의된 생성자는 클래스의 외부에서 객체를 생성할 수 없도록 제한한다.
		//	SingletonEx s1 = new SingletonEx();
		//	SingletonEx s2 = new SingletonEx();
		//	SingletonEx s3 = new SingletonEx();
		
		// static 메소드를 통해 객체를 제공받는 코드
		SingletonEx s1 = SingletonEx.getInstance();
		SingletonEx s2 = SingletonEx.getInstance();
		SingletonEx s3 = SingletonEx.getInstance();

		
	}
}
