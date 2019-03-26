
class Account_EX {
	// 잔액 정보를 저장하는 멤버필드
	double balance;

	void initBalance(double money) {
		balance = money;
	}

	void withraw(double money) {
		balance -= money;
	}

	void deposit(double money) {
		balance += money;
	}

	void display() {
		System.out.printf("현재 잔액은 %.2f 원 입니다.\n", balance);
	}
}

public class Class_03_Access {
	public static void main(String[] args) {
		Account_EX account = new Account_EX();

		// 잔액 초기화
		account.initBalance(10000);
		account.display();

		// 출금
		account.withraw(5000);
		account.display();

		// 입금
		account.deposit(30000);
		account.display();

		// 클래스의 멤버필드/메소드는 접근지정자에 의해서 외부에서의 접근을 제어할 수 있다.
		// 접근지정자를 사용하지 않는 경우 아래와 같이 임의의 값으로 멤버필드의 값이 강제로 수정될 수 있다.		
		account.balance = 1000000000;
		account.display();

	}

}
