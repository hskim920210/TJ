package tje.gui;

import javax.swing.*;
import java.awt.*;

public class ToolTipEx extends JFrame {
	Container contentPane;
	
	ToolTipEx() {
		setTitle("툴팁 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(400, 300);
		setVisible(true);
	}
	
	void createToolBar() {
		JToolBar bar = new JToolBar("My Menu");
		bar.setBackground(Color.LIGHT_GRAY);
		JButton newBtn = new JButton("New");
		newBtn.setToolTipText("파일을 생성합니다.");
		bar.add(newBtn);
		
		JButton openBtn = new JButton(new ImageIcon("chick.jpg"));
		openBtn.setToolTipText("파일을 엽니다.");
		bar.add(openBtn);
		
		bar.addSeparator();
		
		JButton saveBtn = new JButton(new ImageIcon("selChick.jpg"));
		saveBtn.setToolTipText("파일을 저장합니다.");
		bar.add(saveBtn);
		
		bar.add(new JLabel("Search"));
		
		JTextField tf = new JTextField("Text Field");
		tf.setToolTipText("찾고자 하는 문자열을 입력하세요");
		bar.add(tf);
		
		contentPane.add(bar, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new ToolTipEx();
	}
}
