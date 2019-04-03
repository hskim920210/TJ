package tje.thread;

class Thread_F extends Thread {
	// 쓰레드 객체의 이름을 지정하는 방법
	// setName 메소드를 사용하여 이름을 지정할 수 있음
	// 하지만 일반적으로 Thread 클래스의 문자열을 매개변수로
	// 받는 생성자를 사용

	public Thread_F(String name) {
		// 부모 클래스 Thread 클래스의 생성자를 사용하여 이름을 지정하는 예제
		super(name);
	}

	@Override
	public void run() {
		System.out.printf("현재 실행중인 쓰레드의 이름은 %s 입니다.\n", this.getName());
	}
}

public class Thread_07 {

	public static void main(String[] args) {
		Thread_F t1 = new Thread_F("One");
		Thread_F t2 = new Thread_F("Two");
		Thread_F t3 = new Thread_F("Three");

		t1.start();
		t2.start();
		t3.start();
	}
}
