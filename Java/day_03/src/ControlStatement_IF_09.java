import java.util.Scanner;

public class ControlStatement_IF_09 {

	public static void main(String[] args) {
		// 로그인을 처리하는 프로그램 구현
		// ID와 Password는 모두 정수, ID는 nID 변수, Pass는 nPassword에 저장 ( 키보드입력을 사용하여 처리 )
		// 입력된 ID와 Password가 3 또는 5의 배수인 경우 로그인 성공
		// 아니면 로그인 실패
		
		Scanner kb = new Scanner(System.in);
		
		int nID, nPassword, sum;
		
		System.out.print("ID를 입력하세요. ");
		nID = kb.nextInt();
		
		System.out.print("Password를 입력하세요. ");
		nPassword = kb.nextInt();
		kb.close();
		

		
		// ID 체크
		boolean flag_id = nID%3==0 || nID%5==0;
		// Password 체크
		boolean flag_password = nPassword%3==0 || nPassword%5==0;
		// 로그인 처리 결과를 저장하는 변수
		boolean result = flag_id && flag_password;
		
		// ID와 Password를 분리하여 처리
		if(flag_id) {
			// 제어문의 중첩된 사용
			// 자바의 제어문은 내부에 또 다른 제어문을 포함할 수 있다.
			if(flag_password) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패 - 패스워드를 확인하세요");
			}	
		} else {
			System.out.println("로그인 실패 - 아이디를 확인하세요");
		}
			
		
		/*
		// result 변수를 사용하여 로그인 여부를 판단하는 경우 ID 또는 Password 둘 중 어느곳에서 문제가 발생했는지 확인할 수 없다.
		if ( result )
			System.out.println("로그인 성공");
		else
			System.out.println("아이디와 패스워드를 확인하세요.");
		*/
		
	}

}
