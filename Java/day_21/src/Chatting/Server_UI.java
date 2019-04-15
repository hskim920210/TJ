package Chatting;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Server_UI extends JFrame {
	public int port;
	
	Container contentPane;
	JTextField portText;
	JButton startEnd;
	JTextArea noticeArea;
	JCheckBox logWrite;
	JButton noticeBtn;
	JButton fileBtn;
	JTextField noticeText;
	ServerSocket ss;
	Socket client;
	ArrayList<String> selectedFile = new ArrayList<String>();
	
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분에 기록된 내용");
	Date now = cal.getTime();
	
	public Server_UI() {
		setTitle("Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(10, 50));
		
		// 상단의 구성
		JPanel upperPane = new JPanel(new FlowLayout());
		// 상단에 라벨과 텍스트필드, 버튼 배치
		JLabel portNum = new JLabel("포트 번호");
		portNum.setFont(new Font("볼드체", Font.BOLD, 30));
		portText = new JTextField(30);
		// 수정 필요함
		Server_Run_Clients sr = new Server_Run_Clients("ip주소", Integer.parseInt(portText.getText()));
		startEnd = new JButton("시작");
		startEnd.setFont(new Font("볼드체", Font.BOLD, 30));
		ChangeListen change = new ChangeListen();
		startEnd.addActionListener(change);
		upperPane.add(portNum);
		upperPane.add(portText);
		upperPane.add(startEnd);
		
		// 중단의 구성
		JPanel midPane = new JPanel(new BorderLayout());
		noticeArea = new JTextArea();
		midPane.add(noticeArea);
		
		// 하단의 구성
		JPanel underPane = new JPanel(new GridLayout(2, 1, 1, 1));
		// 체크박스와 메세지 출력 패널 생성
		JPanel checkPane = new JPanel(new FlowLayout());
		logWrite = new JCheckBox("로그 메세지 출력");
		logWrite.setFont(new Font("볼드체", Font.BOLD, 30));
		CheckListen logListen = new CheckListen();
		logWrite.addItemListener(logListen);
		checkPane.add(logWrite);
		// 공지 메세지 전송
		JPanel noticePane = new JPanel(new BorderLayout());
		JLabel noticeLabel = new JLabel("공지메세지");
		noticeLabel.setFont(new Font("볼드체", Font.BOLD, 30));
		noticeText = new JTextField();
		JPanel btnPane = new JPanel(new FlowLayout());
		noticeBtn = new JButton("전송");
		noticeBtn.setFont(new Font("볼드체", Font.BOLD, 30));
		ButtonListener send = new ButtonListener(noticeText, noticeArea, "서버");
		noticeBtn.addActionListener(send);
		fileBtn = new JButton("파일 전송");
		FileListener fileListen = new FileListener();
		fileBtn.addActionListener(fileListen);
		fileBtn.setFont(new Font("볼드체", Font.BOLD, 30));
		btnPane.add(noticeBtn);
		btnPane.add(fileBtn);
		noticePane.add(noticeLabel, BorderLayout.WEST);
		noticePane.add(noticeText);
		noticePane.add(btnPane, BorderLayout.EAST);
		underPane.add(checkPane);
		underPane.add(noticePane);
		
		// 컨테이너에 상단 중단 하단 팬을 삽입
		contentPane.add(upperPane, BorderLayout.NORTH);
		contentPane.add(midPane, BorderLayout.CENTER);
		contentPane.add(underPane, BorderLayout.SOUTH);
		
		setSize(1300, 800);
		setVisible(true);
	}
	
	
	class CheckListen implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int sel = -1;
			if(e.getStateChange() == ItemEvent.SELECTED) {
				sel = 1;
				// 로그 메세지 출력이 체크되었을 때 파일 경로를 만들고 txt를 만든다.
				String dirPath = "D:\\dev\\java_se\\Chatting";
				File dir = new File(dirPath);
				if ( !dir.exists() ) {
					dir.mkdirs();
				}
				File file = new File(dir, "log.txt");
				// 출력을 위한 out스트림
				try {
					PrintWriter out = 
							new PrintWriter(
									new BufferedWriter(
											new FileWriter(file, true)), true);
					out.println("------------시작----------------");
					out.println(noticeArea.getText());
					out.println(sdf.format(now));
					out.println("------------종료----------------");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else 
				sel = -1;
			}
		}
	
		
	
	class ChangeListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
//			noticeArea.setText(null);
			if(b.getText().equals("시작")) {
				b.setText("종료");
				// 시작 버튼을 눌렀을 때 서버소켓이 생성
				port = Integer.parseInt(portText.getText());
				try {
					ss = new ServerSocket(port);
					// 에러가 생김.. client = ss.accept();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else {
				b.setText("시작");
				noticeArea.setText("서버를 종료했습니다.");
				try {
					ss.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Server_UI();
	}
}
