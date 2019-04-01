package tje.object;

// 사용자 정의 클래스를 생성하면서, extends (상속) 을 구현하지 않으면
// 자동으로 java.lang.Object 클래스를 상속받는다.

// java.lang.Object 클래스 : Java 에서 사용되는 모든 클래스들의 최상위 부모클래스

class Object_A {}

public class Object_01 {

	public static void main(String[] args) {
		Object_A obj = new Object_A();
		
		// getClass 메소드는 해당 객체의 클래스 타입을 반환 (Class 타입을 반환)
		System.out.println(obj.getClass());
		
		// hashCode 메소드는 해당 객체의 해시코드 값을 반환
		// (해당 객체가 JVM에 의해 관리되고 있는 번호)
		System.out.println(obj.hashCode());
		
		// toString 메소드는 해당 객체의 정보를 문자열로 반환
		// 객체의 클래스명 + '@' + 해시코드값(16진수)
		System.out.println(obj.toString());
	}

}
