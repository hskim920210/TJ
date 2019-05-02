package tje.jdbc;

import java.awt.*;

import javax.swing.*;

public class UI_CenterPane extends JPanel {
	private JLabel idArea = new JLabel("ID *", SwingConstants.CENTER);
	private JLabel pwArea = new JLabel("PW *", SwingConstants.CENTER);
	private JLabel nameArea = new JLabel("NAME *", SwingConstants.CENTER);
	private JLabel ageArea = new JLabel("AGE", SwingConstants.CENTER);
	private JLabel telArea = new JLabel("TEL", SwingConstants.CENTER);
	private JTextField idField = new JTextField(20);
	private JTextField pwField = new JTextField(20);
	private JTextField nameField = new JTextField(20);
	private JTextField ageField = new JTextField(20);
	private JTextField telField = new JTextField(20);
	private Font f = new Font("∞ÌµÒ√º", Font.ITALIC, 30);
	private Font f1 = new Font("∞ÌµÒ√º", Font.ITALIC, 25);
	
	public JTextField getIdField() {
		return idField;
	}
	public void setIdField(JTextField idField) {
		this.idField = idField;
	}
	public JTextField getPwField() {
		return pwField;
	}
	public void setPwField(JTextField pwField) {
		this.pwField = pwField;
	}
	public JTextField getNameField() {
		return nameField;
	}
	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}
	public JTextField getAgeField() {
		return ageField;
	}
	public void setAgeField(JTextField ageField) {
		this.ageField = ageField;
	}
	public JTextField getTelField() {
		return telField;
	}
	public void setTelField(JTextField telField) {
		this.telField = telField;
	}


	public UI_CenterPane() {
		idArea.setFont(f);
		pwArea.setFont(f);
		nameArea.setFont(f);
		ageArea.setFont(f);
		telArea.setFont(f);
		
		idField.setFont(f1);
		pwField.setFont(f1);
		nameField.setFont(f1);
		ageField.setFont(f1);
		telField.setFont(f1);
		
		this.setLayout(new GridLayout(5, 2, 9, 9));
		this.add(idArea);
		this.add(idField);
		this.add(pwArea);
		this.add(pwField);
		this.add(nameArea);
		this.add(nameField);
		this.add(ageArea);
		this.add(ageField);
		this.add(telArea);
		this.add(telField);
		
	}
}
