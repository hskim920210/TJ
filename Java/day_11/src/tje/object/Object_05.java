package tje.object;

import java.util.Scanner;

// Lotto의 정보를 저장 및 출력할 수 있는 
// 클래스를 작성하세요.
class Lotto {
	private static final int LOTTO_COUNT = 4;
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 20;
	
	
	int [] numbers;
	
	public Lotto() {
		numbers = new int[LOTTO_COUNT];
	}
	
	public void generate() {
		for( int i = 0 ; i < LOTTO_COUNT ; i++ ) {
			int temp = (int)(Math.random() * LOTTO_MAX_NUMBER + LOTTO_MIN_NUMBER);
			if( !searchNumber(i, temp) )
				numbers[i] = temp;
			else
				i--;
		}
		sort();		
	}
	
	private boolean searchNumber(int index, int target) {		
		for( int i = 0 ; i < index ; i++ ) {
			if( this.numbers[i] == target )
				return true;
		}
		return false;
	}
	
	private void sort() {
		// 생성된 로또 번호를 정렬 (오름차순)
		for( int i = 0 ; i < LOTTO_COUNT - 1 ; i++ ) {
			for( int j = i + 1 ; j < LOTTO_COUNT ; j++ ) {				
				if( this.numbers[i] > this.numbers[j] ) {
					int temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
				}
			}
		}
	}
	
	public String toString() {
		String info = "";
		for( int i = 0 ; i < LOTTO_COUNT ; i++ )
			info += this.numbers[i] + " ";
		return info;	
	}
	
	public boolean equals(Object obj) {
		// 1. 타입체크
		if( !(obj instanceof Lotto) )
		// 2. 동일한 타입이 아닌경우 false를 반환
			return false;
				
		// 3. 형변환
		Lotto target = (Lotto)obj;
				
		// 4. 타입이 변환된 레퍼런스를 사용하여 멤버 필드의 값을 비교
		boolean result = true;
		for( int i = 0 ; i < LOTTO_COUNT ; i++ ) {
			if(this.numbers[i] != target.numbers[i]) {
				result = false;
				break;
			}
		}
				
		// 5. 비교결과를 반환
		return result;
	}
}

public class Object_05 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int lotto_count;
		System.out.print("로또 개수를 입력하세요 : ");
		lotto_count = kb.nextInt();
		
		Lotto [] lottos = new Lotto[lotto_count];
		
		
		out:
			for( int i = 0 ; i < lottos.length ; i++ ) {
				lottos[i] = new Lotto();
				lottos[i].generate();
				
				for( int j = 0 ; j < i ; j++ ) {
					if( lottos[i].equals(lottos[j]) ) {
						System.out.println("동일한 로또 번호 발견 - " + lottos[i]);
						i--;
						continue out;
					}				
				}
				
					
			System.out.println(lottos[i]);
		}
	}

}