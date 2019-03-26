
class Account_Pr {
	private int balance;
	int MIN_BALANCE = 0;
	int MAX_BALANCE = 1000000;

	public void setBalance(int i) {
		if (i < 0 || i > 1000000) {
			balance = balance;
		} else if (i >= MIN_BALANCE && i <= MAX_BALANCE) {
			balance = i;
		}
	}

	public int getBalance() {
		return balance;
	}

}

public class Exercise_Account {

	public static void main(String[] args) {
		Account_Pr account = new Account_Pr();

		account.setBalance(10000);
		System.out.println("ÇöÀç ÀÜ°í : " + account.getBalance());

		account.setBalance(-100);
		System.out.println("ÇöÀç ÀÜ°í : " + account.getBalance());

		account.setBalance(2000000);
		System.out.println("ÇöÀç ÀÜ°í : " + account.getBalance());

		account.setBalance(300000);
		System.out.println("ÇöÀç ÀÜ°í : " + account.getBalance());
	}

}
