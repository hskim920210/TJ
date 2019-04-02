package tje.collection;

// Hashtable(동기화), HashMap(동기화X) 클래스
// 데이터베이스 내부의 키 값을 검색하기 위해서 만들어진 알고리즘을
// 기반으로 작성된 클래스
// - 검색을 위해서 사용되는 클래스
// - Key, Value를 저장할 수 있는 클래스
// - Key 는 중복을 허용하지 않음
// - Value 는 중복을 허용합니다.
// - 쓰레드 동기화의 지원 유무가 다름

import java.util.*;

public class Collection_10 {
	public static void main(String[] args) {
		// Key 값은 문자열, Value 값은 정수로 입력받는
		// HashMap 객체를 생성
		HashMap<String, Integer> map_s = new HashMap<>();

		// Key 값은 정수, Value 값은 문자열로 입력받는
		// Hashtable 객체를 생성
		Hashtable<Integer, String> map_i = new Hashtable<>();
		
		// Hashtable, HashMap 클래스는 put 메소드를 사용하여 데이터를 추가
		map_s.put("One", 1); 
		map_s.put("Two", 2); 
		map_s.put("Three", 3); 
		
		map_i.put(1, "One");
		map_i.put(2, "Two");
		map_i.put(3, "Three");
		
		// Hashtable, HashMap 클래스는 get 메소드에 Key 값을 전달하여 Value를 반환
		System.out.printf("One -> %d\n", map_s.get("One"));
		System.out.printf("3 -> %s\n", map_i.get(3));
		
		
		// Hashtable, HashMap 클래스 내부의 데이터를
		// 반복문을 통해서 접근하는 예제
		// 1. Enumeration 타입을 사용하는 방법 - Hashtable 타입
		
		// Hashtable 객체는 키의 값을 수회할 수 있는 keys 메소드를 제공
		// (Enumeration 타입의 객체가 반환)
		Enumeration<Integer> enu = map_i.keys();
		// Enumeration 타입의 객체는 hasMoreElements 메소드를 사용하여
		// 접근할 수 있는 다음 요소가 있는 지 확인할 수 있다.
		while( enu.hasMoreElements() ) {
			// Enumeration 타입의 객체는 nextElement 메소드를 사용하여
			// 다음의 요소에 접근한 후, 해당 값을 반환한다.
			Integer key = enu.nextElement();
			// 반환받을 키값을 사용하여 Hashtable에서 값을 추출
			System.out.printf("Key : %d, Value : %s\n", key, map_i.get(key));
		}
		
		
		// 2. for 문을 활용하여 Key 값을 순회하는 방법 - HashMap 타입
		// HashMap 클래스의 keyset 메소드는 저장된 모든 키들을 저장하고 있는 Set 객체를 반환
		for( String key : map_s.keySet() )
			System.out.printf("Key : %s, Value : %d\n", key, map_s.get(key));
		
		
		
	}
}
