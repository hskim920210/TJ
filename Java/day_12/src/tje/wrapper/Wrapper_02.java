package tje.wrapper;

public class Wrapper_02 {

	public static void main(String[] args) {
		// 래퍼클래스의 활용
		// 각 래퍼클래스들은 해당 자료형에 대한 정보들을 static 멤버필드/메소드로 제공한다.

		// int 타입의 저장 가능한 최대값 및 최소값
		System.out.printf("int 타입의 최대값 : %d\n", Integer.MAX_VALUE);
		System.out.printf("int 타입의 최대값 : %d\n", Integer.MIN_VALUE);
		// int 타입의 저장 크기
		System.out.printf("int 타입의 바이트 크기 : %d\n", Integer.BYTES);
		System.out.printf("int 타입의 비트 크기 : %d\n", Integer.SIZE);

		String strNum = "101";
		// 문자열로 저장된 정수의 값을 int 타입으로
		// 변환할 수 있는 Integer 클래스의 parseInt 메소드
		int num = Integer.parseInt(strNum);
		System.out.printf("num = %d\n", num);

		String strBinaryNum = "101";
		// 문자열로 저장된 이진법의 값을 int 타입으로
		// 변환할 수 있는 Integer 클래스의 parseInt 메소드
		// (진법의 정보를 추가적으로 전달하여 처리할 수 있음)
		int binaryNum = Integer.parseInt(strBinaryNum, 2);
		System.out.printf("binaryNum = %d\n", binaryNum);
		
	}

}
