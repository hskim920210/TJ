package tje.thread;

import java.util.*;

class Thread_As extends Thread {
	public Thread_As(String name) {
		super(name);
	}

	public void run() {
		double num = 1000 + (Math.random() * 5000) + 1;
		int sec = (int) num;

		for (int i = 1; i < 11; i++) {
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {

			}

			if (i != 10) {
				System.out.printf("%s 님이  %d 바퀴를 통과했습니다.\n", this.getName(), i);

			} else
				System.out.printf("%s 님이 통과했습니다.\n", this.getName());
		}
	}
}

class Thread_Bs extends Thread {
	public Thread_Bs(String name) {
		super(name);
	}

	public void run() {
		double num = 1500 + (Math.random() * 5000) + 1;
		int sec = (int) num;

		for (int i = 1; i < 11; i++) {
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {

			}
			
			if (i != 10) {
				System.out.printf("%s 님이  %d 바퀴를 통과했습니다.\n", this.getName(), i);

				
			} else
				System.out.printf("%s 님이 통과했습니다.\n", this.getName());

		}
	}
}

class Thread_Cs extends Thread {
	public Thread_Cs(String name) {
		super(name);
	}

	public void run() {
		double num = 1700 + (Math.random() * 5000);
		int sec = (int) num;

		for (int i = 1; i < 11; i++) {
			if (i != 10) {
				
				try {
					Thread.sleep(sec);
				} catch (InterruptedException e) {

				}
				System.out.printf("%s 님이  %d 바퀴를 통과했습니다.\n", this.getName(), i);

			} else
				System.out.printf("%s 님이 통과했습니다.\n", this.getName());
		}
	}
}

public class Thread_10 {

	public static void main(String[] args) {
		
		
		Thread_As t1 = new Thread_As("A");
		Thread_Bs t2 = new Thread_Bs("B");
		Thread_Cs t3 = new Thread_Cs("C");
		
		t1.start();
		t2.start();
		t3.start();

//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//		}

//		t1.interrupt();
//		t2.interrupt();
//		t3.interrupt();

	}

}
