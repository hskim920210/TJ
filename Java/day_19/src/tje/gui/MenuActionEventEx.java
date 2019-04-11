package tje.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuActionEventEx extends JFrame {
	Container contentPane;
	JLabel label = new JLabel("Hello");
	
	MenuActionEventEx() {
		setTitle("Menu Avtion Event 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(300,250);
		setVisible(true);
	}
	
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem[] menuItem = new JMenuItem[4];
		String[] itemTitle = {"Color", "Font", "Top", "Bottom"};
		JMenu fileMenu = new JMenu("Text");
		
		for(int i = 0 ; i < menuItem.length ; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new MenuActionListener());
			fileMenu.add(menuItem[i]);
		}
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	// Color 클릭마다 색이 바뀌게 해보기.
	// Left, Right, Center도 해보기
	// Reset 버튼도 만들어보기
	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("Color"))
				label.setForeground(Color.BLUE);
			else if(cmd.equals("Font"))
				label.setFont(new Font("Ravie", Font.ITALIC, 50));
			else if(cmd.equals("Top"))
				label.setVerticalAlignment(SwingConstants.TOP);
			else 
				label.setVerticalAlignment(SwingConstants.BOTTOM);
		}
	}

	public static void main(String[] args) {
		new MenuActionEventEx();
	}
}
