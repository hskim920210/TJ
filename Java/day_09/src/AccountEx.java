import java.util.Scanner;

public class AccountEx {

	private static Account[] accounts = new Account[100];

	public static void printMenu() {
		System.out.println("1. 계좌생성");
		System.out.println("2. 계좌목록 조회");
		System.out.println("3. 입금");
		System.out.println("4. 출금");
		System.out.println("5. 계좌 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public static void select() {
		System.out.println("전체 계좌 정보를 출력합니다.");
		for (int i = 0, lastIndex = getAccountSize(); i < lastIndex; i++)
			accounts[i].printInfo();
	}

	// 계좌번호를 사용하여 해당 계좌가 저장된 배열의
	// 인덱스를 반환하는 메소드
	public static int searchAccount(String accountNumber) {
		int index, lastIndex = getAccountSize();

		for (index = 0; index < lastIndex; index++) {
			if (accounts[index].getAccountNumber().contentEquals(accountNumber)) {
				break;
			}
		}
		return index;
	}

	public static void deposit(Scanner kb) {
		System.out.println("입금 과정을 시작합니다.");
		String accountNumber = null;
		do {
			if (accountNumber != null)
				System.out.println("존재하지 않는 계좌번호를 입력하셨습니다.");

			System.out.print("계좌번호를 입력하세요 : ");
			accountNumber = kb.next();
		} while (!checkAccountNumber(accountNumber));

		System.out.print("입금액을 입력하세요 : ");
		double balance = kb.nextDouble();

		accounts[searchAccount(accountNumber)].printInfo();
		accounts[searchAccount(accountNumber)].deposit(balance);
		accounts[searchAccount(accountNumber)].printInfo();
	}

	public static void withdraw(Scanner kb) {
		System.out.println("출금 과정을 시작합니다.");

		String accountNumber = null;
		do {
			if (accountNumber != null)
				System.out.println("존재하지 않는 계좌번호를 입력하셨습니다.");

			System.out.print("계좌번호를 입력하세요 : ");
			accountNumber = kb.next();
		} while (!checkAccountNumber(accountNumber));

		System.out.print("출금액을 입력하세요 : ");
		double balance = kb.nextDouble();

		accounts[searchAccount(accountNumber)].printInfo();
		accounts[searchAccount(accountNumber)].withdraw(balance);
		accounts[searchAccount(accountNumber)].printInfo();
	}

	public static boolean checkExit(Scanner kb) {
		System.out.print("종료하시겠습니까? (y/n) : ");
		char isExit = kb.next().charAt(0);
		return isExit == 'y' || isExit == 'Y' ? true : false;
	}

	public static int getAccountSize() {
		int index;
		for (index = 0; index < accounts.length; index++) {
			if (accounts[index] == null) {
				break;
			}
		}
		return index;

	}

	public static boolean checkAccountNumber(String accountNumber) {
		// 배열에 저장된 모든 Account 클래스의 객체들을 순회하며
		// 동일한 계좌번호의 유무를 판단하여 반환하는 메소드
		int lastIndex = getAccountSize();
		for (int i = 0; i < lastIndex; i++) {
			// 문자열 값의 비교를 위한 equals 메소드
			// 문자열 변수.equals(비교할 문자열) -> 동일한 문자열 true,
			// 동일하지 않은 문자열의 경우 false
			if (accounts[i].getAccountNumber().equals(accountNumber)) {
				return true;
			}
		}
		return false;
	}

	public static void create(Scanner kb) {

		System.out.println("계좌 생성 과정을 시작합니다.");
		String accountNumber = null;
		do {
			if (accountNumber != null)
				System.out.println("중복된 계좌번호를 입력하셨습니다.");

			System.out.print("계좌번호를 입력하세요 : ");
			accountNumber = kb.next();
		} while (checkAccountNumber(accountNumber));

		System.out.print("이름을 입력하세요 : ");
		String name = kb.next();

		System.out.print("초기 입금액을 입력하세요 : ");
		double balance = kb.nextDouble();

		Account account = new Account(accountNumber, name, balance);
		accounts[getAccountSize()] = account;

	}

	public static void delete(Scanner kb) {
		System.out.println("계좌 삭제 과정을 시작합니다.");

		String accountNumber = null;
		do {
			if (accountNumber != null)
				System.out.println("존재하지 않는 계좌번호를 입력하셨습니다.");

			System.out.print("삭제할 계좌번호를 입력하세요 : ");
			accountNumber = kb.next();
		} while (!checkAccountNumber(accountNumber));

		int deleteIndex = searchAccount(accountNumber);
		int lastIndex = getAccountSize();
		for (int i = deleteIndex; i < lastIndex; i++) {
			accounts[i] = accounts[i + 1];
		}

//		String accountNumber = null;
//		do {
//			if ( accountNumber != null )			
//			System.out.print("계좌번호를 입력하세요 : ");
//			accountNumber = kb.next();
//		} while(checkAccountNumber(accountNumber));
//		
//		int i = searchAccount(accountNumber);
//		
//		accounts[i] = null;
//		
//		int k = getAccountSize();
//		
//		for ( int j = k ; j < accounts.length ; j++ ) {
//			accounts[j] = accounts[j+1];
//		}

		System.out.println("계좌 삭제가 완료되었습니다.");
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int inputNo;
		do {
			printMenu();
			inputNo = kb.nextInt();
			switch (inputNo) {
			case 1:
				create(kb);
				break;
			case 2:
				select();
				break;
			case 3:
				deposit(kb);
				break;
			case 4:
				withdraw(kb);
				break;
			case 5:
				delete(kb);
				break;
			case 0:
				// 종료 여부를 재확인 후 종료를 안하는 경우 값을 수정
				if (!checkExit(kb)) {
					inputNo = -1;
				}
				break;
			default:
			}
		} while (inputNo != 0);
		System.out.println("프로그램 종료");
	}
}
