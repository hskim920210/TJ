package tje.collection;

import java.util.*;

public class Collection_07_Ex {

	public static void main(String[] args) {
		// 중복을 제거한 로또 번호를 추출하는 예제
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		
		while( lotto.size() < 6 ) 
			// Math.random() * 45
			lotto.add(random.nextInt(45) + 1);
		
		for ( Integer i : lotto ) {
			System.out.printf("%2d ", i);
		}
		
		System.out.println();
		
		
		
		// List 타입의 데이터를 정렬할 수 있는 Collections 클래스를 활용하여
		// Hash 내부의 데이터를 정렬하는 방법
		// 1. List 타입의 객체를 생성하면서 HashSet 타입의 객체를 생성자의 매개변수로 전달
		List<Integer> lotto_list = new ArrayList<Integer>(lotto);
		// 2. 생송된 List 타입의 객체를 Collections 클래스의 sort 메소드의 매개변수로 전달
		//		(정렬이 완료됨)
		Collections.sort(lotto_list);
		
		// 정렬된 로또번호를 출력하는 내용
		for ( Integer i : lotto_list ) {
			System.out.printf("%2d ", i);
		}
		
		}

}
