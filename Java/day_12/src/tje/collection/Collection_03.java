package tje.collection;

// 컬렉션 클래스 저장 방식
// 일반적으로 컬렉션 클래스의 객체에는
// 프로그램에서 처리하는 데이터를 저장하게 됩니다.
// (여러 타입이 혼용되어 저장되는 경우는 거의 없음)
// 하지만 컬렉션 클래스의 입력, 반환에 관련된 모든 메소드들은
// Object 타입을 기반으로 하기때문에 강제형변환을 해야하는
// 불편함이 존재합니다.(런타임에러가 발생할 가능성도 내재되어있음)


// 이러한 문제점을 해결하기 위해서 JKD 1.5 이후 버전에서는 
// 제네릭 문법을 지원합니다.
// 제네릭 문법
// 동일한 이름의 클래스이지만 객체 생성 시 타입을 지정하여 
// 서로 다른 타입을 지원하는 클래스의 객체로 생성할 수
// 있는 문법(메소드 오버로딩과 유사한 문법)

// 제네릭 문법을 사용한 ArrayList 클래스의 객체 생성 예시
// ArrayList<Integer> a = new ArrayList<Integer>();

// new 다음의 클래스 명에서는 제네릭 타입을 생략할 수 있다.
// ArrayList<Integer> a = new ArrayList();

import java.util.*;

public class Collection_03 {
	public static void main(String[] args) {
		// 문자열 타입만을 저장할 수 있는 ArrayList 객체 생성
		ArrayList<String> strList = new ArrayList<>();
		
		// 제네릭 타입이 지정된 컬렉션 객체의 Object 타입을 받는 메소드들은
		// 해당 타입을 처리할 수 있는 입력/반환메소드로 변경됩니다.
		strList.add("One");
		strList.add("Two");
		strList.add("Three");
		
		// String 타입으로 제네릭 되었기 때문에
		// 아래와 같은 타입은 입력될 수 없다.
		// strList.add(0);
		// strList.add(3.14);
		
		// String 타입을 반환하는 get 메소드가 제공되는 것을 확인할 수 있다.
		String value = strList.get(0);
		System.out.println(value);
		
	}

}
