package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerAllEx extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel la;
	
	MouseListenerAllEx() {
		setTitle("마우스 리스너와 마우스 모션리스너 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(contentPane);
		
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.addMouseMotionListener(new MyMouseListener());
		
		la = new JLabel("마우스 이벤트 없음");
		contentPane.add(la);
		setSize(500,500);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {
		
		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("마우스 드래그 (" + e.getX() + "," + e.getY() + ")");
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			JPanel p = (JPanel) e.getSource();
			p.setBackground(Color.GREEN);
			// 아래처럼 사용해도 된다.
//			contentPane.setBackground(Color.GREEN);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			contentPane.setBackground(Color.pink);
			// 아래처럼 사용해도 된다.
//			JPanel p = (JPanel) e.getSource();
//			p.setBackground(Color.pink);
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("마우스 움직임 (" + e.getX() + "," + e.getY() + ")");
		}
		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("마우스 눌림 (" + e.getX() + "," + e.getY() + ")");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("마우스 놓임 (" + e.getX() + "," + e.getY() + ")");
		}
		
		
		@Override
		public void mouseClicked(MouseEvent e) {}
	}

	public static void main(String[] args) {
		new MouseListenerAllEx();
	}
}
