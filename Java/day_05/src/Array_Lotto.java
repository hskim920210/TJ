
public class Array_Lotto {

	public static void main(String[] args) {
		int [] lotto = new int [4];
		
		
		out:
		for ( int i = 0 ; i < lotto.length ; i++ ) {
			int random = (int)( Math.random()*20 + 1);
			
			for ( int j = 0 ; j < i ; j++) {
				if (lotto[j] == random) {
					i--;
					continue out;
				}
			}
			lotto[i] = random;
		}
		
		for( int i = 0 ; i < lotto.length - 1 ; i++ ) {
			for( int j = i + 1 ; j < lotto.length ; j++ ) {				
				if( lotto[i] > lotto[j] ) {
					int temp = lotto[j];
					lotto[j] = lotto[i];
					lotto[i] = temp;
				}
			}
		}
		
		
		System.out.printf( "금주의 선택 : ");
		for ( int i = 0 ; i < lotto.length ; i++ ) 
			System.out.printf("%d ", lotto[i]);
		
	}

}
