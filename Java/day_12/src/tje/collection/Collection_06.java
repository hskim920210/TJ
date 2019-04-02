package tje.collection;

// HashSet 클래스
// 데이터의 중복을 허용하지 않고 저장하는 클래스
// - 검색을 위해서 사용되는 클래스
// - 중복된 값을 제거하면서 데이터를 저장하기 위해 사용

import java.util.*;

public class Collection_06 {

	public static void main(String[] args) {
		// Vector, ArrayList, LinkedList 컬렉션 클래스들은
		// 데이터의 중복을 허용하고, 값의 입력순서를 유지한다.
		// 아래의 코드는 중복된 값이지만 매번 데이터가 입력된다.
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10); 	list.add(20); 	list.add(30);
		list.add(10); 	list.add(20); 	list.add(30);
		System.out.println("ArrayList 내부에 저장된 데이터 개수 : " + list.size());
		
		// Hash 타입의 컬렉션 클래스들은 데이터의 '중복을 허용하지 않는'다.
		// 아래의 코드는 6번의 add가 실행이 되었지만,
		// 중복된 값이 포함되었으므로 3개의 데이터만 입력된다.
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(10); 	set.add(20); 	set.add(30);
		set.add(10); 	set.add(20); 	set.add(30);
		System.out.println("HashSet 내부에 저장된 데이터 개수 : " + set.size());

	}

}
