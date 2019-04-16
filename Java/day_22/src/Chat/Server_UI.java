package Chat;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

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
	BufferedReader br;
	PrintWriter pw;
	ArrayList<String> selectedFile = new ArrayList<String>();
	ArrayList<ClientSocketStr> ClientSockets = new ArrayList<ClientSocketStr>();
//	StartNotice sn;
	
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
		portText = new JTextField("5050", 30);
		// 수정 필요함
		//Server_Run_Clients sr = new Server_Run_Clients("ip주소", Integer.parseInt(portText.getText()));
		startEnd = new JButton("시작");
		startEnd.setFont(new Font("볼드체", Font.BOLD, 30));
		StartListen change = new StartListen();
		startEnd.addActionListener(change);
		upperPane.add(portNum);
		upperPane.add(portText);
		upperPane.add(startEnd);
		
		// 중단의 구성
		JPanel midPane = new JPanel(new BorderLayout());
		noticeArea = new JTextArea();
		noticeArea.setEditable(false);
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
//		FileListener fileListen = new FileListener();
//		fileBtn.addActionListener(fileListen);
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
	
//////////////////////////////////////////////////////////////////////////////////////////
	
	// 시작을 누르면 입력한 포트번호를 통해 서버소켓을 생성하고 접속한 클라이언트들을 어레이리스트로 저장한다.
	class StartListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("시작")) {
				b.setText("종료");
				port = Integer.parseInt(portText.getText());
				// 접속한 클라이언트들의 소켓을 어레이리스트에 저장하는 객체 생성
				new RunServer(port).start();
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
	
	// 포트를 매개변수로 받아와 스레드로 클라이언트 객체들을 생성한다.
	class RunServer extends Thread {
		private int port;
		
		RunServer(int port) {
			this.port = port;
		}
		
		public void run() {
			try {
				ss = new ServerSocket(this.port);
				client = ss.accept();
				noticeArea.append("사용자가 접속함\n");
				// 클라이언트 소켓이 생성될때마다 객체를 만들어서 어레이리스트에 저장
				ClientSockets.add(new ClientSocketStr(client));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ClientSocketStr {
		private Socket socket;
		private PrintWriter pw;
		ClientSocketStr(Socket socket) {
			this.socket = socket;
			try {
				this.pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 전송 버튼을 눌렀을 때 이벤트 처리
	class ButtonListener implements ActionListener {
		
		private JTextField Field;
		private JTextArea Area;
		private String nick;

		ButtonListener(JTextField Field, JTextArea Area, JTextField nick) {
			this.Field = Field;
			this.Area = Area;
			this.nick = nick.getText();
		}
		
		ButtonListener(JTextField Field, JTextArea Area, String nick) {
			this.Field = Field;
			this.Area = Area;
			this.nick = nick;
		}
		
		public String toString() {
			return String.format("%s   :  %s\n", this.nick, Field.getText());
		}
		

		public void actionPerformed(ActionEvent e) {
			
			// 전송 버튼이 눌릴 때 마다 텍스트 에어리어에 적힌 글을 추가
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("전송")) {
				// 전송 버튼이 눌릴 때 마다 텍스트 에어리어에 적힌 글을 추가
				Area.append(toString());
				// 텍스트 필드에 적힌 글을 클라이언트들에게 전송
				SendToClients stc = new SendToClients(noticeText);
				stc.start();
				// 텍스트 필드를 초기화
				Field.setText("");
				}
			}
		}
	
	class SendToClients extends Thread {
		private JTextField Field;
		private PrintWriter pw;
		
		SendToClients(JTextField Field) {
			this.Field = Field;
		}
		
		public void run() {
			while(true) {

				for(int i = 0 ; i < ClientSockets.size() ; i++) {
					ClientSockets.get(i).pw.println(noticeText.getText());
					}
			}
			
		}
	}

	
		
	
	
/////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		new Server_UI();
	}
}
