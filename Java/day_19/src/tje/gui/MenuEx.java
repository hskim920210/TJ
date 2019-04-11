package tje.gui;

import javax.swing.*;
import java.awt.*;

public class MenuEx extends JFrame {
	MenuEx() {
		setTitle("Menu 만들기 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createMenu();
		setSize(250,200);
		setVisible(true);
	}
	
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		fileMenu.add(new JMenuItem("새로 만들기"));
		fileMenu.add(new JMenuItem("열기"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("저장하기"));
		fileMenu.add(new JMenuItem("다른 이름으로 저장하기"));
		
		mb.add(fileMenu);
		
		mb.add(new JMenu("편집"));
		mb.add(new JMenu("소스"));
		mb.add(new JMenu("프로젝트"));
		mb.add(new JMenu("실행"));
		
		this.setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}

}
