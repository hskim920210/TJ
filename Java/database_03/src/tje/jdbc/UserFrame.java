package tje.jdbc;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import tje.jdbc.dao.*;
import tje.jdbc.model.*;
import tje.jdbc.util.*;

public class UserFrame extends JFrame {
	
	private UserDAO dao = UserDAO.getInstance();
	
	private String [] labelTexts = {"ID", "PW", "Name", "Alias", "Tel"};
	private JLabel [] labels = new JLabel[labelTexts.length];
	private JTextField [] textFields = new JTextField[labelTexts.length];
	private JButton btnInsert = new JButton("가입");
	private JButton btnUpdate = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private JButton btnReset = new JButton("초기화");
	
	public UserFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("회원관리");
		
		JPanel centerPanel = new JPanel(new GridLayout(5, 2, 2, 2));
		for(int i = 0 ; i < labelTexts.length ; i++) {
			labels[i] = new JLabel(labelTexts[i]);
			textFields[i] = new JTextField();
			centerPanel.add(labels[i]);
			centerPanel.add(textFields[i]);
		}
		
		JPanel southPanel = new JPanel(new GridLayout(1, 4, 1, 1));
		southPanel.add(btnInsert);
		southPanel.add(btnUpdate);
		southPanel.add(btnDelete);
		southPanel.add(btnReset);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
		
		setEvents();
		
		this.setSize(330, 200);
		this.setVisible(true);
	}
	
	private void resetTextFields() {
		for(int i = 0 ; i < textFields.length ; i++) {
			textFields[i].setText("");
		}
	}
	
	private void setEvents() {
		//
		this.btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTextFields();
			}
		});
		
		
		
		
		
		//
		this.btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFields[0].getText().trim(); 
				String pw = textFields[1].getText().trim(); 
				String name = textFields[2].getText().trim(); 
				String alias = textFields[3].getText().trim(); 
				String tel = textFields[4].getText().trim(); 
				
				boolean checkEmpty;
				checkEmpty = id.length() == 0;
				checkEmpty = checkEmpty || pw.length() == 0;
				checkEmpty = checkEmpty || name.length() == 0;
				checkEmpty = checkEmpty || alias.length() == 0;
				if(checkEmpty) {
					JOptionPane.showMessageDialog(null, "필수 입력사항이 누락되었습니다.");
					return;
				}
				
				User user = new User(id, pw, name, alias, tel);
				
				Connection conn = JDBCConnection.getConnection();
				int result = dao.insert(conn, user);
				
				if(result == 1)
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				else
					JOptionPane.showMessageDialog(null, "회원가입이 실패하였습니다.");
				
				resetTextFields();
				JDBCObjectManager.close(conn);
			}
		});
		
		
		
		
		
		//
		this.btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFields[0].getText().trim(); 
				String pw = textFields[1].getText().trim(); 
				String name = textFields[2].getText().trim(); 
				String alias = textFields[3].getText().trim(); 
				String tel = textFields[4].getText().trim(); 
				
				boolean checkEmpty;
				checkEmpty = id.length() == 0;
				
				if(checkEmpty) {
					JOptionPane.showMessageDialog(null, "필수 입력사항이 누락되었습니다.");
					return;
				}
				
				User user = new User(id, pw, name, alias, tel);
				
				Connection conn = JDBCConnection.getConnection();
				JDBCObjectManager.setAutoCommit(conn, false);
				int result = 0;
				boolean flag = true;
				// 하나씩 확인
				if(pw.length() > 0) {
					result = dao.updatePassword(conn, user);
					if(result == 0) {
						flag = false;
					}
				}
				
				if(name.length() > 0) {
					result = dao.updateName(conn, user);
					if(result == 0) {
						flag = false;
					}
				}
				
				if(alias.length() > 0) {
					result = dao.updateAlias(conn, user);
					if(result == 0) {
						flag = false;
					}
				}
				
				if(tel.length() > 0) {
					result = dao.updateTel(conn, user);
					if(result == 0) {
						flag = false;
					}
				}
				
				if(flag) {
					JDBCObjectManager.commit(conn);
					JDBCObjectManager.close(conn);
					JOptionPane.showMessageDialog(null, "회원 정보 수정이 완료되었습니다.");
					resetTextFields();
				} else {
					JDBCObjectManager.rollback(conn);
					JOptionPane.showMessageDialog(null, "회원 정보 수정이 실패하였습니다.");
				}
				JDBCObjectManager.close(conn);
			}
		});
		
		
		
		
		
		//
		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFields[0].getText().trim(); 
				
				
				boolean checkEmpty;
				checkEmpty = id.length() == 0;
				if(checkEmpty) {
					JOptionPane.showMessageDialog(null, "필수 입력사항이 누락되었습니다.");
					return;
				}
				
				User user = new User(id);
				
				Connection conn = JDBCConnection.getConnection();
				int result = dao.delete(conn, user);
				
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "회원 삭제가 완료되었습니다.");
					resetTextFields();
				}
				else {
					JOptionPane.showMessageDialog(null, "존재하지 않는 회원 정보 입니다.");
				}
				
				JDBCObjectManager.close(conn);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new UserFrame();
	}

}
