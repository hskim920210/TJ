package tje.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerClassListener extends JFrame {
	JButton btn = new JButton("Action");
	InnerClassListener() {
		setTitle("액션 이벤트 리스너 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
		
		
		// 익명 클래스 사용 ver2 ( 상위 클래스의 멤버필드를 사용 )
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn.getText().equals("Action")) 
					btn.setText("액션");
				else 
					btn.setText("Action");
					// AnonymousClassListener의 멤버나 
					// JFrame의 멤버를 호출할 수 있음
					setTitle(btn.getText());
			}
		}
		);
		
		
		// 익명 클래스 사용 ver1
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JButton b = (JButton)e.getSource();
//				if(b.getText().equals("Action")) 
//					b.setText("액션");
//				else 
//					b.setText("Action");
//					// AnonymousClassListener의 멤버나 
//					// JFrame의 멤버를 호출할 수 있음
//					setTitle(b.getText());
//			}
//		}
//		);

		// btn.setSize(700, 700);
		add(btn);
	}
	
//	private class MyActionListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			// InnerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있다.
//			if(btn.getText().equals("Action"))
//				btn.setText("액션");
//			else
//				btn.setText("Action");
//			
//			// JFrame.setTitle() 호출
//			setTitle(btn.getText());
//		}
//	}
//	

	public static void main(String[] args) {
		new InnerClassListener();
	}
}
