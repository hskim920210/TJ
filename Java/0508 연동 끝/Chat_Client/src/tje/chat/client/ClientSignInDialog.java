package tje.chat.client;

import java.awt.*;

import javax.swing.*;



public class ClientSignInDialog extends JDialog {
	private JLabel ID = new JLabel("            ID               ");
	private JTextField tfSignID = new JTextField(20);
	private JButton btSignIDExist = new JButton("중복확인");
	private JLabel PW = new JLabel("          PW              ");
	private TextField tfSignPW = new TextField(20);
	private JLabel PWc = new JLabel("       PW 확인         ");
	private TextField tfSignPWc = new TextField(20);
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
	
	private Font f_30 = new Font("플레인", Font.PLAIN, 30);
	
	public ClientSignInDialog (JFrame frame, String title) {
		this.setModal(true);
		spaceNorth.add(new JLabel(""));
		// spaceSouth.add(resultSign);
		setLayout(new BorderLayout(4, 4));
		this.add(spaceNorth, BorderLayout.NORTH);
		resultSign.setFont(f_30);
		this.add(resultSign, BorderLayout.SOUTH);
		//new GridLayout(1, 3, 2, 2)
		
		IdDialPane.add(ID, BorderLayout.WEST);
		ID.setFont(f_30);
		tfSignID.setFont(f_30);
		IdDialPane.add(tfSignID, BorderLayout.CENTER);
		DialCenterPane.add(IdDialPane);
		
		PW.setFont(f_30);
		tfSignPW.setFont(f_30);
		PwDialPane.add(PW, BorderLayout.WEST);
		tfSignPW.setEchoChar('*');
		PwDialPane.add(tfSignPW, BorderLayout.CENTER);
		DialCenterPane.add(PwDialPane);
		
		PWc.setFont(f_30);
		tfSignPWc.setFont(f_30);
		PwcDialPane.add(PWc, BorderLayout.WEST);
		tfSignPWc.setEchoChar('*');
		PwcDialPane.add(tfSignPWc, BorderLayout.CENTER);
		DialCenterPane.add(PwcDialPane);
		
		btSignReset.setFont(f_30);
		btSignConfirm.setFont(f_30);
		BtDialPane.add(btSignReset);
		BtDialPane.add(btSignConfirm);
		DialCenterPane.add(BtDialPane);
		
		this.add(DialCenterPane, BorderLayout.CENTER);
		
		setSize(600, 600);
		
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


	public TextField getTfSignPW() {
		return tfSignPW;
	}


	public void setTfSignPW(TextField tfSignPW) {
		this.tfSignPW = tfSignPW;
	}


	public TextField getTfSignPWc() {
		return tfSignPWc;
	}


	public void setTfSignPWc(TextField tfSignPWc) {
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
