package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerEx extends JFrame {
	JLabel la;
	MouseListenerEx() {
		setTitle("마우스 이벤트 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		setLayout(null);
		contentPane.addMouseListener(new MyMouseListener());
		
		la = new JLabel("HELLO");
		la.setSize(100, 100);
		la.setLocation(30, 30);
		contentPane.add(la);
		
		setSize(800, 800);
		setVisible(true);
		
	}
	
	class MyMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new MouseListenerEx();
	}
}
