package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;

public class NorthPanel extends JPanel {
	private JLabel lbServerInfo = new JLabel("서버정보", SwingConstants.CENTER);
	private JLabel lbIP = new JLabel("IP", SwingConstants.CENTER);
	private JTextField tfIP = new JTextField();
	private JLabel lbPORT = new JLabel("PORT", SwingConstants.CENTER);
	private JTextField tfPORT = new JTextField();
	private JLabel lbNickName = new JLabel("별칭", SwingConstants.CENTER);
	private JTextField tfNickName = new JTextField();
	private JCheckBox cbSaveInfo = new JCheckBox("정보유지", false);
	private JButton btConnect = new JButton("연결");

	public NorthPanel() {
		this.setLayout(new GridLayout(1, 9));

		this.add(lbServerInfo);
		this.add(lbIP);
		this.add(tfIP);
		this.add(lbPORT);
		this.add(tfPORT);
		this.add(lbNickName);
		this.add(tfNickName);
		this.add(cbSaveInfo);
		this.add(btConnect);

	}

	// 외부에서 접근을 위한 겟터 설정
	public JTextField getTfIP() {
		return tfIP;
	}

	public JTextField getTfPORT() {
		return tfPORT;
	}

	public JTextField getTfNickName() {
		return tfNickName;
	}

	public JCheckBox getCbSaveInfo() {
		return cbSaveInfo;
	}

	public JButton getBtConnect() {
		return btConnect;
	}
}
