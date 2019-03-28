
import java.util.Scanner;

public class Exercise_BankApplication {
	
	private static Account_Exa [] accountArray = new Account_Exa[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}

		}

		System.out.println("프로그램 종료");
	}

	// 계좌 생성하기
	private static void createAccount() {
		
		System.out.println("-------");
		System.out.println("계좌생성");
		System.out.println("-------");
		System.out.print("계좌번호 : ");
		String s = scanner.next();
		System.out.print("계좌주 : ");
		String n = scanner.next();
		System.out.print("초기 입금액 : ");
		int b = scanner.nextInt();
		
		Account_Exa member = new Account_Exa(s,n,b);
		for ( int i = 0 ; i < accountArray.length ; i++) {
			if ( accountArray[i] == null) {
				accountArray[i] = member;
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			} 
		} 
	}

	// 계좌 목록보기
	private static void accountList() {
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");
		for ( int i = 0 ; accountArray[i]!= null ; i++) {
			Account_Exa member = accountArray[i];
			String member_ano = member.getAno();
			String member_nam = member.getOwner();
			int member_bal = member.getBalance();
			System.out.printf("%9s       %5s       %d11\n", member_ano, member_nam, member_bal);
		}
		
	}

	// 예금하기
	private static void deposit() {
		System.out.println("-------");
		System.out.println("예금");
		System.out.println("-------");
		System.out.print("계좌번호 : ");
		String s = scanner.next();
		System.out.print("예금액 : ");
		int b = scanner.nextInt();
		
		for ( int i = 0 ; accountArray[i] != null ; i++ ) {
			Account_Exa member = accountArray[i];
			String member_ano = member.getAno();
			int member_bal = member.getBalance();
			if(s.equals(member_ano)) {
				member_bal += b;
				member.setBalance(member_bal);
				System.out.println("예금이 성공되었습니다.");
			} else
				continue;
		}
	}

	// 출금하기
	private static void withdraw() {
		System.out.println("-------");
		System.out.println("출금");
		System.out.println("-------");
		System.out.print("계좌번호 : ");
		String s = scanner.next();
		System.out.print("출금액 : ");
		int b = scanner.nextInt();
		
		for ( int i = 0 ; accountArray[i] != null; i++ ) {
			Account_Exa member = accountArray[i];
			String member_ano = member.getAno();
			int member_bal = member.getBalance();
			if(s.equals(member_ano)) {
				member_bal -= b;
				member.setBalance(member_bal);
				System.out.println("출금이 성공되었습니다.");
			} else
				continue;
		}
	}
}
