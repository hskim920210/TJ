package tje.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("Action"))
			b.setText("액션");
		else
			b.setText("Action");
	}
}

public class ListenerSample extends JFrame {
	
	ListenerSample () {
		setTitle("Action 이벤트 리스너 작성");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		add(btn);
		setSize(800,600);
		setVisible(true);
	}
	
	
	

	public static void main(String[] args) {
		new ListenerSample();

	}

}
