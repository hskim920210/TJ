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

public class Collection_11 {
	public static void main(String[] args) {
		HashMap<String, Integer> map_s = new HashMap<>();

		Hashtable<Integer, String> map_i = new Hashtable<>();

		map_s.put("One", 1);
		map_s.put("Two", 2);
		map_s.put("Three", 3);

		map_i.put(1, "One");
		map_i.put(2, "Two");
		map_i.put(3, "Three");

		System.out.printf("map_s.size -> %d\n", map_s.size());
		System.out.printf("map_i.size -> %d\n", map_i.size());
		
		// 중복된 키 값으로 데이터를 추가 (데이터 개수가 증가되지 않음)
		map_s.put("Two", 22);
		map_i.put(3, "T");
		
		System.out.printf("map_s.size -> %d\n", map_s.size());
		System.out.printf("map_i.size -> %d\n", map_i.size());
		
		// 동일한 키 값으로 Value가 입력되는 경우 기존의 Value 값이 수정됩니다.
		System.out.printf("map_s.Two -> %d\n", map_s.get("Two"));
		System.out.printf("map_i.3 -> %s\n", map_i.get(3));
	}
}
