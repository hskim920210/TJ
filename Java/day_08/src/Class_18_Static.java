// static 키워드
// 클래스, 멤버 메소드, 멤버 필드에 사용할 수 있는 키워드
// static이 정의된 멤버는 정적 멤버로 동작하게 된다. 모든 클래스의 객체가 공유하는 멤버

// 자바프로그램의 구동 과정
// 1. JVM에 의해서 실행할 모든 클래스 중,
//    static 메소드, static 멤버필드를 메모리에 로딩
//    (프로그램의 시작(main메소드의 실행)전에 메모리 적재)
// 2. 메모리에 로딩된 static 메소드 중, main 이름을 검색
// 3. main 메소드가 검색되었다면 JVM 해당 main 메소드를 
//    호출하여 프로그램을 시작

// static 필드/메소드의 특징
// 프로그램의 구동 전부터 메모리를 확보하고 있는 멤버!!!
class StaticA {
	int n1;
	// static 멤버 필드는 프로그램 시작 전부터 메모리에 로딩되는 변수로서,
	// 모든 객체들이 공유하게 되는 변수. ( 단 하나만 생성됨 )
	static int n2;
}


public class Class_18_Static {
	public static void main(String[] args) {
		StaticA s1 = new StaticA();
		StaticA s2 = new StaticA();
		
		s1.n1 = 10;		s1.n2 = 20;
		s2.n1 = 100;	s2.n2 = 200;
		
		System.out.printf("s1.n1 = %d, s1.n2 = %d\n", s1.n1, s1.n2);
		System.out.printf("s2.n1 = %d, s2.n2 = %d\n", s2.n1, s2.n2);
		
		// static 멤버로 선언된 변수, 메소드는 객체의 생성없이 클래스의 이름으로 접근이 가능한 멤버.
		System.out.printf("StaticA.n2 = %d\n", StaticA.n2);
	}

}
