package tje.gui;

import javax.swing.*;

public class MyFrame extends JFrame {
	MyFrame() {
		setTitle("첫번째 프레임");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
