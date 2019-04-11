package tje.gui;

import java.awt.*;
import javax.swing.*;

public class ComboBoxEx extends JFrame {
	Container contentPane;
	String[] fruits = {"사과", "바나나", "키위", "망고", "배", "복숭아", "딸기", "블랙베리"};
	String[] names = {"가영", "나영", "다영", "아영"};
	
	ComboBoxEx() {
		setTitle("콤보박스 만들기 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JComboBox strCombo = new JComboBox(fruits);
		contentPane.add(strCombo);
		
		JComboBox nameCombo = new JComboBox();
		for(int i = 0 ; i < names.length ; i++)
			nameCombo.addItem(names[i]);
		contentPane.add(nameCombo);
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboBoxEx();
	}
}
