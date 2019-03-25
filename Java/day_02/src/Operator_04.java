
public class Operator_04 {

	public static void main(String[] args) {
		// 증가/감소 연산자
		// ++ / --
		// 특정 변수의 값을 1씩 증가/감소 시킬수 있는 연산자
		// 대입연산자(=)를 사용하지 않고 변수의 값을 수정할 수 있다.
		
		int num;
		
		num = 10;
		System.out.printf("num -> %d\n", num);
		
		// 대입연산자를 사용하여 특정 변수의 값을 1 증가하는 코드. (변수명이 중복되서 사용된다.)
		num = num + 1;
		System.out.printf("num -> %d\n", num);
		
		// 증가연산자를 사용하여 특정 변수의 값을 1 증가하는 코드
		num++; // num = num + 1 과 동일하게 동작함.
		System.out.printf("num -> %d\n", num);
		
		// 변수명 --; 해당변수의 값을 1 감소
		num--; // num = num - 1 과 동일하게 동작함.
		System.out.printf("num -> %d\n", num);

	}

}
