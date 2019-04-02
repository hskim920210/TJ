package tje.collection;

import java.util.*;

public class Collection_08 {

	public static void main(String[] args) {
		ArrayList<Integer> list_int = new ArrayList<Integer>();
		list_int.add(10);
		list_int.add(20);
		list_int.add(30);
		
		ArrayList<String> list_str = new ArrayList<String>();
		list_str.add("One");
		list_str.add("Two");
		list_str.add("Three");
		
		// 컬렉션 내부의 특정 값의 존재 유무를 확인하는 방법
		// contains 메소드 : 컬렉션 내부에서 특정 값의 저장 유무를 
		//				   boolean 타입으로 반환하는 메소드
		System.out.println("10 : " + list_int.contains(10));
		System.out.println("15 : " + list_int.contains(15));
		
		System.out.println("One : " + list_str.contains("One"));
		System.out.println("Five : " + list_str.contains("Five"));
		
		// 리스트 타입의 컬렉션 객체인 경우 (ArrayList, Vector, LinkedList)
		// 특정 값의 저장 인덱스의 값을 반환받을 수 있는 indexOf 메소드가 제공
		System.out.println("10 : " + list_int.indexOf(10));
		// 만약 존재하지 않는 값인 경우 -1 값이 반환
		System.out.println("15 : " + list_int.indexOf(15));
	}

}
