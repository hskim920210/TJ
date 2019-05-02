package tje.jdbc.frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.sql.*;

public class UserRegistFrame extends JFrame {
	
	private String [] labelText = {"ID(*)","PW(*)","NAME(*)","AGE","TEL"};
	private JLabel [] labels = new JLabel[labelText.length];
	private JTextField [] fields = new JTextField[labelText.length];
	private JButton btnRegist = new JButton("가입");
	private JButton btnReset = new JButton("초기화");
	
	public UserRegistFrame(String title) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle(title);
		this.setLayout(new GridLayout(6, 2, 3, 3));
		
		for( int i = 0 ; i < labelText.length ; i++ ) {
			labels[i] = new JLabel(labelText[i]);
			fields[i] = new JTextField();		
			
			this.add(labels[i]);
			this.add(fields[i]);
		}
		
		this.add(btnRegist);
		this.add(btnReset);
		
		setEvents();
		
		this.setSize(200, 300);
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
		
		this.btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componentsReset();
			}
		});
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
				
		// 1. JDBC 드라이버 클래스 로딩
		String strDriverClassName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(strDriverClassName);
			System.out.println("드라이버 클래스 로딩 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 로딩 실패");
			e.printStackTrace();
			return false;
		}
		
		// 2. DBMS 연결
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/hr?serverTimezone=UTC";
		String user = "root";
		String password = "SystemManager304";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DBMS 연결 성공");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패");
			e.printStackTrace();			
			return false;
		}
		
		// ID 정보를 사용하여 Select 쿼리를 수행할 객체
		PreparedStatement selectPstmt = null;
		// 수정할 정보를 입력받아 Insert 쿼리를 수행할 객체
		PreparedStatement insertPstmt = null;

		String select_sql = "select * from users where user_id = ?";		
		String insert_sql = "insert into users values (0, ?,?,?,?,?)"; 

		ResultSet rs = null;
		int recordCount = 0;
		
		try {
			selectPstmt = conn.prepareStatement(select_sql);		
			insertPstmt = conn.prepareStatement(insert_sql);
			
			String user_id = this.fields[0].getText().trim();
			selectPstmt.setString(1, user_id);
			
			rs = selectPstmt.executeQuery();
			
			if( rs.next() )
				return false;
			
			insertPstmt.setString(1, this.fields[0].getText().trim());
			insertPstmt.setString(2, this.fields[1].getText().trim());
			insertPstmt.setString(3, this.fields[2].getText().trim());
			
			if( fields[3].getText().trim().length() > 0 ) {
				int age = 0;
				try {
					age = Integer.parseInt(this.fields[3].getText().trim());
					insertPstmt.setInt(4, age);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "AGE 필드에는 숫자만 입력할 수 있습니다.");
					return false;
				}
			} else
				insertPstmt.setNull(4, java.sql.Types.NULL);
			
			if( fields[4].getText().trim().length() > 0 )
				insertPstmt.setString(5, this.fields[4].getText().trim());
			else
				insertPstmt.setNull(5, java.sql.Types.NULL);
			
			recordCount = insertPstmt.executeUpdate();
			
			if( recordCount == 1 )
				result = true;
			else 
				result = false;			
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		
		try {			
			if( rs != null )
				rs.close();
			
			if( selectPstmt != null )
				selectPstmt.close();
			
			if( insertPstmt != null )
				insertPstmt.close();
			
			if( conn != null )
				conn.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
				
		return result;
	}
	
	private void componentsReset() {
		for( int i = 0 ; i < fields.length ; i++ )			
			fields[i].setText("");		
	}

	public static void main(String[] args) {
		new UserRegistFrame("회원가입");
	}

}