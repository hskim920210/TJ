package tje.gui;

import javax.swing.*;
import java.awt.*;


// JFrame : 이벤트 스레드를 실행
// 이벤트를 기다리는 창 생성.
public class ContentPaneEx extends JFrame {
	
	ContentPaneEx() {
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.PINK);
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("확인"));
		contentPane.add(new JButton("취소"));
		contentPane.add(new JButton("무시"));
		
		setSize(1000,800);
		setVisible(true);
		
		
		
	}
	

	public static void main(String[] args) {
		new ContentPaneEx();

	}

}
