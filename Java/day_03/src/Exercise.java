
public class Exercise {

	public static void main(String[] args) {
		// 2장
		
		// 4번
		int age;
		age = 10;
		double price = 3.14;
		
		// 5번
		byte byteValue = 10;
		char charValue = 'A';
		int intValue = byteValue;
		int intValue1 = charValue;
		//short shortValue = charValue; // char타입은 int타입으로 산출되어 int에 저장해야한다.
		double doubleValue = byteValue;
		
		// 6번
		int iV = 10;
		char cV = 'A';
		double dV = 5.7;
		String sV= "A";
		double var = (double) iV;
		byte var1 = (byte) iV;
		int var2 = (int) dV;
		//char var3 = (char) sV; // 큰 크기의 타입인 sV를 작은 크기의 타입인 char로 변환할 수 없다.
		
		// 7번
		int v1 = 10;
		long v2 = 10000000000L;
		//char v3 = ''; // '' 안에 아무것도 없다.
		double v4 = 10;
		float v5 = 10;
		
		// 8번
		byte byV = 10;
		float flV = 2.5F;
		double doV = 2.5;
		//byte r = byV + byV; // 우항은 int타입으로 저장되었다.
		int r1 = 5 + byV;
		float r2 = 5 + flV;
		double r3 = 5 + doV;
		
		
		
		// 3장
		
		// 2번
		int x = 10 ;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z); // 31이 출력
		
		// 3번
		int score = 85;
		String result = (!(score>90)) ? "가" : "나" ;
		System.out.println(result); // 가 가 출력
		
		// 4번
		int pencils = 534;
		int students = 30; 
		// 학생 한명이 가지는 연필의 수
		int pencilsPerStudent = ( 534 / 30 );
		System.out.println(pencilsPerStudent);
		// 남은 연필의 수
		int pencilsLeft = (534%30);
		System.out.println(pencilsLeft);
		
		// 5번
		int value = 356;
		System.out.println(value-56);
		
		// 6번
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom)*height/2.0;
		System.out.println(area);
		
		// 7번
		int m = 10;
		int n = 5;
		System.out.println((m>7) && (n<=5));
		System.out.println((m%3 == 2) || (n%2 != 1));
		
		// 8번
		double k = 5.0;
		double l = 0.0;
		double p = k%l;
		if (Double.isInfinite(p) || Double.isNaN(p)) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		} else {
			double re = p + 10;
			System.out.println("결과: "+re);
		}
			

	}

}
