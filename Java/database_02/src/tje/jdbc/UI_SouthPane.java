package tje.jdbc;

import java.awt.*;

import javax.swing.*;

public class UI_SouthPane extends JPanel {
	private JButton compBtn = new JButton("가입");
	private JButton resetBtn = new JButton("초기화");
	private Dimension d = new Dimension(20,50);
	
	public JButton getCompBtn() {
		return compBtn;
	}
	public void setCompBtn(JButton compBtn) {
		this.compBtn = compBtn;
	}
	public JButton getResetBtn() {
		return resetBtn;
	}
	public void setResetBtn(JButton resetBtn) {
		this.resetBtn = resetBtn;
	}

	public UI_SouthPane() {
		compBtn.setPreferredSize(d);
		resetBtn.setPreferredSize(d);
		
		compBtn.setFont(new Font("고딕체", Font.BOLD, 20));
		resetBtn.setFont(new Font("고딕체", Font.BOLD, 20));
		
		this.setLayout(new GridLayout(1, 2));
		this.add(compBtn);
		this.add(resetBtn);
	}
}
