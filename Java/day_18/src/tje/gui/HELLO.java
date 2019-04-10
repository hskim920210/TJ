package tje.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HELLO extends JFrame {
	JLabel la = new JLabel("HELLO");
	JPanel cp = new JPanel();

	HELLO() {

		setTitle("상, 하, 좌, 우 키로 HELLO 문자열 움직이기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp.addKeyListener(new MyKeyListener());

		cp.setLayout(null);
		cp.setFocusable(true);

		setContentPane(cp);

		la.setSize(200, 20);

		la.setLocation(50, 50);
		cp.add(la);
		setSize(300, 300);
		setVisible(true);
		cp.requestFocus();

	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			la.setText(e.getKeyText(e.getKeyCode()) + "키를 입력했습니다.");
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				int x = la.getX();
				int y = la.getY() - 10;
				la.setLocation(x, y);
			}

			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				int x = la.getX();
				int y = la.getY() + 10;
				la.setLocation(x, y);
			}

			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				int x = la.getX() - 10;
				int y = la.getY();
				la.setLocation(x, y);
			}

			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				int x = la.getX() + 10;
				int y = la.getY();
				la.setLocation(x, y);
			}
		}
	}

	public static void main(String[] args) {
		new HELLO();

	}

}
