package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;

public class NorthPanel extends JPanel {
	private JLabel lbServerInfo = new JLabel("서버 정보", SwingConstants.CENTER);
	private JLabel lbIP = new JLabel("IP", SwingConstants.CENTER);
	private JTextField tfIP = new JTextField();
	private JLabel lbPORT = new JLabel("PORT", SwingConstants.CENTER);
	private JTextField tfPORT = new JTextField();
	private JLabel lbId = new JLabel("ID", SwingConstants.CENTER);
	private JTextField tfId = new JTextField();
	private JLabel lbPW = new JLabel("PASSWORD", SwingConstants.CENTER);
	private JPasswordField tfPw = new JPasswordField();
	private JCheckBox cbSaveInfo = new JCheckBox("정보유지", false);
	private JButton btnConnect = new JButton("연결");
	private JButton btnRegist = new JButton("회원가입");
	
	public NorthPanel() {
		this.setLayout(new GridLayout(1, 12));
		
		this.add(lbServerInfo);
		this.add(lbIP);
		this.add(tfIP);
		this.add(lbPORT);
		this.add(tfPORT);
		this.add(lbId);
		this.add(tfId);
		this.add(lbPW);
		this.add(tfPw);
		this.add(cbSaveInfo);
		this.add(btnConnect);
		this.add(btnRegist);
	}

	public JTextField getTfIP() {
		return tfIP;
	}

	public JTextField getTfPORT() {
		return tfPORT;
	}

	public JTextField getTfId() {
		return tfId;
	}
	
	public JTextField getTfPw() {
		return tfPw;
	}

	public JCheckBox getCbSaveInfo() {
		return cbSaveInfo;
	}

	public JButton getBtnConnect() {
		return btnConnect;
	}
	
	public JButton getBtnRegist() {
		return btnRegist;
	}

}
