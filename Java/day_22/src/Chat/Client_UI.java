package Chat;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.Book;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Client_UI extends JFrame {
	
	private Container clientPane;
	
	private JTextField ipText;
	private JTextField portText;
	private JTextField nickText;
	private JCheckBox remember;
	private JButton conBtn;
	private String [] saved = new String[3];
	private JButton msgOut;
	private JTextArea cliListArea;
	private JTextArea notice;
	
	private int cliPort;
	private String cliIp;
	private String cliNick;
	private Socket socket;
	private InputStreamReader isr;
	
	private Client client;
	
	public Client_UI() {
		setTitle("Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		clientPane = getContentPane();
		clientPane.setLayout(new BorderLayout(15, 30));
		
		// 상단의 구성 (보더의 북쪽)
		JPanel upperPane = new JPanel(new GridLayout(1, 5, 2, 2));
		JLabel serverInfo = new JLabel("서버 정보");
		serverInfo.setFont(new Font("볼드체", Font.BOLD, 30));
		// IP 정보
		JPanel ipPane = new JPanel(new FlowLayout());
		JLabel ip = new JLabel("IP");
		ip.setFont(new Font("볼드체", Font.BOLD, 30));
		// saved 배열에 저장된 정보가 있을 때 자동으로 불러와주기.
		ipText = new JTextField("192.168.0.68", 20);
//		ipText = new JTextField(20);
		ipPane.add(ip);			ipPane.add(ipText);
		// PORT 정보
		JPanel portPane = new JPanel(new FlowLayout());
		JLabel port = new JLabel("PORT");
		port.setFont(new Font("볼드체", Font.BOLD, 30));
		portText = new JTextField("5050", 20);
		portPane.add(port);		portPane.add(portText);
		// 닉네임 정보
		JPanel nickPane = new JPanel(new FlowLayout());
		JLabel nickName = new JLabel("닉네임");
		nickName.setFont(new Font("볼드체", Font.BOLD, 30));
		nickText = new JTextField("aa", 20);
		nickPane.add(nickName);		nickPane.add(nickText);
		// 버튼과 정보 유지 정보
		JPanel btnPane = new JPanel(new FlowLayout());
		remember = new JCheckBox("정보 유지       ", false);
		RememberListen rememLi = new RememberListen();
		remember.addItemListener(rememLi);
		remember.setFont(new Font("볼드체", Font.BOLD, 30));
		conBtn = new JButton("연결");
		conBtn.setFont(new Font("볼드체", Font.BOLD, 30));
		ConnectListen connect = new ConnectListen();
		conBtn.addActionListener(connect);
		btnPane.add(remember);		btnPane.add(conBtn);		
		// 상단 팬에 추가
		upperPane.add(serverInfo);
		upperPane.add(ipPane);
		upperPane.add(portPane);
		upperPane.add(nickPane);
		upperPane.add(btnPane);
		
		// 하단의 구성 (보더의 센터)
		JPanel underPane = new JPanel(new GridLayout(1, 4, 15, 15));
		// 1번째 팬 (접속중인 클라이언트 목록)
		JPanel firstPane = new JPanel(new BorderLayout());
		JLabel listClient = new JLabel("접속중인 클라이언트 목록");
		listClient.setFont(new Font("볼드체", Font.BOLD, 30));
		cliListArea = new JTextArea();
//		ConList cl = new ConList(cliListArea);
		firstPane.add(listClient, BorderLayout.NORTH);
		firstPane.add(cliListArea, BorderLayout.CENTER);
		// 2번째 팬 (공지 메세지 출력)
		JPanel secondPane = new JPanel(new BorderLayout());
		JLabel noticeOut = new JLabel("공지메세지 출력");
		noticeOut.setFont(new Font("볼드체", Font.BOLD, 30));
		notice = new JTextArea();
		secondPane.add(noticeOut, BorderLayout.NORTH);
		secondPane.add(notice, BorderLayout.CENTER);
		// 3번째 팬 (현재 대화방)
		JPanel thirdPane = new JPanel(new BorderLayout());
		JLabel listChat = new JLabel("현재 대화중인 목록");
		listChat.setFont(new Font("볼드체", Font.BOLD, 30));
		JList chatList = new JList();
		thirdPane.add(listChat);
		thirdPane.add(chatList);
		// 4번째 팬 ( 채팅방 )
		JPanel fourthPane = new JPanel(new BorderLayout());
		JTextArea enteredChat = new JTextArea();
		JPanel outPane = new JPanel(new FlowLayout());
		JTextField msgText = new JTextField(20);
		msgOut = new JButton("전송");
//		ButtonListener send = new ButtonListener(msgText, enteredChat, nickText);
//		msgOut.addActionListener(send);
		msgOut.setFont(new Font("볼드체", Font.BOLD, 30));
		JButton fileOut = new JButton("파일 전송");
//		FileListener fileListen = new FileListener();
//		fileOut.addActionListener(fileListen);
		fileOut.setFont(new Font("볼드체", Font.BOLD, 30));
		outPane.add(msgText);
		outPane.add(msgOut);
		outPane.add(fileOut);
		fourthPane.add(enteredChat, BorderLayout.CENTER);
		fourthPane.add(outPane, BorderLayout.SOUTH);
		// 하단 팬에 1,2,3,4 번째 팬 추가
		underPane.add(firstPane);
		underPane.add(secondPane);
		underPane.add(thirdPane);
		underPane.add(fourthPane);
		
		// 클라이언트 팬에 만들어놓은 팬을 추가
		clientPane.add(upperPane, BorderLayout.NORTH);
		clientPane.add(underPane, BorderLayout.CENTER);
		
		setSize(1950, 1300);
		setVisible(true);
	}
	
///////////////////////////////////////////////////////////////////////////////////////	
	
	// 정보유지 버튼을 눌렀을때 이벤트 처리
	class RememberListen implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				// 체크되었을 때 정보를 저장
				// 1. IP 저장
				saved[0] = ipText.getText();
				// 2. PORT 저장
				saved[1] = portText.getText();
				// 3. 닉네임 저장
				saved[2] = nickText.getText();
				// 저장한 문자 정보를 파일에 출력
				String dirPath = "D:\\dev\\java_se\\Chatting";
				File dir = new File(dirPath);
				if ( !dir.exists() ) {
					dir.mkdirs();
				}
				File file = new File(dir, "savedInfo.txt");
				try {
					PrintWriter out = 
							new PrintWriter(
									new BufferedWriter(
											new FileWriter(file)), true);
					for(int i = 0 ; i < saved.length ; i++)
						out.printf("%s, ", saved[i]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if (e.getStateChange() == ItemEvent.DESELECTED) {
				String dirPath = "D:\\dev\\java_se\\Chatting";
				File dir = new File(dirPath);
				if ( !dir.exists() ) {
					dir.mkdirs();
				}
				File file = new File(dir, "savedInfo.txt");
				file.delete();
			}
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
	
	// 연결 버튼을 눌렀을 때 이벤트 처리
	class ConnectListen implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("연결")) {
				b.setText("종료");
				// 클라이언트 객체를 생성하여 스트림까지 생성
				cliIp = ipText.getText();
				cliPort = Integer.parseInt(portText.getText());
				cliNick = nickText.getText();
				new Client(cliIp, cliPort, cliNick).start();
				
				// 공지 메세지를 가져오기
//				try {
//					notice.append(client.br.readLine() + "\n");
//				} catch (IOException e1) {
//					e1.printStackTrace();
//					}
				}
			else {
				b.setText("연결");
			}
		}
	}
	
	// 연결 버튼을 눌렀을 때 클라이언트 객체 처리
	class Client extends Thread {
		private String cliIp, cliNick;
		private int cliPort;
		private BufferedReader br;
		private PrintWriter pw;
		
		Client(String cliIp, int cliPort, String cliNick) {
			this.cliIp = cliIp;
			this.cliPort = cliPort;
			this.cliNick = cliNick;
		}

		public void exit() {
			try {
				br.close();
				pw.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public void run() {
			while(true) {
			try {
				socket = new Socket(cliIp, cliPort);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

				try {
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					notice.append(br.readLine()+"\n");
				} catch (IOException e) {
					notice.append("서버에서 연결을 해제했습니다");
					break;
				}
			}
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		new Client_UI();
	}
}
