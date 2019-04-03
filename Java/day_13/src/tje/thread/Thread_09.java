package tje.thread;

class Thread_G extends Thread {
	public Thread_G(String name) {
		super(name);
	}

	public void run() {
		// Thread.sleep() 메소드
		// 실행중인 Thread 를 잠시 중지할 수 있는 명령으로
		// 메소드의 매개변수는 밀리세컨초를 입력합니다.
		// Thread.sleep(1000) -> 1 초 동안 중지하는 sleep 메소드
		// InterruptedException 을 처리해 줘야합니다.
		for (int i = 0; i < 11; i++) {
			System.out.printf("%s -> i = %d\n", this.getName(), i);
			try {
				// sleep 메소드는 매개변수로 지정된 시간동안 중지한 후 
				// 다시 구동된다.
				// 만약 sleep 상태의 쓰레드 객체에 대해서
				// interrupt 메소드가 호출되면
				// 즉시 잠에서 깨어 동작한다.
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.printf("%s 쓰레드가 잠에서 강제로 깨어남\n", this.getName());
			}
		}
	}
}

public class Thread_09 {
	public static void main(String[] args) {
		Thread_G t1 = new Thread_G("Sleep-1");
		Thread_G t2 = new Thread_G("Sleep-2");
		Thread_G t3 = new Thread_G("Sleep-3");
		Thread_G t4 = new Thread_G("Sleep-4");
		Thread_G t5 = new Thread_G("Sleep-5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// sleep 상태인 t4 쓰레드 객체를 즉시 구동하게 하는 코드
		t4.interrupt();
	}
}
