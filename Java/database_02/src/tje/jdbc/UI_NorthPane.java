package tje.jdbc;

import java.awt.GridLayout;

import javax.swing.*;

public class UI_NorthPane extends JPanel {
	private JLabel signIn = new JLabel("회원가입");
	public UI_NorthPane () {
		this.setLayout(new GridLayout(1, 3));
		this.add(signIn);
	}

}
