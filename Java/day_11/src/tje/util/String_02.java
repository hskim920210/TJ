package tje.util;

public class String_02 {

	public static void main(String[] args) {
		// String 클래스의 메소드
		String message = "Hello Java~!";
				
		// charAt 메소드
		// 해당 문자열의 특정 인덱스 위치의 문자값을 반환
		// 시작은 0
		System.out.printf("message 문자열 변수의 1번째 문자는 %c\n", 
				message.charAt(0));
		// length 메소드는 해당 문자열의 전체 길이를 반환
		// charAt 메소드와 조합하여 마지막 문자값을 추출하는 예제
		System.out.printf("message 문자열 변수의 마지막 문자는 %c\n", 
				message.charAt(message.length()-1));
				
		String str1 = "Hello ";
		String str2 = "World~!";
		// concat 메소드는 현재 객체의 문자열에
		// 매개변수로 전달된 문자열을 결합한 결과를 반환
		// 원본 문자열 str1의 Hello  는 변경되지 않고
		// Hello 와 World~! 가 결합된 새로운 문자열을 
		// 생성한 후 반환
		String str3 = str1.concat(str2);
		System.out.println(str3);		
		System.out.println(str1);
					
		// replaceAll 메소드는 현재 문자열 내부에서
		// 매개변수로 전달된 첫번째 문자열의 값을 
		// 두번째 매개변수의 값으로 변경한 문자열 생성한 후 반환
		// 원본 문자열 str3의 Hello World~! 는 변경되지 않고
		// o 를 X 로 변경한 새로운 문자열을 생성한 후 반환
		System.out.println(str3.replaceAll("o", "X"));
		System.out.println(str3);

		
		// 문자열은 공백의 값을 포함할 수 있다.
		String str4 = "   Hello World~!   ";
		System.out.println(str4);
		
		String id_1 = "id_            123";
		String id_2 = "id_123 ";
		if(id_1.equals(id_2))
			System.out.println("동일한 아이디입니다.");
		else
			System.out.println("다른 아이디입니다.");
		
		// String 클래스의 trim 메소드
		// 문자열의 '앞과 뒤편에 있는' 공백의 값을 제거하는 메소드
		// 공백이 제거된 문자열 값이 반환(원본 데이터의 수정은 X)
		if(id_1.trim().replaceAll(" ", "").equals(id_2.trim()))
			System.out.println("동일한 아이디입니다.");
		else
			System.out.println("다른 아이디입니다.");
		
		// 
		// https://trello.com/b/ESG6cCmh/%EB%8D%94%EC%A1%B0%EC%9D%80%EA%B0%95%EB%82%A8-%EC%9E%90%EB%B0%94%EA%B8%B0%EC%B4%88
		
	}

}
