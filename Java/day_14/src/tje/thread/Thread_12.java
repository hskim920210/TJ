package tje.thread;

// 동기화
// 다수개의 쓰레드를 활용하여 프로그래밍을 처리하는 경우
// 해결해야만 하는 문제(멀티 쓰레딩 환경)

// 다수개의 쓰레드가 하나의 공유자원을 사용하는 경우 발생하는 문제.

// 칠판 클래스
class WhiteBoard {
	private int total;
	
	public WhiteBoard(int total) {
		this.total = total;
	}
	
	public void update() {
		this.total++;
	}
	
	@Override
	public String toString() {
		return String.format("total = %d", this.total);
	}
}

class Student extends Thread {
	private WhiteBoard board;
	public Student(String name, WhiteBoard board) {
		super(name);
		this.board = board;
	}
	public void run() {
		for( int i = 0 ; i < 10000 ; i++ ) {
			this.board.update();
		}
	}
}

public class Thread_12 {
	public static void main(String[] args) {
		// 공유자원 객체 생성
		// 다수명의 학생들이 공유하는 칠판을 생성
		WhiteBoard board = new WhiteBoard(1);
		
		// 하나의 칠판을 공유하고 있는 쓰레드 객체
		Student s1 = new Student("S1", board);
		Student s2 = new Student("S2", board);
		Student s3 = new Student("S3", board);
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
