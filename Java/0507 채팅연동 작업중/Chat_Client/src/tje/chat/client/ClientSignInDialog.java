package tje.chat.client;

import java.awt.*;

import javax.swing.*;



public class ClientSignInDialog extends JDialog {
	private JLabel ID = new JLabel("            ID               ");
	private JTextField tfSignID = new JTextField(20);
	private JButton btSignIDExist = new JButton("중복확인");
	private JLabel PW = new JLabel("          PW              ");
	private JTextField tfSignPW = new JTextField(20);
	private JLabel PWc = new JLabel("     PW 재확인     ");
	private JTextField tfSignPWc = new JTextField(20);
	private JButton btSignReset = new JButton("초기화");
	private JButton btSignConfirm = new JButton("가입");
	
	private JPanel spaceNorth = new JPanel();
	private JPanel spaceSouth = new JPanel();
	private JLabel resultSign = new JLabel(" ");
	
	private JPanel DialCenterPane = new JPanel(new GridLayout(4, 1, 2, 2));
	
	private JPanel IdDialPane = new JPanel(new BorderLayout()); 
	private JPanel PwDialPane = new JPanel(new BorderLayout()); 
	private JPanel PwcDialPane = new JPanel(new BorderLayout()); 
	private JPanel BtDialPane = new JPanel(new GridLayout(1, 2, 5, 5)); 
	
	
	public ClientSignInDialog (JFrame frame, String title) {
		this.setModal(true);
		spaceNorth.add(new JLabel(" "));
		// spaceSouth.add(resultSign);
		setLayout(new BorderLayout(4, 4));
		this.add(spaceNorth, BorderLayout.NORTH);
		this.add(resultSign, BorderLayout.SOUTH);
		//new GridLayout(1, 3, 2, 2)
		
		IdDialPane.add(ID, BorderLayout.WEST);
		IdDialPane.add(tfSignID, BorderLayout.CENTER);
		DialCenterPane.add(IdDialPane);
		
		PwDialPane.add(PW, BorderLayout.WEST);
		PwDialPane.add(tfSignPW, BorderLayout.CENTER);
		DialCenterPane.add(PwDialPane);
		
		PwcDialPane.add(PWc, BorderLayout.WEST);
		PwcDialPane.add(tfSignPWc, BorderLayout.CENTER);
		DialCenterPane.add(PwcDialPane);
		
		BtDialPane.add(btSignReset);
		BtDialPane.add(btSignConfirm);
		DialCenterPane.add(BtDialPane);
		
		this.add(DialCenterPane, BorderLayout.CENTER);
		
		setSize(300, 300);
		
	}


	
	
	
	
	
	
	
	public JLabel getResultSign() {
		return resultSign;
	}

	public void setResultSign(JLabel resultSign) {
		this.resultSign = resultSign;
	}

	public JTextField getTfSignID() {
		return tfSignID;
	}


	public void setTfSignID(JTextField tfSignID) {
		this.tfSignID = tfSignID;
	}


	public JButton getBtSignIDExist() {
		return btSignIDExist;
	}


	public void setBtSignIDExist(JButton btSignIDExist) {
		this.btSignIDExist = btSignIDExist;
	}


	public JTextField getTfSignPW() {
		return tfSignPW;
	}


	public void setTfSignPW(JTextField tfSignPW) {
		this.tfSignPW = tfSignPW;
	}


	public JTextField getTfSignPWc() {
		return tfSignPWc;
	}


	public void setTfSignPWc(JTextField tfSignPWc) {
		this.tfSignPWc = tfSignPWc;
	}


	public JButton getBtSignReset() {
		return btSignReset;
	}


	public void setBtSignReset(JButton btSignReset) {
		this.btSignReset = btSignReset;
	}


	public JButton getBtSignConfirm() {
		return btSignConfirm;
	}


	public void setBtSignConfirm(JButton btSignConfirm) {
		this.btSignConfirm = btSignConfirm;
	}
	
	
	
	
}
