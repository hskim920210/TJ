package tje.chat.server.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SouthPanel extends JPanel {
	private JLabel lbMsg = new JLabel("공지 메세지");
	private JTextField tfNoticeMsg = new JTextField();
	private JButton btnSend = new JButton("전송");

	public SouthPanel() {
		this.setLayout(new BorderLayout());

		this.add(lbMsg, BorderLayout.WEST);
		this.add(tfNoticeMsg, BorderLayout.CENTER);
		this.add(btnSend, BorderLayout.EAST);
	}

	public JTextField getTfNoticeMsg() {
		return tfNoticeMsg;
	}

	public JButton getBtnSend() {
		return btnSend;
	}

}
