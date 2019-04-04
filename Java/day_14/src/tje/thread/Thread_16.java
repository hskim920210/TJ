package tje.thread;
// 둘 다 wait 에 빠져있는 경우를 deadlock 상태라 한다.

// 공유 객체 클래스
class StoreWithSync {
	private static final int MAX_PRODUCT = 10;
	private int productCount = 5;

	// 상품을 만드는 메소드
	// - 직원 쓰레드에 의해서 실행되는 메소드
	
	// 공유 자원으로 사용되는 클래스의 메소드 내부에서 
	// wait / notify 메소드가 호출되는 경우
	// 해당 메소드는 반드시 동기화가 지원되어야만 한다.
	public synchronized void make() {
		this.productCount++;
		System.out.printf("직원이 상품 개수를 %d 개로 증가시킴.\n", this.productCount);
		
		// 대기하고 있는 고객에게 알림을 줌
		this.notify();

		if (this.productCount == MAX_PRODUCT) {
			System.out.println("상품을 더 저장할 수 없어서 직원이 휴식 시간을 가짐.");
			// 직원 쓰레드를 현재 상점 객체에서 정지상태로 만듬
			// wait 상태에 빠져든 쓰레드는 상대방 쓰레드에 의해서
			// notify 메소드가 호출되어야만 다시 활성화 될 수 있다.
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("고객이 호출하여 다시 물건을 만들기 시작함.");
		}
	}

	// 상품을 판매하는 메소드
	// - 고객 쓰레드에 의해서 실행되는 메소드
	
	// 공유 자원으로 사용되는 클래스의 메소드 내부에서 
	// wait / notify 메소드가 호출되는 경우
	// 해당 메소드는 반드시 동기화가 지원되어야만 한다.
	public synchronized void buy() {
		if (this.productCount == 0) {
			System.out.println("상품을 구매할 수 없어서 고객이 대기 상태에 들어감.");
			// 고객 쓰레드를 현재 상점 객체에서 정지상태로 만듬
			// wait 상태에 빠져든 쓰레드는 상대방 쓰레드(직원)에 의해서
			// notify 메소드가 호출되어야만 다시 활성화 될 수 있다.
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("상품이 준비되어 고객이 구매를 시작함.");
		}
		this.productCount--;

		System.out.printf("고객이 상품 개수를 %d 개로 감소시킴.\n", this.productCount);
		
		// 대기하고 있는 직원에게 알림
		this.notify();
	}

}

class EmpWithSync extends Thread {
	private StoreWithSync store;
	private int sleepTime;

	public EmpWithSync(StoreWithSync store, int sleepTime) {
		this.store = store;
		this.sleepTime = sleepTime;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(this.sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.store.make();
		}
	}
}

class CustomerWithSync extends Thread {
	private StoreWithSync store;
	private int sleepTime;

	public CustomerWithSync(StoreWithSync store, int sleepTime) {
		this.store = store;
		this.sleepTime = sleepTime;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(this.sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.store.buy();
		}
	}
}

public class Thread_16 {
	public static void main(String[] args) {
		// 직원과 고객이 공유하는 상점 객체를 생성
		StoreWithSync store = new StoreWithSync();

		// 직원 쓰레드 객체를 생성
		EmpWithSync emp = new EmpWithSync(store, 1000);
		// 고객 쓰레드 객체를 생성
		CustomerWithSync customer = new CustomerWithSync(store, 500);

		emp.start();
		customer.start();
	}
}
