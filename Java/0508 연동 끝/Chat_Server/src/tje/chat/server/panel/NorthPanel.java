package tje.chat.server.panel;

import java.awt.*;
import javax.swing.*;

// 상단에 배치할 패널을 생성.
public class NorthPanel extends JPanel {
	private JLabel lbMsg = new JLabel("포트번호");
	private JTextField tfPortNumber = new JTextField();
	private JButton btnStartAndStop = new JButton("시작");

	private JCheckBox cbSavePortNum = new JCheckBox("포트번호 저장");

	private Font f_30 = new Font("플레인", Font.PLAIN, 30);
	
	public NorthPanel() {
		this.setLayout(new BorderLayout());
		
		this.lbMsg.setFont(f_30);
		this.btnStartAndStop.setFont(f_30);
		this.tfPortNumber.setFont(f_30);
		this.cbSavePortNum.setFont(f_30);
		
		this.add(lbMsg, BorderLayout.WEST);

		JPanel panel = new JPanel(new GridLayout(1, 3));
		panel.add(tfPortNumber, 0);
		panel.add(btnStartAndStop, 1);
		panel.add(cbSavePortNum, 2);

		this.add(panel, BorderLayout.CENTER);
	}

	// 이 클래스의 필드멤버에 접근하기 위한 겟터를 만듬.
	public JTextField getTfPortNumber() {
		return tfPortNumber;
	}

	public JButton getBtnStartAndStop() {
		return btnStartAndStop;
	}

	public JCheckBox getCbSavePortNum() {
		return cbSavePortNum;
	}

	public void setCbSavePortNum(JCheckBox cbSavePortNum) {
		this.cbSavePortNum = cbSavePortNum;
	}
}
