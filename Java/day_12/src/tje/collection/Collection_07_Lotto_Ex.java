package tje.collection;

import java.util.*;

public class Collection_07_Lotto_Ex {

	public static void main(String[] args) {
		// 로또 개수를 입력받기 위한 스캐너 객체
		Scanner kb = new Scanner(System.in);
		// 각 로또번호의 ArrayList 객체를 저장하는 ArrayList 객체
		ArrayList< ArrayList<Integer> > lottos = new ArrayList<>();
		
		// 난수를 사용하여 로또번호를 생성하기 위한 객체 생성
		Random random = new Random();
		System.out.print("로또 개수를 입력하세요 : ");
		int count = kb.nextInt();
		
		for( int i = 1 ; i <= count ; i++ ) {
			// 로또 번호를 저장하기 위한 HashSet 객체 생성
			HashSet<Integer> lotto = new HashSet<Integer>();
			// 중복이 제거된 로또 번호가 6개가 되는 순간까지 반복을 수행
			while( lotto.size() < 6 )
				lotto.add(random.nextInt(45) + 1 );
			
			// 로또 번호가 생성되면 정렬을 수행
			ArrayList<Integer> lotto_list = new ArrayList<Integer>(lotto);
			Collections.sort(lotto_list);
			
			// 정렬이 완료된 후, 리스트에 추가
			lottos.add(lotto_list);
		}
		
		for( int i = 0 ; i < lottos.size() ; i++ ) {
			for ( int j : lottos.get(i) ) 
				System.out.printf("%2d ", j);
			
			// 아래와 같은 코드
//			ArrayList<Integer> lotto = lottos.get(i);
//			for( int j = 0 ; j < lotto.size() ; j++ )
//				System.out.printf("%2d ", lotto.get(j));
			System.out.println();
		}
	}

}
