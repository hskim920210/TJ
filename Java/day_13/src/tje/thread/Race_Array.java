package tje.thread;

import java.util.*;

class Thread_Ar extends Thread {
	public Thread_Ar(String name) {
		super(name);
	}

	public void run() {
		double num = 1000 + (Math.random() * 5000);
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

public class Race_Array {

	public static void main(String[] args) {
		
		
		Thread_Ar t1 = new Thread_Ar("A");
		Thread_Ar t2 = new Thread_Ar("B");
		Thread_Ar t3 = new Thread_Ar("C");
		
		ArrayList<Thread_Ar> run = new ArrayList<Thread_Ar>();
		
		run.add(t1);
		run.add(t2);
		run.add(t3);
		
		for(int i = 0 ; i < run.size() ; i++ ) {
			run.get(i).start();
		}

	}

}