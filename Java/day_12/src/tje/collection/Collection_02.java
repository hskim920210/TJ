package tje.collection;

// 컬렉션 클래스 저장 방식
// 모든 컬렉션 클래스들은 기본적으로
// Object 타입을 저장/반환할 수 있습니다.

// Object 타입을 매개변수 사용하는 모든
// 컬렉션클래스들은 타입에 상관없이 저장할 수 있다.
// 하지만, 저장된 데이터를 반환받는 과정에서
// 런타임 에러가 발생될 수 있다.
// Object -> 자식클래스타입  : 강제형변환

import java.util.ArrayList;

public class Collection_02 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		// 다양한 타입을 저장할 수 있는 컬렉션 클래스의 객체
		list.add(10);	// new Integer(10);
		list.add(107.15);	// new Double(107.15);
		list.add("Hello Collections~!");
		
		
		
		int i = (Integer)list.get(0);

		// 컬렉션 내부의 데이터를 추출하는 과정에서
		// 일치하지 않는 타입으로 형변환이 일어나는 경우
		// 런타임 에러가 발생되어 프로그램이 강제 종료
		// double d = (Double)list.get(0);
		double d = (Double)list.get(1);
		String s = (String)list.get(2);
		
		System.out.println(i);
		System.out.println(d);
		System.out.println(s);
		
				
	}

}
