import java.util.Scanner;

public class ControlStatement_IF_08 {

	public static void main(String[] args) {
		// 로그인을 처리하는 프로그램 구현
		// ID와 Password는 모두 정수, ID는 nID 변수, Pass는 nPassword에 저장 ( 키보드입력을 사용하여 처리 )
		// 입력된 ID와 Password의 합이 3 또는 5의 배수인 경우 로그인 성공
		// 아니면 로그인 실패
		
		Scanner kb = new Scanner(System.in);
		
		int nID, nPassword, sum;
		
		System.out.print("ID를 입력하세요. ");
		nID = kb.nextInt();
		
		System.out.print("Password를 입력하세요. ");
		nPassword = kb.nextInt();
		kb.close();
		
		sum = nID + nPassword;
		
		boolean result;
		
		result = sum%3==0 || sum%5==0;
		
		if ( sum % 3 == 0 || sum % 5 == 0)
			System.out.println("\n로그인에 성공하였습니다.");
		else 
			System.out.printf("\n로그인에 실패하였습니다. \nID와 Password를 확인하세요. \n(ID : %d, Password : %d)\n", nID, nPassword);
		
		if ( result )
			System.out.println("로그인 성공");
		else
			System.out.println("아이디와 패스워드를 확인하세요.");

	}

}
