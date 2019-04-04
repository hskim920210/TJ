package tje.thread;

import java.util.*;

class ThreadGameWithJoin extends Thread {
	public ThreadGameWithJoin(String name) { // name 디폴트가 없음. 꼭 네임을 받아야 객체가 만들어짐.
		super(name);
	}
	public void run() {
		Random random = new Random();
		for( int i = 1 ; i <= 10 ; i++ ) {
			try {
				// 0 ~ 4999 까지의 값을 사용하여
				// 쓰레드 객체를 잠시 중지함.
				// (int)(Math.random() * 5000)
				Thread.sleep(random.nextInt(5000)); // 이 쓰레드를 잠깐 멈춰라.
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
			System.out.printf("%s 님이 %d 바퀴를 통과했습니다.\n", 
					this.getName(), i);
		}		
		System.out.printf("%s 님이 도착했습니다.\n", this.getName()); 
	} // 쓰레드가 할일 다 하고 이제 사라진다.
}

public class Thread_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<ThreadGameWithJoin> list = new ArrayList<>();
		
		System.out.print("참가 인원수를 입력하세요 : ");
		int count = sc.nextInt();
		
		for( int i = 1 ; i <= count ; i++ ) {
			System.out.printf("%d 번째 참가자의 이름을 입력하세요 : ", i);
			list.add(new ThreadGameWithJoin(sc.next()));
		}
		
		for( int i = 0 ; i < count ; i++ )
			list.get(i).start();
		
		// main 쓰레드는 하위 쓰레들이 동작하는 상태에서(main 에서 생성된 쓰레드 객체들)들이
		// 동작하는 상태에서 먼저 종료될 수 있다.
		// 먼저 종료될 수 있습니다.
		// 만약 main 쓰레드들 다른 하위 쓰레드들이 모두 종료될 때 까지
		// 대기하고 있는 경우 join 메소드 사용
		
		// Thread 클래스의 join 메소드
		// 특정 쓰레드가 다른 쓰레드에 종속되어
		// 다른 쓰레드가 종료할 때 까지 대기하는 메소드
		for( int i = 0 ; i < count ; i++ )
			try {
				// main 쓰레드는 리스트 내부에 존재하는 
				// 각각의 쓰레드가 종료될 때 까지 
				// 현재 코드에서 대기합니다.
				list.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		// 모든 쓰레드 객체들의 run 메소드가 종료된 이후
		// 실행되는 코드
		System.out.println("프로그램 종료");
	}
}
