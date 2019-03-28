
public class Account {
	private String accountNumber;
	private String name;
	private double balance;

	public Account(String accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public void printInfo() {
		System.out.printf("(%s) %s 님의 계좌 잔액은 %.2f 원 입니다.\n", this.accountNumber, this.name, this.balance);
	}

	public void deposit(double balance) {
		if (balance <= 0) {
			System.out.printf("(ERROR) 입금 금액을 확인하세요. %.2f\n", balance);
			return;
		}
		this.balance += balance;
	}

	public void withdraw(double balance) {
		if (balance < 0) {
			System.out.printf("(ERROR) 잔액이 부족합니다");
			return;
		}
		this.balance -= balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
