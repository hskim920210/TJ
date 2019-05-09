package tje.chat.client.dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistDialog extends JDialog {
	private JLabel lbId = new JLabel("ID", SwingConstants.CENTER);
	private JTextField tfId = new JTextField();
	private JLabel lbPW = new JLabel("PASSWORD", SwingConstants.CENTER);
	private JPasswordField tfPw = new JPasswordField();
	
	private JLabel lbName = new JLabel("NAME", SwingConstants.CENTER);
	private JTextField tfName = new JTextField();
	private JLabel lbNick = new JLabel("Nick", SwingConstants.CENTER);
	private JTextField tfNick = new JTextField();
	
	private JButton btnRegist = new JButton("가입");
	private JButton btnCancle = new JButton("취소");
	
	private int state = 0;
	
	public RegistDialog() {
		this.setModal(true);
		
		this.setTitle("회원가입");
		this.setLayout(new GridLayout(5, 2, 2, 2));
		
		this.add(lbId);
		this.add(tfId);
		this.add(lbPW);
		this.add(tfPw);
		this.add(lbName);
		this.add(tfName);
		this.add(lbNick);
		this.add(tfNick);
		this.add(btnRegist);
		this.add(btnCancle);
		
		this.setSize(100, 150);
		
		btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = 1;
				setVisible(false);
			}
		});
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = 0;
				setVisible(false);
			}
		});
	}
	
	public int getState() {
		// 사용자가 가입 버튼을 클릭한 경우 1을 반환
		// 사용자가 취소 버튼을 클릭한 경우 0을 반환
		return this.state;
	}
	
	public String getId() {
		return this.tfId.getText().trim();
	}
	
	public String getPw() {
		return this.tfPw.getText().trim();
	}
	
	public String getName() {
		return this.tfName.getText().trim();
	}
	
	public String getNick() {
		return this.tfNick.getText().trim();
	}
	
}











