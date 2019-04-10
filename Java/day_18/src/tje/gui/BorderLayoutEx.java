package tje.gui;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
	
	BorderLayoutEx() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout(60,100));
		add(new JButton("add"), BorderLayout.NORTH);
		add(new JButton("sub"), BorderLayout.SOUTH);
		add(new JButton("mul"), BorderLayout.EAST);
		add(new JButton("div"), BorderLayout.WEST);
		add(new JButton("calculate"), BorderLayout.CENTER);
		
		setSize(1000,800);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new BorderLayoutEx();

	}

}
