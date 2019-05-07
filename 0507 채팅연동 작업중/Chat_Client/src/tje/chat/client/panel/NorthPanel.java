package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;

public class NorthPanel extends JPanel {
	private JLabel lbServerInfo = new JLabel("서버정보", SwingConstants.CENTER);
	private JLabel lbIP = new JLabel("IP", SwingConstants.CENTER);
	private JTextField tfIP = new JTextField();
	private JLabel lbPORT = new JLabel("PORT", SwingConstants.CENTER);
	private JTextField tfPORT = new JTextField();
	private JLabel lbID = new JLabel("ID", SwingConstants.CENTER);
	private JTextField tfID = new JTextField();
	private JLabel lbPassword = new JLabel("PW", SwingConstants.CENTER);
	private JTextField tfPassword = new JTextField();
	private JCheckBox cbSaveInfo = new JCheckBox("정보유지", false);
	private JButton btSignIn = new JButton("회원가입");
	private JButton btConnect = new JButton("로그인");

	public NorthPanel() {
		this.setLayout(new GridLayout(1, 12));

		this.add(lbServerInfo);
		this.add(lbIP);
		this.add(tfIP);
		this.add(lbPORT);
		this.add(tfPORT);
		this.add(lbID);
		this.add(tfID);
		this.add(lbPassword);
		this.add(tfPassword);
		this.add(cbSaveInfo);
		this.add(btSignIn);
		this.add(btConnect);

	}

	// 외부에서 접근을 위한 겟터 설정
	public JTextField getTfIP() {
		return tfIP;
	}

	public JTextField getTfPORT() {
		return tfPORT;
	}

	public JTextField getTfID() {
		return tfID;
	}

	public JCheckBox getCbSaveInfo() {
		return cbSaveInfo;
	}

	public JButton getBtConnect() {
		return btConnect;
	}

	public JTextField getTfPassword() {
		return tfPassword;
	}

	public JButton getBtSignIn() {
		return btSignIn;
	}
	
	
}
