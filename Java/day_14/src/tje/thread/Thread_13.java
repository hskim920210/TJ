package tje.thread;

// 동기화
// 다수개의 쓰레드를 활용하여 프로그래밍을 처리하는 경우
// 해결해야만 하는 문제(멀티 쓰레딩 환경)
// 한번에 하나씩만 처리

// 다수개의 쓰레드가 하나의 공유자원을 사용하는 경우 발생하는 문제.

// 칠판 클래스
class WhiteBoardWithSync {
	private int total;

	public WhiteBoardWithSync(int total) {
		this.total = total;
	}

	// 동기화를 구현하고 있는 메소드 선언
	// 메소드의 선언부에 synchronized 키워드 선언하면
	// 해당 메소드는 하나의 쓰레드 객체가 선점하여 실행될 수 있다.
	public synchronized void update() {
		this.total++;
	}

	@Override
	public String toString() {
		return String.format("total = %d", this.total);
	}
}

class StudentWithSync extends Thread {
	private WhiteBoardWithSync board;

	public StudentWithSync(String name, WhiteBoardWithSync board) {
		super(name);
		this.board = board;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			this.board.update();
		}
	}
}

public class Thread_13 {
	public static void main(String[] args) {
		// 동기화를 지원하는 공유자원 객체 생성
		// 다수명의 학생들이 공유하는 칠판을 생성
		WhiteBoardWithSync board = new WhiteBoardWithSync(1);

		// 하나의 칠판을 공유하고 있는 쓰레드 객체
		StudentWithSync s1 = new StudentWithSync("S1", board);
		StudentWithSync s2 = new StudentWithSync("S2", board);
		StudentWithSync s3 = new StudentWithSync("S3", board);
		s1.start();
		s2.start();
		s3.start();
		try {
			s1.join();
			s2.join();
			s3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(board);
		System.out.println("프로그램 종료");

	}
}
