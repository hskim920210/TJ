package tje.collection;

import java.util.*;

public class Collection_05_Ex {

	public static void main(String[] args) {
		ArrayList<Integer> list_1 = new ArrayList<Integer>();
		LinkedList<Integer> list_2 = new LinkedList<Integer>();

		long s_time, e_time;

		
		// 데이터 입력
		s_time = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list_1.add(0, i);
		e_time = System.nanoTime();

		System.out.println("ArrayList의 입력 시간 : " + (e_time - s_time));

		s_time = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list_2.add(0, i);
		e_time = System.nanoTime();

		System.out.println("LinkedList의 입력 시간 : " + (e_time - s_time));

		
		
		// 데이터 삭제
		s_time = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list_1.remove(0);
		e_time = System.nanoTime();

		System.out.println("ArrayList의 삭제 시간 : " + (e_time - s_time));

		s_time = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list_2.remove(0);
		e_time = System.nanoTime();

		System.out.println("LinkedList의 삭제 시간 : " + (e_time - s_time));

	}

}
