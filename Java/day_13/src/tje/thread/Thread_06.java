package tje.thread;

class Thread_E extends Thread {
	@Override
	public void run() {
		// 쓰레드의 객체의 이름을 확인
		// Thread 클래스의 getName 메소드를 사용

		// 쓰레드의 이름을 지정하지 않으면 생성되는 순서대로
		// Thread-0, 1, 2 ... 같은 이름을 사용
		System.out.printf("현재 실행중인 쓰레드의 이름은 %s 입니다.\n", this.getName());
	}
}

public class Thread_06 {

	public static void main(String[] args) {
		Thread_E t1 = new Thread_E();
		Thread_E t2 = new Thread_E();
		Thread_E t3 = new Thread_E();

		t1.start();
		t2.start();
		t3.start();
	}
}
