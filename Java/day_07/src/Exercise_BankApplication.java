import java.util.Scanner;

class Account {
	private String ano;
	private String owner;
	private int balance;

	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}


private static void createAccount() {
	System.out.println("-------");
	System.out.println("계좌생성");
	System.out.println("-------");
	
	System.out.print("계좌번호 : ");

}
	
}

class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
}


public class Exercise_BankApplication {

	private static Account[] accountArray = new Account[100];
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
				// createAccount();
			} else if (selectNo == 2) {
				// accountList();
			} else if (selectNo == 3) {
				// deposit();
			} else if (selectNo == 4) {
				// withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
			 
		}

		System.out.println("프로그램 종료");
	}

}
