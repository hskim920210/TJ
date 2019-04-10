package tje.gui;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {
	GridLayoutEx() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		GridLayout grid = new GridLayout(4,2);
//		
//		grid.setVgap(5);
		
		setLayout(new GridLayout(4,2,0,40));
		
		add(new JLabel(" 이름"));
		add(new JTextField(""));
		add(new JLabel(" 학번"));
		add(new JTextField(""));
		add(new JLabel(" 학과"));
		add(new JTextField(""));
		add(new JLabel(" 과목"));
		add(new JTextField(""));
		
		setSize(1000, 800);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutEx();
	}

}
