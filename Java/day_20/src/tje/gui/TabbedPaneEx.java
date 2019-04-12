package tje.gui;

import javax.swing.*;
import java.awt.*;

public class TabbedPaneEx extends JFrame {
	Container contentPane;
	
	public TabbedPaneEx() {
		setTitle("탭팬 만들기 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		JTabbedPane pane = createTabbedPane();
		contentPane.add(pane, BorderLayout.CENTER);
		setSize(300, 250);
		setVisible(true);
	}
	
	JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.addTab("tab1", new JLabel(new ImageIcon("D:\\dev\\im1.png")));
		pane.addTab("tab2", new JLabel(new ImageIcon("D:\\dev\\im2.png")));
		pane.addTab("tab3", new MyPanel());
		return pane;
	}
	
	class MyPanel extends JPanel {
		MyPanel() {
			this.setBackground(Color.YELLOW);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.fillRect(10, 10, 50, 50);
			
			g.setColor(Color.blue);
			g.fillOval(10, 70, 50, 50);
			
			g.setColor(Color.pink);
			g.fill3DRect(10, 130, 50, 50, false);
			
			g.setColor(Color.black);
			g.drawString("tab3에 들어가는 JPanel입니다.", 80, 50);
		}
	}

	public static void main(String[] args) {
		new TabbedPaneEx();
	}
}
