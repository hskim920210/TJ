package tje.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SliderChangeEx extends JFrame {
	Container contentPane;
	JLabel colorLabel;
	JSlider[] sl = new JSlider[3];
	
	SliderChangeEx() {
		setTitle("슬라이더와 ChangeEvent 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		colorLabel = new JLabel(" 		SLIDER EXAMPLE 		");
		
		for(int i = 0 ; i < sl.length ; i++) {
			sl[i] = new JSlider(JSlider.VERTICAL, 0, 255, 128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener(new MyChangeListener());
			contentPane.add(sl[i]);
		}
		sl[0].setForeground(Color.red);
		sl[1].setForeground(Color.green);
		sl[2].setForeground(Color.blue);
		
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(
				sl[0].getValue(),
				sl[1].getValue(),
				sl[2].getValue()));
		
		contentPane.add(colorLabel);
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			colorLabel.setBackground(new Color(
					sl[0].getValue(),
					sl[1].getValue(),
					sl[2].getValue()));
		}
	}

	public static void main(String[] args) {
		new SliderChangeEx();

	}

}
