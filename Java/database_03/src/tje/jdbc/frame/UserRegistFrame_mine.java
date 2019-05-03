package tje.jdbc.frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import tje.jdbc.dao.UserDAO;
import tje.jdbc.model.User;
import tje.jdbc.util.JDBCConnection;
import tje.jdbc.util.JDBCObjectManager;

import java.sql.*;

public class UserRegistFrame_mine extends JFrame {
	
	private String [] labelText = {"ID(*)","PW(*)","NAME(*)","ALIAS","TEL"};
	private JLabel [] labels = new JLabel[labelText.length];
	private JTextField [] fields = new JTextField[labelText.length];
	private JButton btnRegist = new JButton("가입");
	private JButton btnEdit = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private JButton btnReset = new JButton("초기화");
	private Font f = new Font("고딕체", Font.ITALIC, 30);
	private Font f1 = new Font("고딕체", Font.ITALIC, 20);
	private Font f2 = new Font("고딕체", Font.BOLD, 30);
	private Connection conn = null;
	
	public UserRegistFrame_mine(String title) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle(title);
		this.setLayout(new GridLayout(6, 2, 3, 3));
		
		for( int i = 0 ; i < labelText.length ; i++ ) {
			labels[i] = new JLabel(labelText[i], SwingConstants.CENTER);
			labels[i].setFont(f);
			fields[i] = new JTextField(20);
			fields[i].setFont(f1);
			
			this.add(labels[i]);
			this.add(fields[i]);
		}
		JPanel lBtnPane = new JPanel(new GridLayout(1, 2, 3, 3));
		btnRegist.setFont(f2);
		btnEdit.setFont(f2);
		lBtnPane.add(btnRegist);
		lBtnPane.add(btnEdit);
		JPanel rBtnPane = new JPanel(new GridLayout(1, 2, 3, 3));
		btnDelete.setFont(f2);
		btnReset.setFont(f2);
		rBtnPane.add(btnDelete);
		rBtnPane.add(btnReset);
		
		this.add(lBtnPane);
		this.add(rBtnPane);
		setEvents();
		this.conn = JDBCConnection.getConnection();
		
		this.setSize(600, 900);
		this.setVisible(true);		
	}
	
	private void setEvents() {
		this.btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( userRegist() ) {
					JOptionPane.showMessageDialog(null, "회원가입 성공!");
					componentsReset();
				} else
					JOptionPane.showMessageDialog(null, "회원가입 실패!");
					
			}
		});
		
		this.btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoEdit(fields[0].getText().trim());
			}
		});
		
		this.btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 필수 입력사항 체크
				for( int i = 0 ; i < 3 ; i++ ) {
					if( fields[i].getText().trim().length() == 0 ) {
						JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length() - 3) + "은 필수 입력사항 입니다.");
					}
				}
				infoDelete(fields[0].getText().trim());
			}
		});
		
		this.btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componentsReset();
			}
		});
	}
	
	private void infoDelete(String id) {
		// 필수 입력사항 체크
		for( int i = 0 ; i < 3 ; i++ ) {
			if( fields[i].getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length() - 3) + "은 필수 입력사항 입니다.");
			}
		}
		
		UserDAO dao = UserDAO.getInstance();
		User user5 = new User(id);

		dao.delete(conn, user5);
		JOptionPane.showMessageDialog(null, "회원 정보가 삭제되었습니다.");
		JDBCObjectManager.close(conn);
		
	}
	
	private void infoEdit(String id) {
		// 필수 입력사항 체크
		for( int i = 0 ; i < 3 ; i++ ) {
			if( fields[i].getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length() - 3) + "은 필수 입력사항 입니다.");
			}
		}
		
		UserDAO dao = UserDAO.getInstance();
		User user4 = dao.select(conn, new User(id));
		if( user4 != null ) {
			JDBCObjectManager.setAutoCommit(conn, false);
			
			int recordCount = 0;
			recordCount += dao.updatePassword(conn, user4);
			recordCount += dao.updateName(conn, user4);
			recordCount += dao.updateAlias(conn, user4);
			recordCount += dao.updateTel(conn, user4);
			
			if( recordCount == 4 )
				// 모든 업데이트 쿼리가 정상적으로 실행된 경우
				// commit 메소드를 호출하여 DB에 저장
				JDBCObjectManager.commit(conn);
			else
				// 모든 업데이트 쿼리 중 하나라도 문제가 발생하는 경우
				// rollback 메소드를 호출하여 현재까지의 모든 작업을 취소함
				JDBCObjectManager.rollback(conn);
			JOptionPane.showMessageDialog(null, "회원 정보가 수정되었습니다.");
			JDBCObjectManager.close(conn);
		} else {
			JOptionPane.showMessageDialog(null, "회원 정보가 없습니다.");
			return;
		}
		JDBCObjectManager.close(conn);
	}
	
	private boolean userRegist() {
		// 필수 입력사항 체크
		for( int i = 0 ; i < 3 ; i++ ) {
			if( fields[i].getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length() - 3) + "은 필수 입력사항 입니다.");
				return false;
			}
		}
				
		boolean result = false;
				
		
		// chat 데이터베이스의 User 테이블에 대한
		// JDBC 작업을 제공하는 DAO 클래스
		UserDAO dao = UserDAO.getInstance();
		
		// 1. 입력 ( 모델 객체 활용 )
		User user1 = new User(fields[0].getText().trim(),
							fields[1].getText().trim(), 
							fields[2].getText().trim(), 
							fields[3].getText().trim(), 
							fields[4].getText().trim());
		dao.insert(conn, user1);
		if( dao.insert(conn, user1) != 0 ) {
			result = true;
		}
		JDBCObjectManager.close(conn);
		return result;
	}
	
	private void componentsReset() {
		for( int i = 0 ; i < fields.length ; i++ )			
			fields[i].setText("");		
	}

	public static void main(String[] args) {
		new UserRegistFrame_mine("회원관리");
		
	}

}