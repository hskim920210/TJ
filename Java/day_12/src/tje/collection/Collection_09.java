package tje.collection;

import java.util.*;


// 사용자 정의 클래스를 컬렉션에 저장하는 경우 주의사항
// 사용자 정의 클래스에 equals 메소드가 오버라이딩 되지 않은 경우
// 컬렉션 내부에서 동일한 형태의 객체를 검색, 삭제할 수 없다.
class Human {
	private String name;
	private int age;
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String toString() {
		// String strInfo = "name : " + this.name + ", age : " + this.age;
		String strInfo = String.format("name : %s, age : %d", this.name, this.age);
		return strInfo;
	}
	
	public boolean equals(Object obj) {
		// 1. 타입체크
		if ( !(obj instanceof Human) )
			return false;
		// 2. 형변환
		Human target = (Human)obj;
		// 3. 비교
		boolean flag_name = this.name.equals(target.name);
		boolean flag_age = this.age == target.age;
		return flag_name && flag_age;
		
		
//		System.out.printf("%s 의 equals 메소드 실행 ~!\n", this.name );
//		
//		if ( this.name.equals(obj.toString()) && this.age == Integer.parseInt(obj.toString()))
//				return true;
//		return super.equals(obj);
	}
	
	
}

public class Collection_09 {

	public static void main(String[] args) {
		// 사용자 정의 클래스 타입도 제네릭의 대상이 된다.
		ArrayList<Human> list = new ArrayList<Human>();

		Human h1 = new Human("ABC", 11);
		Human h2 = new Human("DEF", 22);
		Human h3 = new Human("GHI", 33);
		
		list.add(h1);
		list.add(h2);
		list.add(h3);
		
		for( Human h : list )
			System.out.println(h);
		
		System.out.printf("%s -> %b\n", h1, list.contains(h1));
		System.out.printf("%s -> %b\n", h2, list.contains(h2));
		System.out.printf("%s -> %b\n", h3, list.contains(h3));
		
		Human h4 = new Human("ABC", 11);
		System.out.printf("%s -> %b\n", h4, list.contains(h4));
	}

}
