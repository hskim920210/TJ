package tje.chat.server.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NorthPanel extends JPanel {
	private JLabel lbMsg = new JLabel("포트번호");
	private JTextField tfPortNumber = new JTextField();
	private JButton btnStartAndStop = new JButton("시작");
	
	public NorthPanel() {
		this.setLayout(new BorderLayout());
		
		this.add(lbMsg, BorderLayout.WEST);
		
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.add(tfPortNumber, 0);
		panel.add(btnStartAndStop, 1);
		
		this.add(panel, BorderLayout.CENTER);
	}

	public JTextField getTfPortNumber() {
		return tfPortNumber;
	}

	public JButton getBtnStartAndStop() {
		return btnStartAndStop;
	}
	
}
















