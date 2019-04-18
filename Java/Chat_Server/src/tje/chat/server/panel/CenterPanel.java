package tje.chat.server.panel;

import java.awt.*;
import javax.swing.*;

public class CenterPanel extends JPanel {

	private JTextArea taLog = new JTextArea();
	// 체크가 된 상태의 체크박스 생성
	private JCheckBox cbLog = new JCheckBox("로그메세지 출력", true);

	public CenterPanel() {
		this.setLayout(new BorderLayout());

		this.add(taLog, BorderLayout.CENTER);
		this.add(cbLog, BorderLayout.SOUTH);

	}

	// 외부에서 접근하기 위한 겟터를 생성
	public JTextArea getTaLog() {
		return taLog;
	}

	public JCheckBox getCbLog() {
		return cbLog;
	}
}
