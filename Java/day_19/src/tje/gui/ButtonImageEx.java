package tje.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ButtonImageEx extends JFrame {
	Container contentPane;
	ButtonImageEx() {
		setTitle("버튼에 아이콘 달기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon normalcall = new ImageIcon("D:\\dev\\call.png");
		ImageIcon rollovercall = new ImageIcon("D:\\dev\\tenor.gif");
		ImageIcon pressedcall = new ImageIcon("D:\\dev\\855306768.jpg");
		
		JButton btn = new JButton("띌릐르리리릐릘ㄹ", normalcall);
		btn.setRolloverIcon(rollovercall);
		btn.setPressedIcon(pressedcall);
		
		contentPane.add(btn);
		
		setSize(600, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ButtonImageEx();
	}
}
