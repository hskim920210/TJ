package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;

public class CenterRightPanel extends JPanel {
	private JTextArea taChatMsg = new JTextArea();
	private JTextField tfSendMsg = new JTextField();
	private JButton btSend = new JButton("Àü¼Û");
	
	public CenterRightPanel() {
		this.setLayout(new BorderLayout());
		
		JScrollPane sp = new JScrollPane(taChatMsg);
		this.add(sp, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(tfSendMsg, BorderLayout.CENTER);
		panel.add(btSend, BorderLayout.EAST);
		
		this.add(panel, BorderLayout.SOUTH);
	}

	public JTextArea getTaChatMsg() {
		return taChatMsg;
	}

	public JTextField getTfSendMsg() {
		return tfSendMsg;
	}

	public JButton getBtSend() {
		return btSend;
	}

}
