import java.util.Scanner;
public class Input_01 {

	public static void main(String[] args) {
		// 프로그램 작성의 기본사항
		// 입력 
		// 변수의 사용
		// 자료형 변수명;
		
		// 정수 자료형  : int(4), long(8)
		// 실수 자료형  : double(8)
		// 문자 자료형  : char(2) {'A', '가' : 영문자, 한글 모두 2byte} 모두 2바이트다.
		// 문자열	    : String
		// 진리형	자료형: boolean(1)

		// 이름, 나이, 성별, 키, 연락처
		
		Scanner kb = new Scanner(System.in);
		String name;
		int age;
		char gender;
		double h;
		String tel;
		
		System.out.print("이름을 입력하세요. : "); 
		name = kb.next();
		System.out.print("나이를 입력하세요. : ");
		age = kb.nextInt();
		System.out.print("성별을 입력하세요. 남자/여자 : ");
		gender = kb.next().charAt(0);
		System.out.print("키를 입력하세요. : ");
		h = kb.nextDouble();
		System.out.print("연락처를 입력하세요. : ");
		tel = kb.next();
		
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("성별 : "+gender);
		System.out.println("키 : "+h);
		System.out.println("연락처 : "+tel);
		
		
	}

}
