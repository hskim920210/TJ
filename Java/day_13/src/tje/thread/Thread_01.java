package tje.thread;

class Thread_A_1 {
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("Thread_A_1 -> i = %d\n", i);
		}
	}
}

class Thread_A_2 {
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("Thread_A_2 -> i = %d\n", i);
		}
	}
}

public class Thread_01 {
	public static void main(String[] args) {
		
		// 일반 프로그램은 하나의 실행 흐름을 가지고
		// 프로그램 코드를 실행하는 과정을 수행한다.
		Thread_A_1 a1 = new Thread_A_1();
		Thread_A_2 a2 = new Thread_A_2();
		
		// Thread_A_1의 run 메소드가 실행
		a1.run();
		
		// Thread_A_1의 run 메소드가 실행된 이후
		// Thread_A_2의 run 메소드가 실행
		a2.run();
		
		// Thread_A_2의 run 메소드가 실행된 이후
		// main 메소드의 반복문이 실행
		for(int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("main -> i = %d\n", i);
		}
	}
}
