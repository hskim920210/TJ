package tje.io;

import java.io.IOException;

public class IO_04_Ex_2 {

	public static void main(String[] args) throws IOException {
		// System.in 객체를 사용하여 더하기 연산을 수행하는
		// 프로그램을 작성하세요.
		// 첫번째 정수 : 123
		// 두번째 정수 : 2
		// 결과 : 123 + 2 = 125
		
		// 첫번째 숫자에 대한 문자값을 저장하기 위한 byte 배열
		byte [] num1 = new byte[10];
		// 두번째 숫자에 대한 문자값을 저장하기 위한 byte 배열
		byte [] num2 = new byte[10];
		
		int size;
		
		System.out.print("첫번째 정수 : ");
		size = System.in.read(num1);
		// 0	1	2
		// 1	2	3
		// 49	50	51	13	10
		int n1 = 0;
		for( int i = size - 3, multiple = 1 ; i >= 0 ; i--, multiple *= 10 ) {
			n1 += (num1[i] - '0') * multiple;
		}
		
		System.out.print("두번째 정수 : ");
		size = System.in.read(num2);
		int n2 = 0;
		for( int i = size - 3, multiple = 1 ; i >= 0 ; i--, multiple *= 10 ) {
			n2 += (num2[i] - '0') * multiple;
		}
		
		
		System.out.printf("결과 : %d + %d = %d\n", n1, n2, n1 + n2);

		
		
		// 내 시도
		
//		byte[] input = new byte[10];
//		int n1, n2, result;
//				
//		
//		System.out.print("첫번째 정수 : ");
//		n1 = System.in.read(input);
//		System.out.print("두번째 정수 : ");
//		n2 = System.in.read(input, 5, 3);
//
//		for (int i = 0; i < input.length; i++)
//			System.out.printf("%d ", input[i]);
//		
	}

}
