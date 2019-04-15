package Chatting;

import java.awt.event.*;
import javax.swing.*;


public class ButtonListener implements ActionListener {
	
	JTextField Field;
	JTextArea Area;
	String nick;

	ButtonListener(JTextField Field, JTextArea Area, JTextField nick) {
		this.Field = Field;
		this.Area = Area;
		this.nick = nick.getText();
	}
	
	ButtonListener(JTextField Field, JTextArea Area, String nick) {
		this.Field = Field;
		this.Area = Area;
		this.nick = nick;
	}
	
	public String toString() {
		return String.format("%s   :  %s\n", this.nick, Field.getText());
	}
	

	public void actionPerformed(ActionEvent e) {
		
		// 전송 버튼이 눌릴 때 마다 텍스트 필드에 적힌 글을 추가
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("전송")) {
			Area.append(toString());
			Field.setText("");
			//Area.append("\n");
		}
	}
}
