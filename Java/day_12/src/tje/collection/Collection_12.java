package tje.collection;

import java.util.*;

// HashMap의 키 값으로 사용되는 사용자 정의 클래스 선언
class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return String.format("name : %s, age : %d", this.name, this.age);
	}

	// 해시 구조의 컬렉션 객체에 사용자 정의 자료형의 객체를 입력하려는 경우
	// 중복된 값의 제거를 위해 반드시 hashCode 메소드를 오버라이딩 해야 한다.
	// hashCode 메소드에서 현재 클래스의 모든 객체들을 그룹지을 수 있는 값을 반환하도록 구현한다.
	public int hashCode() {
		// 같은 나이값을 가지는 객체들만 비교할 수 있도록 age 필드의 값을 반환
		return this.age;
	}

	public boolean equals(Object obj) {
		System.out.printf("%s 의 equals 메소드 실행\n", this.name);
		if (!(obj instanceof Person))
			return false;
		Person target = (Person) obj;
		boolean flag_name = this.name.equals(target.name);
		boolean flag_age = this.age == target.age;
		return flag_name && flag_age;
	}

}

public class Collection_12 {
	public static void main(String[] args) {

		// Hash 알고리즘을 기반으로 구현된 클래스에서는
		// equals 메소드가 호출되지 않는 문제점
		// Hash 기반의 클래스에서 키 값의 중복을
		// 제거하기 위해서 실행되는 과정
		// 1. 입력된(검색할) 객체의 hashCode 메소드 실행
		// 2. 반환받은 hashCode 메소드의 결과를
		// 현재 저장되어 있는 모든 객체들의
		// hashCode 메소드의 반환값과 비교
		// 3. 만약 동일한 hashCode 메소드의 결과가 존재한다면
		// equals 메소드를 실행하여 두 객체가 동일한지 비교
		HashMap<Person, Integer> map = new HashMap<>();

		Person p1 = new Person("A", 1);
		Person p2 = new Person("B", 2);
		Person p3 = new Person("C", 3);

		map.put(p1, 101);
		map.put(p2, 202);
		map.put(p3, 303);

		System.out.println("map.size - > " + map.size());

		Person p4 = new Person("C", 3);
		map.put(p4, 404);

		System.out.println("map.size - > " + map.size());

	}
}
