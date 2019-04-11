package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionPaneEx extends JFrame {
	Container contentPane;
	
	OptionPaneEx() {
		setTitle("옵션 팬 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		setSize(300,200);
		contentPane.add(new MyPanel(), BorderLayout.NORTH);
		setVisible(true);
	}
	
	class MyPanel extends Panel {
		JButton inputBtn = new JButton("Input Name");
		JTextField tf = new JTextField(10);
		JButton confirmBtn = new JButton("Confirm");
		JButton messageBtn = new JButton("Message");
		
		MyPanel() {
			setBackground(Color.LIGHT_GRAY);
			add(inputBtn);
			add(confirmBtn);
			add(messageBtn);
			add(tf);
			
			inputBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name =
							JOptionPane.showInputDialog("이름을 입력하세요.");
					if(name != null)
						tf.setText(name);
				}
			});
			
			confirmBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "계속하시겠습니까?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.CLOSED_OPTION)
					tf.setText("Just Closed without Selection");
				else if (result == JOptionPane.YES_OPTION)
					tf.setText("YES");
				else
					tf.setText("NO");
				}
			});
			
			messageBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "조심하세요", "Message", JOptionPane.ERROR_MESSAGE);
				}
			});
		}
	}

	public static void main(String[] args) {
		new OptionPaneEx();
	}
}
