package tje.chat.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.*;

import tje.chat.model.*;
import tje.jdbc.model.Member;
import tje.jdbc.model.Notice;
import tje.chat.client.dialog.RegistDialog;
import tje.chat.client.net.ClientBinarySocket;
import tje.chat.client.net.ClientSocket;
import tje.chat.client.net.regist.RegistSocket;
import tje.chat.client.panel.*;
import tje.chat.common.ClientInfo;

public class ClientFrame extends JFrame {
	private ClientFrame frame = this;
	
	// 정보 저장을 위한 파일의 경로 및 File 객체 생성
	private static final String CLIENT_DIR_PATH = "./client";
	private static final String SERVER_INFO_FILE_PATH = "server_info.dat";
	private static File CLIENT_DIR;
	private static File SERVER_INFO_SAVE_FILE;	
	static {
		CLIENT_DIR = new File(CLIENT_DIR_PATH);
		if( !CLIENT_DIR.exists() )
			CLIENT_DIR.mkdirs();
		
		SERVER_INFO_SAVE_FILE = new File(CLIENT_DIR, SERVER_INFO_FILE_PATH);
	}
	
	private ClientSocket clientSocket;
	private ClientBinarySocket clientBinarySocket;
	
	private String selectedChatIp;
	private HashMap<String, ChatMessage> chatMap = new HashMap<>();

	private NorthPanel np = new NorthPanel();
	private CenterPanel cp = new CenterPanel();
	
	private Member loginMember = null;
	
	public ClientFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.setTitle("Chat Client - Ver 0.1");		
		
		// 화면 배치
		this.setLayout(new BorderLayout(0, 3));
		this.add(np, BorderLayout.NORTH);
		this.add(cp, BorderLayout.CENTER);
		
		// 저장된 정보를 확인한 후, 화면 컴포넌트의 값이나 상태를 변경
		if( SERVER_INFO_SAVE_FILE.exists() )			
			loadServerInfo();
		
		// 컴포넌트들의 이벤트 처리
		
		// 텍스트 필드의 엔터키 처리
		this.cp.getTfSendMsg().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		
		// 클라이언트 간의 채팅을 위한 메세지 전송
		// (버튼 이벤트 처리)
		this.cp.getBtSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		
		// 클라이언트 간의 채팅을 시작하기 위한 클릭 이벤트 처리
		this.cp.getTbAllClient().addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent e) {
				// 현재 선택된 행의 인덱스를 반환
				int row = cp.getTbAllClient().getSelectedRow();
				if( row == -1 )
					return;
				
				/*
				String msg = String.format("%s - %s 선택", 
						cp.getDtmAllClientModel().getValueAt(row, 0), 
						cp.getDtmAllClientModel().getValueAt(row, 1));
				JOptionPane.showMessageDialog(null, msg);
				*/
				
				String targetNickName = (String) cp.getDtmAllClientModel().getValueAt(row, 0);
				String targetIp = (String) cp.getDtmAllClientModel().getValueAt(row, 1);
				String msg = String.format("%s 님과 대화를 시작하시겠습니까?", targetNickName);
				
				int r = JOptionPane.showConfirmDialog(frame, msg);
				if( r == JOptionPane.OK_OPTION ) {
					
					if( !chatMap.containsKey(targetIp) ) {
						ChatMessage cm = new ChatMessage(
								loginMember.getNick(), targetIp, targetNickName);
						chatMap.put(targetIp, cm);
						
						// 테이블에 내용 추가
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
		
		// 정보 저장 체크박스의 이벤트 처리
		np.getCbSaveInfo().addActionListener(new SaveClientInfoHanddler());
		
		// 서버 연결 버튼이 클릭되는 경우 실행되는 코드
		np.getBtnConnect().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strIp = np.getTfIP().getText().trim();
				String strPort = np.getTfPORT().getText().trim();				
				String strId = np.getTfId().getText().trim();
				String strPw = np.getTfPw().getText().trim();
				
				if( strIp.length() == 0 || strPort.length() == 0 || 
						strId.length() == 0 || strPw.length() == 0 ) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해야만 합니다.");
					np.getCbSaveInfo().setSelected(false);
					return;
				}
				
				// port 번호를 문자열에서 정수로 변환
				int nPort = Integer.parseInt(strPort);
				// 클라이언트의 정보를 저장하는 객체 생성
				ServerInfo serverInfo = 
						new ServerInfo(strIp, nPort,
								new Member(strId, strPw, null, null, null));
				
				clientSocket = new ClientSocket(frame, serverInfo);
				clientSocket.start();
				
				clientBinarySocket = new ClientBinarySocket(frame);
				clientBinarySocket.start();
			}
		});
		
		// 회원가입 버튼의 이벤트 처리
		np.getBtnRegist().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistDialog dialog = new RegistDialog();
				dialog.setVisible(true);
				Member member = null;
				RegistSocket registSocket;
				// 가입버튼을 클릭한 경우에만 처리
				if( dialog.getState() == 1 ) {
					member = new Member(dialog.getId(), 
							dialog.getPw(), dialog.getName(), 
							dialog.getNick(), null);
					registSocket = new RegistSocket(
							frame, 
							new ServerInfo(
									np.getTfIP().getText().trim(), 
									7777, null), member);
				}
			}
		});
		
		setSize(1000, 500);
		setVisible(true);
	}
	
	public void setLoginMember(Member loginMember) {
		this.loginMember = loginMember;
	}
	
	private void sendMsg() {
		String msg = cp.getTfSendMsg().getText().trim();
		if( msg.length() == 0 ) {
			JOptionPane.showMessageDialog(null, "메세지를 입력해야 합니다.");
			return;
		} else if( selectedChatIp == null ) {
			JOptionPane.showMessageDialog(null, "대화 상대를 선택해야 합니다.");
			return;
		}
		
		String output = chatMap.get(selectedChatIp).addHistory(msg);
		cp.getTaChatMsg().append(output);
						
		String myNickName = loginMember.getNick();				
		String myIp = null;
		int size = cp.getDtmAllClientModel().getRowCount();				
		for( int i = 0 ; i < size ; i++ ) {
			String nickName = (String)cp.getDtmAllClientModel().getValueAt(i, 0);
			
			if( nickName.equals(myNickName) ) {
				myIp = (String)cp.getDtmAllClientModel().getValueAt(i, 1);						
				break;
			}
		}
				
		clientSocket.send(selectedChatIp, output, myIp, myNickName);
		cp.getTfSendMsg().setText("");
				
		String buf = output.substring(output.indexOf("->") + 2);
		updateChatTable(selectedChatIp, buf.trim());
	}
	
	public void updateChatTable(String ip, String output) {
		int size = cp.getDtmChatClientModel().getRowCount();				
		for( int i = 0 ; i < size ; i++ ) {
			String targetIp = (String)cp.getDtmChatClientModel().getValueAt(i, 1);
			
			if( ip.equals(targetIp) ) {
				cp.getDtmChatClientModel().setValueAt(output, i, 2);						
				break;
			}
		}
	}
	
	private void loadServerInfo() {
		try (ObjectInputStream in = 
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(SERVER_INFO_SAVE_FILE)))) {
			ServerInfo si = (ServerInfo)in.readObject();
			
			if( si == null )
				return;
			
			np.getTfIP().setText(si.getIp());
			np.getTfPORT().setText(si.getPort() + "");
			np.getTfId().setText(si.getMember().getId());
			np.getTfPw().setText(si.getMember().getPassword());
			
			np.getCbSaveInfo().setSelected(true);
		} catch( Exception e ) {
			JOptionPane.showMessageDialog(null, "정보를 로딩하는 과정에서 문제가 발생했습니다.");
			e.printStackTrace();
		}
	}
	
	public void setConnectedTable(ArrayList<ClientInfo> list) {		
		for( ClientInfo info : list ) {
			Vector<String> rowData = new Vector<>();
			
			rowData.add(info.getMember().getNick());
			rowData.add(info.getIp());
			rowData.add(info.getConnectedTime().toString());
			
			this.cp.getDtmAllClientModel().addRow(rowData);			
		}
	}
	
	public void addConnectedTable(ClientInfo info) {
		Vector<String> rowData = new Vector<>();
		
		rowData.add(info.getMember().getNick());
		rowData.add(info.getIp());
		rowData.add(info.getConnectedTime().toString());
		
		this.cp.getDtmAllClientModel().addRow(rowData);	
	}
	
	public void delConnectedTable(ClientInfo info) {		
		int size = this.cp.getDtmAllClientModel().getRowCount();
		
		for( int i = 0 ; i < size ; i++ ) {
			String ip = (String)this.cp.getDtmAllClientModel().getValueAt(i, 1);
			
			if( ip.equals(info.getIp()) ) {
				this.cp.getDtmAllClientModel().removeRow(i);
				break;
			}
		}
	}	
	
	public void addNoticeMessage(String msg) {
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss : ");
		
		String output = String.format("%s%s\n", sdf.format(now), msg);
		this.cp.getTaNoticeMsg().append(output);
	}
	
	public void addNoticeMessage(ArrayList<Notice> list) {	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss : ");
		for( int i = list.size() - 1 ; i >= 0 ; i-- ) {
			String output = String.format("%s%s\n", 
					sdf.format(list.get(i).getWrite_date()), 
					list.get(i).getMessage());
			this.cp.getTaNoticeMsg().append(output);
			this.cp.getTaNoticeMsg().setCaretPosition(this.cp.getTaNoticeMsg().getDocument().getLength());	
		}
	}
	
	public void changeChatContents(ChatMessage cm) {
		
		ArrayList<String> history = cm.getHistory();
		// cp.getTaChatMsg().setText("");
		
		StringBuilder sb = new StringBuilder();
		for( String msg : history ) {
			sb.append(msg);
		}
		
		cp.getTaChatMsg().setText(sb.toString());
		
	}
	
	public void receiveMessage(String sourceIp, String sourceNickName, String msg) {
		
		String buf = msg.substring(msg.indexOf("->") + 2);
		
		if( !chatMap.containsKey(sourceIp) ) {			
			ChatMessage cm = new ChatMessage(
					loginMember.getNick(), sourceIp, sourceNickName);
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
			changeChatContents(chatMap.get(sourceIp));
			JOptionPane.showMessageDialog(null, 
					String.format("%s 님의 메세지가 도착했습니다.", sourceNickName));
		} else if( selectedChatIp.equals(sourceIp) ) {			
			cp.getTaChatMsg().append(msg);
		}
	}

	public static void main(String[] args) {		
		new ClientFrame();
	}
	
	class SaveClientInfoHanddler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if( !np.getCbSaveInfo().isSelected() ) {
				if( SERVER_INFO_SAVE_FILE.exists() )
					SERVER_INFO_SAVE_FILE.delete();
				
				JOptionPane.showMessageDialog(null, "저장된 정보를 삭제했습니다.");
				return;
			}
			
			String strIp = np.getTfIP().getText().trim();
			String strPort = np.getTfPORT().getText().trim();				
			String strId = np.getTfId().getText().trim();
			String strPw = np.getTfPw().getText().trim();
			
			if( strIp.length() == 0 || strPort.length() == 0 || 
					strId.length() == 0 || strPw.length() == 0 ) {
				JOptionPane.showMessageDialog(null, "정보를 모두 입력해야만 합니다.");
				np.getCbSaveInfo().setSelected(false);
				return;
			}
			
			// port 번호를 문자열에서 정수로 변환
			int nPort = Integer.parseInt(strPort);
			// 클라이언트의 정보를 저장하는 객체 생성
			ServerInfo si = new ServerInfo(strIp, nPort, 
					new Member(strId, strPw, null, null, null));
			
			try(ObjectOutputStream out = 
						new ObjectOutputStream(
								new BufferedOutputStream(
										new FileOutputStream(SERVER_INFO_SAVE_FILE)))) {					
				out.writeObject(si);
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "정보 저장과정에서 문제가 발생하였습니다.");
				np.getCbSaveInfo().setSelected(false);
				return;
			}
			
			JOptionPane.showMessageDialog(null, "정보 저장을 완료했습니다.");
		}
	}
}






