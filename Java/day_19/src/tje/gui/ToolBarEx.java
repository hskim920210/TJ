package tje.gui;

import javax.swing.*;
import java.awt.*;

public class ToolBarEx extends JFrame {
	Container contentPane;
	ToolBarEx() {
		setTitle("툴바 만들기 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(400, 300);
		setVisible(true);
	}
	
	void createToolBar() {
		JToolBar toolBar = new JToolBar("My Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton(new ImageIcon("chick.jpg")));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("selChick.jpg")));
		toolBar.add(new JLabel("Search"));
		toolBar.add(new JTextField("Text Field"));
		
		JComboBox combo = new JComboBox();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		
		toolBar.add(combo);
		
		contentPane.add(toolBar, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new ToolBarEx();
	}
}
