package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 인터페이스 상속은 추상메소드를 전부 구현해야함
// 이게 싫으면 Adaptor로 하면 됨.
class MyMouseListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.RED);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.GREEN);
	}
}

public class ListenerMouseEx extends JFrame {
	ListenerMouseEx() {
		setTitle("버튼에 마우스 이벤트 리스너 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton btn = new JButton("마우스 이벤트 테스트 버튼");
		btn.setBackground(Color.GREEN);
		MyMouseListener listener = new MyMouseListener();
		btn.addMouseListener(listener);
		add(btn);
		setSize(500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerMouseEx();
	}
}


