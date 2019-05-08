package tje.chat.server.panel;

import java.awt.*;
import javax.swing.*;

public class SouthPanel extends JPanel {
	private JLabel lbMsg = new JLabel("공지 메세지");
	private JTextField tfNoticeMsg = new JTextField();
	private JButton btnSend = new JButton("전송");
	private Font f_30 = new Font("이태릭", Font.PLAIN, 30);

	public SouthPanel() {
		this.setLayout(new BorderLayout());
		this.lbMsg.setFont(f_30);
		this.tfNoticeMsg.setFont(f_30);
		this.btnSend.setFont(f_30);

		this.add(lbMsg, BorderLayout.WEST);
		this.add(tfNoticeMsg, BorderLayout.CENTER);
		this.add(btnSend, BorderLayout.EAST);

	}

	// 이 클래스의 필드멤버에 접근하기 위한 겟터를 만듬.
	public JTextField getTfNoticeMsg() {
		return tfNoticeMsg;
	}

	public JButton getBtnSend() {
		return btnSend;
	}
}
