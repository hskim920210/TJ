package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonItemEventEx extends JFrame {
	Container contentPane;
	JRadioButton[] radio = new JRadioButton[3];
	String[] text = {"피자", "햄버거", "치킨"};
	ImageIcon[] image = {
			new ImageIcon("pizza.jpg"),
			new ImageIcon("burg.jpg"),
			new ImageIcon("chick.jpg")};
	JLabel imageLabel = new JLabel();
	
	RadioButtonItemEventEx() {
		setTitle("라디오 버튼 아이템 이벤트 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		
		ButtonGroup g = new ButtonGroup();
		for(int i = 0 ; i < radio.length ; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			panel.add(radio[i]);
			radio[i].addItemListener(new MyItemListener());
		}
		radio[2].setSelected(true);
		contentPane.add(panel, BorderLayout.SOUTH);
		contentPane.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return;
			if(radio[0].isSelected())
				imageLabel.setIcon(image[0]);
			else if(radio[1].isSelected())
				imageLabel.setIcon(image[1]);
			else
				imageLabel.setIcon(image[2]);
		}
	}
	
	public static void main(String[] args) {
		new RadioButtonItemEventEx();
	}
}
