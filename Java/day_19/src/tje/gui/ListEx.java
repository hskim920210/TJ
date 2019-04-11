package tje.gui;

import javax.swing.*;
import java.awt.*;

public class ListEx extends JFrame {
	Container contentPane;
	String[] foods = {"pizza", "hamburger", "chicken", "pork", "pancakes", "snacks"};
	ImageIcon[] images = {new ImageIcon("pizza.jpg"), new ImageIcon("chick.jpg"), new ImageIcon("burg.jpg")};
	
	ListEx() {
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JList strList = new JList(foods);
		contentPane.add(strList);
		
		JList imageList = new JList();
		imageList.setListData(images);
		contentPane.add(imageList);
		
		JList scrollList = new JList(foods);
		contentPane.add(new JScrollPane(scrollList));
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListEx();
	}
}
