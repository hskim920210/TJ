package tje.thread;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ThreadEX_Timer extends JFrame {
	private JLabel lbTimer;
	private JButton btnStart;
	private JButton btnStop;

	private TimerThread timerThread;

	public ThreadEX_Timer(String title) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(title);

		lbTimer = new JLabel("00 : 00 : 00 : 00", SwingConstants.CENTER);
		lbTimer.setFont(new Font("Serif", Font.BOLD, 300));
		this.add(lbTimer, BorderLayout.CENTER);

		JPanel southPanel = new JPanel(new GridLayout(1, 2));
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");
		btnStart.setEnabled(true);
		btnStop.setEnabled(false);
		
		southPanel.add(btnStart, 0);
		southPanel.add(btnStop, 1);

		this.add(southPanel, BorderLayout.SOUTH);

		this.btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timerThread = new TimerThread();
				timerThread.start();
				
				btnStart.setEnabled(false);
				btnStop.setEnabled(true);
			}
		});

		this.btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( timerThread != null )
					timerThread.interrupt();
				
				timerThread = null;
				
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
			}
		});

		this.setSize(300, 200);
		this.setVisible(true);
	}

	class TimerThread extends Thread {
		public void run() {
			int nHour = 0;
			int nMinute = 0;
			int nSecond = 0;
			int nd = 0;
			while (true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// 현재 쓰레드 객체에 대해서 interrupt
					// 메소드가 호출되는 경우 실행되는 코드
					// (STOP 버튼이 클릭되는 순간 실행)
					break;
				}

				nd++;
				
				if (nd >= 100) {
					nd = 0;
					nSecond++;
				}

				if (nSecond >= 60) {
					nSecond = 0;
					nMinute++;
				}

				if (nMinute >= 60) {
					nMinute = 0;
					nHour++;
				}

				String strTimer = String.format("%02d : %02d : %02d : %02d", nHour, nMinute, nSecond, nd);
				lbTimer.setText(strTimer);
			}

			// 타이머 종료 후, 텍스트 초기화1
			lbTimer.setText("00 : 00 : 00 : 00");
		}
	}

	public static void main(String[] args) {
		ThreadEX_Timer frame = new ThreadEX_Timer("Timer EX");

	}

}
