package tje.thread;

// 프로그램의 수행 중 동시에 처리하고자 하는 작업이 생겼을 때는
// java.lang.Thread 클래스를 사용할 수 있습니다.

// Thread
// 프로그램 실행의 흐름을 분기할 수 있는 방법을 제공하는 클래스
// ex) OS의 멀티태스킹

// 구현방법
// 2. Runnable 인터페이스를 구현하는 방법
// 2. Runnable 인터페이스를 구현하는 방법
// 2-1. Runnable 인터페이스를 구현하는 클래스 작성
// 2-2. public void run() 오버라이딩 구현
// 2-3. 해당 클래스의 A 객체 생성
// 2-4. A 객체를 Thread 클래스의 생성자로 전달하여
//		Thread 객체 생성
// 2-5. 생성시킨 쓰레드의 start 메소드 호출!

class Thread_D_1 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Thread_D_1 -> i = %d\n", i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Thread_D_2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Thread_D_2 -> i = %d\n", i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class Thread_04 {

	public static void main(String[] args) {
		// Runnable 인ㄴ터페이스를 구현한 쓰레드 생성
		// 1. Runnable 인터페이스를 구현한 클래스의 객체 생성
		Thread_D_1 d1 = new Thread_D_1();
		// Thread_D_2 d2 = new Thread_D_2();

		// 2. 1에서 생성된 객체를 사용하여 Tread 객체 생성
		Thread t1 = new Thread(d1);
		// Thread t2 = new Thread(d2);

		// 3. 2에서 생성된 Tread 객체를 사용하여 start 메소드 호출
		t1.start();
		// t2.start();

		// 위의 과정을 한 라인으로 작성한 코드
		new Thread(new Thread_D_2()).start();

		for (int i = 1; i <= 10; i++) {
			System.out.printf("main -> i = %d\n", i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
