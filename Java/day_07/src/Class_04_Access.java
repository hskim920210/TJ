// 접근 지정자
// 모든 클래스의 멤버는 현실에 존재하는 대상의 정보로서, 직접적인 접근이 허용되는 것과 허용되면 안되는 정보가 있다.
// 접근 지정자는 클래스의 멤버들에 대한 접근을 제어하는 키워드이다.
// private : 클래스 내부에서만 사용 가능한 멤버를 정의하는 키워드
// public : 접근에 제한이 없는 멤버를 정의하는 키워드

class AccountWithPermission {
		// 정보 은닉
		// 클래스 내부에 선언된 멤버필드들은 현실에서 존재하는 대상의 정보를 저장한다.
		// 일반적으로 이러한 정보들은 직접적으로 수정해서 안된다.
		// 이러한 이유로 모든 멤버필드들은 private으로 선언하고,
		// 멤버필드들을 제어할 수 있는 메소드들을 public으로 선언한다.
	
		// 클래스 외부에서의 접근이 차단된 잔액 정보를 저장하는 멤버필드
		private double balance;

		public void initBalance(double money) {
			balance = money;
		}

		public void withraw(double money) {
			// 정보은닉을 구현하는 코드 ( 제약조건을 지정 )
			if ( balance < money ) {
				System.out.println("잔액이 부족합니다.");
				return;
			}
			balance -= money;
		}

		public void deposit(double money) {
			// 정보은닉을 구현하는 코드 ( 제약조건을 지정 )
			if (money<0) {
				System.out.println("입금 금액에 문제가 발생했습니다.");
				System.out.println("관리자에게 문의하세요");
				return;
			}
			balance += money;
		}

		public void display() {
			System.out.printf("현재 잔액은 %.2f 원 입니다.\n", balance);
		}
}

public class Class_04_Access {
	public static void main(String[] args) {
		AccountWithPermission a = new AccountWithPermission();
		
		// public 접근 지정자가 선언된 멤버필드/메소드는 클래스의 외부에서 접근할 수 있는 멤버이다.
		a.initBalance(10000);
		a.display();
		
		a.withraw(5000);
		a.display();
		
		a.deposit(500000);
		a.display();
		
		a.withraw(10000000);
		a.display();
		
		// private 지정된 멤버는 클래스 외부에서의 접근이 차단된다.
		// a.balance = 100000000;
		
	}

}
