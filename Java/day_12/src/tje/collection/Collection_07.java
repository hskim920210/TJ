package tje.collection;

// HashSet 클래스
// 데이터의 중복을 허용하지 않고 저장하는 클래스
// - 검색을 위해서 사용되는 클래스
// - 중복된 값을 제거하면서 데이터를 저장하기 위해 사용

import java.util.*;

public class Collection_07 {

	public static void main(String[] args) {
		// Hash 타입의 컬렉션 클래스들은 데이터의 중복을 허용하지 않는다.
		HashSet<String> set = new HashSet<String>();
		for (int i = 1; i < 11; i++)
			set.add("Value-"+i);

			// HashSet 타입의 객체 내부를 순회한느 방법
			// 1. Iterator 객체를 사용하는 방법
			// - Iterator 객체는 컬렉션 내부의 데이터를 순회할 수 있는 객체

			// Set 타입의 내부를 순회할 수 있는 Iterator 객체 반환
			Iterator<String> iter = set.iterator();
			// Iterator 객체의 hasNext 메소드는 다음에 접근할 요소의 존재 유무를 반환(true/false)
			while (iter.hasNext())
				// Iterator 객체의 next 메소드는 다음의 요소에 접근하여 
				// 해당 값을 반환해주는 메소드 (StringTokenizer와 비슷한 쓰임과 구조)
				System.out.println(iter.next());
			
			// 2. for문을 사용하는 방법(개선된 형태)
			// - for( 자료형 변수명 : 순회할 수 있는 타입(배열, 컬렉션) ) 
			//       배열/컬렉션으로부터 추출한 변수를 사용하는 코드
			System.out.println("==========================================");
			for ( String value : set ) {
				System.out.println(value);
			}
	}

}
