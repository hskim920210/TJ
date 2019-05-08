package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;

public class CenterRightPanel extends JPanel {
	private JTextArea taChatMsg = new JTextArea();
	private JTextField tfSendMsg = new JTextField();
	private JButton btSend = new JButton("전송");
	
	private Font f_25 = new Font("플레인", Font.PLAIN, 25);
	private Font f_30 = new Font("플레인", Font.PLAIN, 30);
	
	public CenterRightPanel() {
		this.setLayout(new BorderLayout());
		
		taChatMsg.setFont(f_25);
		JScrollPane sp = new JScrollPane(taChatMsg);
		this.add(sp, BorderLayout.CENTER);

		// 하단의 전송부분을 따로 패널 생성
		JPanel panel = new JPanel(new BorderLayout());
		tfSendMsg.setFont(f_30);
		panel.add(tfSendMsg, BorderLayout.CENTER);
		btSend.setFont(f_25);
		panel.add(btSend, BorderLayout.EAST);

		this.add(panel, BorderLayout.SOUTH);
	}

	// 외부에서 접근가능하도록 겟터를 설정
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
