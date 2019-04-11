package tje.gui;

import javax.swing.*;
import java.awt.*;

public class CheckBoxEx extends JFrame {
	Container contentPane;
	CheckBoxEx() {
		setTitle("체크박스 만들기 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon chick = new ImageIcon("chick.jpg");
		ImageIcon selChick = new ImageIcon("selChick.jpg");
		
		JCheckBox pizz = new JCheckBox("피자");
		JCheckBox burg = new JCheckBox("햄버거");
		JCheckBox dak = new JCheckBox("치킨", chick);
		dak.setBorderPainted(true);
		dak.setSelectedIcon(selChick);
		
		contentPane.add(pizz);
		contentPane.add(burg);
		contentPane.add(dak);
		
		setSize(800, 800);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new CheckBoxEx();

	}

}
