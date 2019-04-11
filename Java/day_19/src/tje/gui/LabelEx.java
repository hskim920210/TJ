package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelEx extends JFrame {
	Container contentPane;
	LabelEx() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JLabel textLabel = new JLabel("보고싶다 .. //");
		ImageIcon love = new ImageIcon("D:\\dev\\love.jpg");
		JLabel imageLabel = new JLabel(love);
		ImageIcon talk = new ImageIcon("D:\\dev\\kt.JPG");
		JLabel label = new JLabel("////", talk, SwingConstants.CENTER);
		
		contentPane.add(textLabel);
		contentPane.add(imageLabel);
		contentPane.add(label);
		
		setSize(600, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LabelEx();
	}
}
