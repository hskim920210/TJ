package tje.chat.client; // 209ㄴㅀㄴㅇㅀ, 291dsfseg 여기에 스크롤기능 추가(공지메세지 에어리어)

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.*;

import tje.chat.client.net.ClientBinarySocket;
import tje.chat.client.net.ClientSocket;
import tje.chat.client.net.UserSignThread;
import tje.chat.client.panel.*;
import tje.chat.common.ClientInfo;
import tje.chat.common.Packet;
import tje.chat.common.jdbc.UserDAO;
import tje.chat.common.jdbc.model.User;
import tje.chat.common.util.JDBCConnection;
import tje.chat.model.*;

public class ClientFrame extends JFrame {
	// 이너클래스에서 이 클래스의 멤버필드에 접근하기 위한 대책
	// 이너클래스에서는 이 클래스의 private 멤버에 접근이 가능하다.
	private ClientFrame frame = this;
	
	// 회원가입 다이얼로그
	private ClientSignInDialog SignDial = new ClientSignInDialog(this, "회원가입");
	
	UserDAO dao = UserDAO.getInstance();
	
	// 정보 저장을 위한 파일 경로 및 File 객체 생성
	// ./는 내 클래스가 가지고있는 경로 이후를 뜻함.
	private static final String CLIENT_DIR_PATH = "./client";
	private static final String SERVER_INFO_FILE_PATH = "server_info.dat";
	private static File CLIENT_DIR;
	private static File SERVER_INFO_SAVE_FILE;

	// 이 ClientFrame 객체가 생성될때 제일 우선적으로 실행되는 영역 지정.
	// 정보유지에 필요한 경로가 있는지 확인하고 없으면 생성하며 save.dat 파일 객체 생성
	static {
		CLIENT_DIR = new File(CLIENT_DIR_PATH);
		if (!CLIENT_DIR.exists())
			CLIENT_DIR.mkdirs();

		SERVER_INFO_SAVE_FILE = new File(CLIENT_DIR, SERVER_INFO_FILE_PATH);
	}
	
	// 클라이언트 소켓 클래스는 package tje.chat.client.net 내부의 클래스로
	// 자기 자신의 프레임(현재 실행되는 프레임)과 서버인포, 소켓과 객체 스트림을 변수로 갖는다
	// 서버 인포 클래스는 package tje.chat.model 내부의 클래스로 
	// ip와 포트번호, 별칭을 변수로 갖는 클래스이다. 
	// 서버 인포 클래스는 직렬화(Serializable)을 해야하는데, 그 이유는 
	// 모든 필드들을 네트워크로 전송할 수 있도록 바이트타입으로 변환하여 스트림을 이용할 수 있도록 하기 위함이다.
	private ClientSocket clientSocket;
	// 파일 전송을 위한 소켓 객체
	private ClientBinarySocket clientBinarySocket;
	
	// 선택된 사용자
	private String selectedChatIp;
	// ChatMessage 클래스는 tje.chat.model 패키지 내부의 클래스로
	// 별칭과 ip, 비교하고자 하는 별칭과 전송될 메세지를 history라는 이름의 어레이리스트를 필드로 가진 클래스이다.
	private HashMap<String, ChatMessage> chatMap = new HashMap<>();

	private NorthPanel np = new NorthPanel();
	private CenterPanel cp = new CenterPanel();

	public ClientFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Chat Client - Ver 0.1");

		// 화면 배치
		this.setLayout(new BorderLayout(0, 10));
		this.add(np, BorderLayout.NORTH);
		this.add(cp, BorderLayout.CENTER);

		// 저장된 정보를 확인한 후, 화면 컴포넌트의 값이나 상태를 변경
		// 파일이 존재하면 그파일에 저장해놓은 서버 정보를 텍스트필드에 로드한다.
		if (SERVER_INFO_SAVE_FILE.exists())
			loadServerInfo();

		// 메시지 Area 수정 금지
		cp.getTaChatMsg().setEditable(false);
		cp.getTaNoticeMsg().setCaretPosition(cp.getTaChatMsg().getDocument().getLength());
		// 공지메세지 Area 출력 금지
		cp.getTaNoticeMsg().setEditable(false);
		
		// 컴포넌트들의 이벤트 처리
		// 회원가입 1. 버튼 이벤트 처리 ( 다이얼로그 창을 띄운다 )
		this.np.getBtSignIn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignDial.setVisible(true);
			}
		});
		// 회원가입 2. 기입한 정보를 받아 id, pw을 초기화
		SignDial.getBtSignConfirm().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = SignDial.getTfSignID().getText().trim();
				String pw = SignDial.getTfSignPW().getText().trim();
				if( !SignDial.getTfSignPW().getText().equals(SignDial.getTfSignPWc().getText()) ) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					return;
				}
				User user = new User(id, pw);
				UserSignThread ust = new UserSignThread(user, np.getTfIP().getText(), frame);
				ust.start();
			}
		});
		// 회원가입 3. 초기화 버튼 이벤트처리
		SignDial.getBtSignReset().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignDial.getTfSignID().setText("");
				SignDial.getTfSignPW().setText("");
				SignDial.getTfSignPWc().setText("");
			}
		});
		
		// 엔터키를 치면 전송되도록 (액션리스너의 기본액션은 엔터키이다) ( 버튼처리와 똑같은코드로 )
		this.cp.getTfSendMsg().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		
		
		// 클라이언트 간의 채팅을 위한 메세지 전송 (버튼처리)
		this.cp.getBtSend().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		
		
		// 정보저장 체크박스의 이벤트 처리
		// 이너 클래스로 만들어서 처리한다.
		np.getCbSaveInfo().addActionListener(new SaveClientInfoHanddler());
		
		// 연결버튼의 이벤트처리
		// 클라이언트 간의 채팅을 시작하기 위한 더블클릭 이벤트처리
		this.cp.getTbAllClient().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				// 현재 선택된 행의 인덱스를 반환
				int row = cp.getTbAllClient().getSelectedRow();
				if(row == -1)
					return;
				
				// test용
//				String msg = String.format("%s - %s 선택", cp.getDtmAllClientModel().getValueAt(row, 0), cp.getDtmAllClientModel().getValueAt(row, 1));
//				JOptionPane.showMessageDialog(null, msg);
				
				// 해쉬맵에 클릭한 사용자를 입력
				String targetNickName = (String)cp.getDtmAllClientModel().getValueAt(row, 0);
				String targetIp = (String)cp.getDtmAllClientModel().getValueAt(row, 1);
				String msg = String.format("%s 님과 대화를 시작하시겠습니까?", targetNickName);
				int r = JOptionPane.showConfirmDialog(frame, msg);
				if(r == JOptionPane.OK_OPTION) {
					
					// 최초의 메세지가 시작되는 부분. 여기에 3번째 패널에 들어갈 작업을 작성한다.
					if(!chatMap.containsKey(targetIp)) {
						ChatMessage cm = new ChatMessage(np.getTfID().getText(), targetIp, targetNickName);
						chatMap.put(targetIp, cm);
						
						// 테이블에 추가
						Vector<String> rowData = new Vector<>();
						
						rowData.add(targetNickName);
						rowData.add(targetIp);
						rowData.add(cm.getHistory().get(0));
						
						cp.getDtmChatClientModel().addRow(rowData);
						
					}
					
					msg = String.format("%s 님과 대화를 시작합니다.", targetNickName);
					JOptionPane.showMessageDialog(null, msg);
					
					selectedChatIp = targetIp;
					
					changeChatContents(chatMap.get(targetIp));
				}
			}
		});
		
		// 로그인 버튼이 클릭되는 경우 실행되는 코드
		// 익명클래스를 사용하여 이벤트처리를 한다.
		np.getBtConnect().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("로그인")) {
					String strIP = np.getTfIP().getText().trim();
					String strPort = np.getTfPORT().getText().trim();
					String strID = np.getTfID().getText().trim();
					String strPW = np.getTfPassword().getText();
					
					// 아무것도 입력이 안되어있을 때
					if (strIP.length() == 0 || strPort.length() == 0 || strID.length() == 0 || strPW.length() == 0) {
						JOptionPane.showMessageDialog(null, "정보를 모두 입력해야만 합니다.");
						np.getCbSaveInfo().setSelected(false);
						return;
					}
					User user = new User(strID, strPW);
					// port 번호를 문자열에서 정수로 변환
					int nPort = Integer.parseInt(strPort);
					// 클라이언트의 정보를 저장하는 객체 생성
					ServerInfo serverInfo = new ServerInfo(strIP, nPort, strID, user);
					System.out.println("serverInfo 생성 성공");
					// 저장된 클라이언트 정보를 기준으로 클라이언트 소켓객체를 생성하고 쓰레드 실행
					clientSocket = new ClientSocket(frame, serverInfo);
					clientSocket.start();
					
					// 서버쪽의 데이터수신을 기다리는 객체생성과 쓰레드 실행
					// 종료처리도 따로 해야함
					clientBinarySocket = new ClientBinarySocket(frame);
					clientBinarySocket.start();
					np.getBtConnect().setText("로그아웃");
					
					
//					// 커넥션을 쓰면 안되..
//					Connection conn = JDBCConnection.getConnection();
//					if ( dao.login(conn, user) == 1 ) {
//						JOptionPane.showMessageDialog(null, "로그인 성공 !");
//					} else {
//						JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요.");
//					}
					
				} else {
					np.getBtConnect().setText("로그인");
					clientSocket.close();
					clientBinarySocket.close();
				}

				
			}
		});


		setSize(3000, 1200);
		setVisible(true);
	}
	
	private void sendMsg() {
		String msg = cp.getTfSendMsg().getText().trim();
		if(msg.length() == 0) {
			JOptionPane.showMessageDialog(null, "메세지를 입력해야 합니다.");
			return;
		} else if ( selectedChatIp == null ) {
			JOptionPane.showMessageDialog(null, "대화 상대를 선택해야 합니다.");
			return;
		}
		
		// 텍스트 필드에 있는 말을 선택된 ip를 키값으로 갖는 chatMap의 chatMessage 값에 history에 저장한다.
		String output = chatMap.get(selectedChatIp).addHistory(msg);
		cp.getTaChatMsg().append(output);
		// 메시지 Area 스크롤이 최근 입력한 메세지를 따라 제일 밑으로 이동하는 코드
		cp.getTaChatMsg().setCaretPosition(cp.getTaChatMsg().getDocument().getLength());
		
		String myNickName = np.getTfID().getText();				
		String myIp = null;
		int size = cp.getDtmAllClientModel().getRowCount();		
		// 테이블을 순회하며 텍스트필드에서 가져온 나의 닉네임이랑 같은 행의 아이피를 가져옴
		for( int i = 0 ; i < size ; i++ ) {
			String nickName = (String)cp.getDtmAllClientModel().getValueAt(i, 0);
			
			if( nickName.equals(myNickName) ) {
				myIp = (String)cp.getDtmAllClientModel().getValueAt(i, 1);						
				break;
			}
		}		
				
		// send 메소드 실행을 위해 위의 과정이 필요했다.
		clientSocket.send(selectedChatIp, output, myIp, myNickName);
		// 전송 후 공백으로 텍스트필드를 대치
		cp.getTfSendMsg().setText("");
		
		// ->의 시작인덱스를 찾아 2칸 뒤(메세지의 시작부분)에 나오는 텍스트를 buf에 담아서
		// 해당 테이블의 값을 저장한다.
		String buf = output.substring(output.indexOf("->") + 2);
		updateChatTable(selectedChatIp, buf.trim());
	}
	//ㄴㅀㄴㅇㅀ
	
	public void updateChatTable(String ip, String output) {
		int size = cp.getDtmChatClientModel().getRowCount();		
		// 테이블을 순회하며 텍스트필드에서 가져온 닉네임이랑 같은 행의 아이피를 가져옴
		for( int i = 0 ; i < size ; i++ ) {
			// 현재 행의 상대 ip를 가져옴 2번째콜롬이므로 1
			String targetIp = (String)cp.getDtmChatClientModel().getValueAt(i, 1);
			// 가져온게 내가 입력한거와 같으면 i번째 행의 2번째 컬럼을 output으로 바꿔치기
			if( ip.equals(targetIp) ) {
				cp.getDtmChatClientModel().setValueAt(output, i, 2);
				break;
			}
		}	
	}
	

	// 저장도니 파일 객체를 입력스트림으로 가져와서 ServerInfo 객체로 변환하여 저장된 ip,port,별칭을 
	// 텍스트 필드 칸에 자동으로 입력해놓는 메소드.
	private void loadServerInfo() {
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(SERVER_INFO_SAVE_FILE)))) {
			ServerInfo si = (ServerInfo) in.readObject();

			if (si == null)
				return;

			np.getTfIP().setText(si.getIp());
			np.getTfPORT().setText(si.getPort() + ""); // 숫자값이여서 바꿔줌
			np.getTfID().setText(si.getID());

			np.getCbSaveInfo().setSelected(true);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "정보를 로딩하는 과정에서 문제가 발생했습니다.");
		}
	}
	
	// ClientSocket 객체에 사용되는 메소드.
	// ClientInfo(ip와 별칭, 접속시간을 필드로 갖는) 객체를 저장하는 배열을 받아와서
	// Table을 만드는 메소드이다.
	// 서버에서 받아오는 객체( 서버에서 소켓이 accept 되면 ip와 클라이언트에서 보낸 별칭, 시간을 전송받는다 )
	// 그것을 기준으로 클라이언트의 테이블에 그 속성들을 추가한다.
	public void setConnectedTable(ArrayList<ClientInfo> list) {
		
		// list의 배열 갯수만큼 돌면서 
		// list에 있는 각각의 정보를 info에 넣어주고
		// 그 info에서 닉네임과 ip, 접속한 시간을 벡터배열에 넣어준다.
		// 그 후 CenterPane에 있는 AllClient 테이블에 rowData를 넣어 테이블을 완성해준다.
		for( ClientInfo info : list ) {
			Vector<String> rowData = new Vector<>();
			
			rowData.add(info.getID());
			rowData.add(info.getIp());
			rowData.add(info.getConnectedTime().toString());
			
			this.cp.getDtmAllClientModel().addRow(rowData);
		}
	}
	
	
	public void addConnectedTable(ClientInfo info) {
		Vector<String> rowData = new Vector<>();
		
		rowData.add(info.getID());
		rowData.add(info.getIp());
		rowData.add(info.getConnectedTime().toString());
		
		this.cp.getDtmAllClientModel().addRow(rowData);
	}
	
	public void delConnectedTable(ClientInfo info) {
		// 현재 출력중인 테이블의 목록 수
		int size = this.cp.getDtmAllClientModel().getRowCount();
		
		// ip를 기준으로 찾아보자.
		for(int i = 0 ; i < size ; i++) {
			// i행 2열에 있는 ip성분 가져오기
			String ip = (String)this.cp.getDtmAllClientModel().getValueAt(i, 1);
			
			if(ip.equals(info.getIp())) {
				this.cp.getDtmAllClientModel().removeRow(i);
				break;
			}
		}
	}
	
	// 공지메세지 에어리어에 받아온 패킷데이터를 스트링으로 변환하여 append 시킨다.
	public void addNoticeMessage(String msg) {
		
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd  HH:mm  : ");
		String output = String.format("%s%s\n", sdf.format(now), msg);
		
		this.cp.getTaNoticeMsg().append(output);
		// dsfseg 여기에 스크롤기능 추가(공지메세지 에어리어)
	}

	
	// chatMap에 저장된 chatMessage로 history에 저장된 메세지를 TextArea에 추가
	public void changeChatContents(ChatMessage cm) {
		
		ArrayList<String> history = cm.getHistory();
		// cp.getTaChatMsg().setText(""); 굳이 할 필요는 없다.

		// 현재 멀티스레드환경이 아니므로 굳이 스트링버퍼를 쓸필요는 없다.
		StringBuilder sb = new StringBuilder();
		for(String msg : history) {
			sb.append(msg);
		}
		
		cp.getTaChatMsg().setText(sb.toString());
		
	}
	
	// 패킷으로 받아온 메세지를 테이블에 해당 ip키값에 대응되는 값으로 대치한 후
	// 텍스트 에어리어에 append 한다.
	public void receiveMessage(String sourceIp, String sourceNickName, String msg) {
		
		// 날짜를 지우기 위한 코드 ( 3번째 테이블에 )
		String buf = msg.substring(msg.indexOf("->") + 2);
		
		// 채팅 목록에 있는지 확인한 후 들어온 메세지를 저장
		if( !chatMap.containsKey(sourceIp) ) {
			ChatMessage cm = new ChatMessage(np.getTfID().getText(), sourceIp, sourceNickName);
			cm.getHistory().add(msg);
			
			chatMap.put(sourceIp, cm);
			
			// 테이블에 내용 추가
			Vector<String> rowData = new Vector<>();
			
			rowData.add(sourceNickName);
			rowData.add(sourceIp);
			rowData.add(buf.trim());
			
			cp.getDtmChatClientModel().addRow(rowData);
		} else {
			chatMap.get(sourceIp).getHistory().add(msg);
			updateChatTable(sourceIp, buf.trim());
		}
		
		if( selectedChatIp == null ) {
			selectedChatIp = sourceIp;
			// 선택된 사람의 내용으로 바꿈.
			changeChatContents(chatMap.get(sourceIp));
			JOptionPane.showMessageDialog(null, String.format("%s 님의 메세지가 도착했습니다.", sourceNickName));
		} else if( selectedChatIp.equals(sourceIp) ) {      // 지금 채팅중인 ip인 경우
			cp.getTaChatMsg().append(msg);
		}
		
	}
	
	
	public static void main(String[] args) {
		new ClientFrame();
	}

	
	// 정보유지를 체크했을 때 실행되는 리스너 클래스
	class SaveClientInfoHanddler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 체크박스가 선택이 해제되면 정보를 삭제하는 조건문
			// 체크박스가 선택되지 않았다면
			if (!np.getCbSaveInfo().isSelected()) {
				// 파일이 있는지 확인하고 있다면
				if (SERVER_INFO_SAVE_FILE.exists())
					// 파일을 삭제한다.
					SERVER_INFO_SAVE_FILE.delete();
				// 삭제한 뒤엔 삭제했다는 다이얼로그를 띄우고 빠져나간다.
				JOptionPane.showMessageDialog(null, "저장된 정보를 삭제했습니다.");
				return;
			}

			// 체크박스가 선택되었다면 정보를 저장하는 기능
			// 트림을 통해 공백을 지운다.
			// 계속 정보가 바뀔 수 있으므로 따로 tje.chat.model 패키지로 뺌
			String strIp = np.getTfIP().getText().trim();
			String strPort = np.getTfPORT().getText().trim();
			String strID = np.getTfID().getText().trim();

			// 아무것도 입력이 안되어있을 때
			if (strIp.length() == 0 || strPort.length() == 0 || strID.length() == 0) {
				JOptionPane.showMessageDialog(null, "정보를 모두 입력해야만 합니다.");
				np.getCbSaveInfo().setSelected(false);
				return;
			}

			User user = new User(strID, "");
			// port 번호를 문자열에서 정수로 변환
			int nPort = Integer.parseInt(strPort);
			// 클라이언트의 정보를 저장하는 객체 생성
			// 위에서 초기화한 strIp,strPort,strNickName 변수를 si 객체에 저장한다.
			ServerInfo si = new ServerInfo(strIp, nPort, strID, user);

			// 아래처럼 try() 에서 괄호안에 스트림을 생성하면 close를 매번 안해줘도 됨
			// 객체 출력스트림을 생성하여 SERVER_INFO_SAVE_FILE에 si에 저장된 변수들을 데이터로 저장하기 위한 출력스트림.
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(SERVER_INFO_SAVE_FILE)));) {
				// si 객체를 출력스트림으로 뺀다.
				out.writeObject(si);
			} catch (Exception ex) { // 익셉션 하나로만 통일
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "정보 저장 과정에서 문제가 발생하였습니다.");
				np.getCbSaveInfo().setSelected(false);
				return;
			}
			JOptionPane.showMessageDialog(null, "정보 저장을 완료했습니다.");
		}
	}


	public ClientSignInDialog getSignDial() {
		return SignDial;
	}

	public void setSignDial(ClientSignInDialog signDial) {
		SignDial = signDial;
	}
}
