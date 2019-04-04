package tje.thread;

// 공유 객체 클래스
class Store {
	private static final int MAX_PRODUCT = 10;
	private int productCount = 5;

	// 상품을 만드는 메소드
	// - 직원 쓰레드에 의해서 실행되는 메소드
	public void make() {
		this.productCount++;
		
		System.out.printf("직원이 상품 개수를 %d 개로 증가시킴.\n", this.productCount);
	}

	// 상품을 판매하는 메소드
	// - 고객 쓰레드에 의해서 실행되는 메소드
	public void buy() {
		this.productCount--;
		
		System.out.printf("고객이 상품 개수를 %d 개로 감소시킴.\n", this.productCount);
	}

}

class Emp extends Thread {
	private Store store;
	private int sleepTime;
	
	public Emp(Store store, int sleepTime) {
		this.store = store;
		this.sleepTime = sleepTime;
	}
	
	public void run() {
		while( true ) {
			try {
				Thread.sleep(this.sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.store.make();
		}
	}
}

class Customer extends Thread {
	private Store store;
	private int sleepTime;
	
	public Customer(Store store, int sleepTime) {
		this.store = store;
		this.sleepTime = sleepTime;
	}
	
	public void run() {
		while( true ) {
			try {
				Thread.sleep(this.sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.store.buy();
		}
	}
}

public class Thread_15 {
	public static void main(String[] args) {
		// 직원과 고객이 공유하는 상점 객체를 생성
		Store store = new Store();
		
		// 직원 쓰레드 객체를 생성
		Emp emp = new Emp(store, 1000);
		// 고객 쓰레드 객체를 생성
		Customer customer = new Customer(store, 1500);
		
		emp.start();
		customer.start();
	}
}
