package tje.thread;

// 프로그램의 수행 중 동시에 처리하고자 하는 작업이 생겼을 때는
// java.lang.Thread 클래스를 사용할 수 있습니다.

// Thread
// 프로그램 실행의 흐름을 분기할 수 있는 방법을 제공하는 클래스
// ex) OS의 멀티태스킹

//구현방법
// 1. Thread 클래스를 상속받는 방법
// 1-1. Thread 클래스를 상속받아 public void run() 메소드를 오버라이딩
//      합니다.
//	    public void run() : 쓰레드가 생성되어 수행할 작업을 정의하는 메소드
// 1-2. 해당 클래스의 객체를 생성하고, start 메소드를 실행합니다.
//		오버라이딩한 run 메소드를 호출하면, 쓰레드가 생성되는 것이 아닌
//      일반 메소드를 수행합니다.

//2. Runnable 인터페이스를 구현하는 방법

class Thread_C_1 extends Thread{
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("Thread_C_1 -> i = %d\n", i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Thread_C_2 extends Thread{
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("Thread_C_2 -> i = %d\n", i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class Thread_03 {
	public static void main(String[] args) {
		
		Thread_C_1 c1 = new Thread_C_1();
		Thread_C_2 c2 = new Thread_C_2();
		
		// Thread 클래스의 start 메소드는 현재 객체를 사용하여
		// 쓰레드를 생성한 후, run 메소드를 호출하여
		// 해당 쓰레드가 동작할 수 있도록 수행하는 메소드.
		
		c1.start();
		c2.start();
		
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("main -> i = %d\n", i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
