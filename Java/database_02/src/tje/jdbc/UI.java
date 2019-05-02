package tje.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UI extends JFrame {

	private UI_NorthPane np = new UI_NorthPane();
	private UI_CenterPane cp = new UI_CenterPane();
	private UI_SouthPane sp = new UI_SouthPane();
	
	private static final String USER_INFO_DIR_PATH = "./user";
	private static final String USER_INFO_FILE_PATH = "user_info.dat";
	private static File USER_INFO_DIR;
	private static File USER_INFO_SAVE_FILE;
	// 제일 먼저 회원가입에 필요한 경로와 파일을 만들어놓는다.
	static {
		USER_INFO_DIR = new File(USER_INFO_DIR_PATH);
		if ( !USER_INFO_DIR.exists() )
			USER_INFO_DIR.mkdirs();
		
		USER_INFO_SAVE_FILE = new File(USER_INFO_DIR, USER_INFO_FILE_PATH);
	}
	
	
	
	public UI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("회원가입");
		this.add(cp, BorderLayout.CENTER);
		this.add(sp, BorderLayout.SOUTH);
		
		
		
		
		// 이벤트 처리
		// 1. 초기화버튼
		this.sp.getResetBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		// 2. 가입 버튼
		this.sp.getCompBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 필수 입력사항을 모두 입력했는지 체크
				boolean check = cp.getIdField().getText().isEmpty() ||
						cp.getPwField().getText().isEmpty() ||
						cp.getNameField().getText().isEmpty();
				
				if( check ) {
					JOptionPane.showMessageDialog(null, "필수 입력사항을 모두 입력해야합니다.");
				}
				else {
					
					SaveInfo si = 
							new SaveInfo(cp.getIdField().getText().trim(),
									cp.getPwField().getText().trim(),
									cp.getNameField().getText().trim(),
									cp.getTelField().getText().trim(),
									Integer.parseInt(cp.getAgeField().getText()));
					
					try (ObjectOutputStream out = 
							new ObjectOutputStream(
									new BufferedOutputStream(
											new FileOutputStream(USER_INFO_SAVE_FILE)));) {
						out.writeObject(si);
						out.flush();
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "정보 저장 과정에서 문제가 발생하였습니다.");
					}
				}
				
				
			}
		});
		
		
		setSize(500, 500);
		setVisible(true);
	}
	
	
	private void reset() {
		this.cp.getIdField().setText("");
		this.cp.getPwField().setText("");
		this.cp.getNameField().setText("");
		this.cp.getAgeField().setText("");
		this.cp.getTelField().setText("");
	}
	
	
	private class SaveInfo {
		private String idInfo, pwInfo, nameInfo, telInfo;
		private int ageInfo;
		
		
		public SaveInfo(String idInfo, String pwInfo, String nameInfo, String telInfo, int ageInfo) {
			super();
			this.idInfo = idInfo;
			this.pwInfo = pwInfo;
			this.nameInfo = nameInfo;
			this.telInfo = telInfo;
			this.ageInfo = ageInfo;
		}

	}
	
	public static void main(String[] args) {
		new UI();
	}
}
