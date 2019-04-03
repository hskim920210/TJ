package tje.thread;

// JAVA 프로그램의 구동과정
// 1. static, 상수 영역의 메모리 로딩
// 2. static 영역의 메소드 중 public static void main 메소드 검색
// 3. 검색된 main 메소드를 Thread 클래스의 run 메소드 처럼 사용하여
//	  Thread 객체를 생성 ( 이름은 main 으로 지정 )
// 4. main 쓰레드를 구동

public class Thread_08 {
	public static void main(String[] args) {
		// Thread 클래스의 currentThread 메소드는
		// 현재 실행코드를 실행하는 쓰레드 객체를 반환해주는 메소드
		Thread t = Thread.currentThread();

		String name = t.getName();
		System.out.printf("현재 실행중인 쓰레드의 이름은 %s 입니다.\n", name);
	}
}
