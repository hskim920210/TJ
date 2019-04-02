package tje.collection;

// 컬렉션 클래스
// 자료구조를 구현하고 있는 클래스
// 자료구조 : 각각의 데이터들을 효율적으로 저장하기 위한 방법론

// 배열
// - 다수개의 요소를 저장할 수 있음
// - 손쉬운 접근 방법을 제공(인덱스)
// - 크기가 고정
// - 데이터의 삽입과 삭제에 비효율적

// 링크드 리스트
// - 크기의 제약없이 데이터를 저장할 수 있음
// - 데이터의 삽입과 삭제에 최적화
// - 검색에 취약(개선하기 위한 더블 링크드 리스트)
// - 데이터 저장 시 불필요한 메모리 사용
//   (참조값을 저장하기 때문에)

// 자바의 모든 자료구조 클래스(컬렉션 클래스)들은
// java.util 패키지를 통해 제공받을 수 있음
// 동적 배열을 구현하고 있는 클래스들
// (배열의 특징은 유지하되, 크기의 제약이 없다.)
// - Vector, ArrayList 동기화 필요할때 vector 필요없을때 arraylist
// 링크드 리스트를 구현하고 있는 클래스
// - LinkedList

// Set 타입의 저장방법을 구현하고 있는 클래스들
// Set 타입 : 데이터를 저장할 때, 중복을 허용하지 않는 방법
// (검색을 위해서 사용, 중복된 값을 제거하기 위해서 사용)
// - HashSet, TreeSet

// Map 타입의 저장방법을 구현하고 있는 클래스들
// Map 타입 : 데이터를 키와 밸류의 형태로 저장하는 방법
// (검색을 위해서 사용, 키의 값은 중복을 허용하지 않음
// 밸류의 값은 중복을 허용)
// - Hashtable(동기화), HashMap(동기화X)

// 동적 배열을 구현하고 있는 Vector, ArrayList 클래스
// - 두개의 클래스는 동일한 기능을 제공
// - 쓰레드 동기화의 지원여부
// - 크기의 제약없이 데이터를 저장(동적으로 크기를 확장)
// - 배열과 같이 인덱스를 기반으로 데이터를 접근
// - 데이터의 삽입과 삭제에 취약한 구조
// - 데이터의 중복을 허용
// - 데이터의 입력 순서를 유지


import java.util.Vector;
import java.util.ArrayList;

public class Collection_01 {
	public static void main(String[] args) {
		Vector vector_normal = new Vector();
		Vector vector = new Vector(100);
		ArrayList list = new ArrayList();
		
		// 동적 배열의 크기를 확인
		// 기본값은 10개를 저장
		System.out.println(vector_normal.capacity());
		System.out.println(vector.capacity());
		
		// 데이터 입력
		// add 메소드를 사용하여 데이터를 입력
		// ( 삽입 기능도 가능 - 인덱스 매개변수를 추가하여 )
		vector.add(10);		 vector.add(20); 		vector.add(30); 
		list.add(10); 		 list.add(20); 		 	list.add(30);   
		
		// Vector, ArrayList 클래스의 size 메소드는
		// 현재 저장되어 있는 데이터의 개수를 반환
		for( int i = 0 ; i < vector.size() ; i++ ) {
			// Vector, ArrayList 클래스의 get 메소드는
			// 특정 인덱스에 저장되어 있는 데이터를 반환
			System.out.printf("vector[%d] = %d\n", i, vector.get(i));
 		}
		
		for( int i = 0 ; i < list.size() ; i++ ) {
			// Vector, ArrayList 클래스의 get 메소드는
			// 특정 인덱스에 저장되어 있는 데이터를 반환
			System.out.printf("list[%d] = %d\n", i, list.get(i));
		}
	}

}
