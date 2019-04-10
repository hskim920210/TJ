package tje.gui;

import javax.swing.*;
import java.awt.*;


public class NullContainerEx extends JFrame {
	NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel la = new JLabel("Hello ~  Press BUTTONS !!");
		la.setLocation(700, 250);
		la.setSize(500, 100);
		add(la);
		
		JLabel la1 = new JLabel("버튼을 누르세요 ~~");
		la1.setLocation(700, 420);
		la1.setSize(500, 100);
		add(la1);
		
		JLabel la2 = new JLabel("seoigjpsoeihjposi");
		la2.setLocation(700, 325);
		la2.setSize(500, 100);
		add(la2);
		
		for(int i = 1 ; i <= 10 ; i++ ) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*60, i*40);
			b.setSize(80,60);
			add(b);			
		}
		for(int i = 10 ; i >= 1 ; i--) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*60, (18-i)*40);
			b.setSize(80,60);
			add(b);	
		}
		
		setSize(1000,1000);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new NullContainerEx();

	}

}
