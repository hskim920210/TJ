package tje.gui;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {
	
	FlowLayoutEx() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 40, 100));
		add(new JButton("add"));
		add(new JButton("sub"));
		add(new JButton("mul"));
		add(new JButton("div"));
		add(new JButton("calculate"));
		add(new JButton("diff"));
		add(new JButton("integ"));
		
		setSize(1000, 800);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new FlowLayoutEx();

	}

}
