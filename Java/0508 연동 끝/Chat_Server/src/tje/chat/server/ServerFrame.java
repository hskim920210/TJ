package tje.chat.server;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.io.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.*;

//import tje.chat.client.ClientFrame.SaveClientInfoHanddler;
//import tje.chat.model.ServerInfo;
// 아래 패키지의 것을 모두 가져온다.
import tje.chat.server.panel.*;
import tje.server.model.*;
import tje.chat.common.Packet;
import tje.chat.common.jdbc.UserDAO;
import tje.chat.common.util.JDBCConnection;
import tje.chat.server.net.*;

public class ServerFrame extends JFrame {
	// 현재 프레임 객체의 참조변수
	// 외부의 클래스에서 현재 프레임에 접근하기 위해 사용
	// (익명, 내부 클래스에서 사용할 변수)
	private ServerFrame frame = this;

	// 포트번호 저장을 위한 파일 경로 및 File 객체 생성
	private static final String PORTNUM_DIR_PATH = "./server";
	private static final String PORT_NUMBER_FILE_PATH = "port_number.dat";
	private static File PORTNUM_DIR;
	private static File PORT_NUMBER_SAVE_FILE;

	// 이 ServerFrame 객체가 생성될때 제일 우선적으로 실행되는 영역 지정.
	// 포트번호 저장에 필요한 경로가 있는지 확인하고 없으면 생성하며 port_number.dat 파일 객체 생성
	static {
		PORTNUM_DIR = new File(PORTNUM_DIR_PATH);
		if (!PORTNUM_DIR.exists())
			PORTNUM_DIR.mkdirs();

		PORT_NUMBER_SAVE_FILE = new File(PORTNUM_DIR, PORT_NUMBER_FILE_PATH);
	}

	private NorthPanel np = new NorthPanel();
	private CenterPanel cp = new CenterPanel();
	private SouthPanel sp = new SouthPanel();
	
	private UserDAO dao = UserDAO.getInstance();

	// 내가 가진 이너크래스를 사용하여 이벤트를 처리하겠다.
	private DropTarget dropTarget = new DropTarget(
			cp.getTaLog(), DnDConstants.ACTION_COPY_OR_MOVE, new FileTransfer(), true, null);
	
	private ClientCollector clientCollector;
	private SignInThread signInThread = new SignInThread();

	public ServerFrame() {
		Connection conn = JDBCConnection.getConnection();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Chat Server - Ver 0.1");

		// 레이아웃 지정. JFrame, JDialog의 디폴트 레이아웃은 보더레이아웃이다.
		// JPanel은 기본 레이아웃이 플로우
		// this.setLayout(new BorderLayout());

		// 화면 배치 (각 패널을 변수로 만들것이다. tje.chat.server.panel 패키지에 따로 빼놓음)
		this.add(np, BorderLayout.NORTH);
		this.add(cp, BorderLayout.CENTER);
		this.add(sp, BorderLayout.SOUTH);

		// 저장된 정보를 확인한 후, 화면 컴포넌트의 값이나 상태를 변경
		if (PORT_NUMBER_SAVE_FILE.exists())
			loadPortInfo();

		// 각 컴포넌트들의 이벤트 처리
		// 엔터키 누를때 전송 (액션리스너의 기본액션은 엔터키이다) ( 버튼처리와 똑같은코드로 )
		// 이벤트가 발생하면 Textfield 값을 String 타입으로 받아와서
		// 1번 타입의 패킷으로 객체화시킨다.
		// 그 후 packet을 Broadcast하고 TextArea에 출력한다.
		this.sp.getTfNoticeMsg().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = sp.getTfNoticeMsg().getText().trim();
				if(msg.length() == 0) {
					JOptionPane.showMessageDialog(null, "메세지를 입력해야합니다.");
					return;
				}
				
				Packet packet = new Packet(Packet.TYPE_NOTICE, msg);
				BroadCaster.broadCast(packet);
				writeLog(msg);
				sp.getTfNoticeMsg().setText("");
				dao.insert(conn, msg);
			}
		});
		
		
		
		// 전송버튼 처리
		this.sp.getBtnSend().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = sp.getTfNoticeMsg().getText().trim();
				if(msg.length() == 0) {
					JOptionPane.showMessageDialog(null, "메세지를 입력해야합니다.");
					return;
				}
				
				Packet packet = new Packet(Packet.TYPE_NOTICE, msg);
				BroadCaster.broadCast(packet);
				writeLog(msg);
				sp.getTfNoticeMsg().setText("");
				dao.insert(conn, msg);
			}
		});
		
		// 시작버튼 처리
		this.np.getBtnStartAndStop().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (np.getBtnStartAndStop().getText().equals("종료")) {
					clientCollector.close();
					signInThread.close();
					clientCollector = null;
					np.getBtnStartAndStop().setText("시작");
					return;
				}

				String strPort = np.getTfPortNumber().getText().trim();

				// 아무것도 입력이 안되어있을 때
				if (strPort.length() == 0) {
					JOptionPane.showMessageDialog(null, "포트번호를 입력해야만 합니다.");
					return;
				}

				int nPort = Integer.parseInt(strPort);
				clientCollector = new ClientCollector(frame, nPort);
				System.out.println("클라이언트 콜렉터 객체 생성 완료");
				clientCollector.start();
				System.out.println("클라이언트 콜렉터 쓰레드 실행");
				signInThread.start();
				System.out.println("회원가입 쓰레드 실행");

				np.getBtnStartAndStop().setText("종료");

			}
		});

		// 정보저장 체크박스의 이벤트 처리
		// 이너 클래스로 만들어서 처리한다.
		np.getCbSavePortNum().addActionListener(new SavePortHanddler());

		setSize(1200, 700);
		setVisible(true);

	}

	
	// 저장된 포트번호를 텍ㄷ스트필드에 대치하는 메소드.
	private void loadPortInfo() {
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(PORT_NUMBER_SAVE_FILE)))) {
			PortInfo pi = (PortInfo) in.readObject();

			if (pi == null)
				return;

			np.getTfPortNumber().setText(pi.getPort() + ""); // 숫자값이여서 바꿔줌

			np.getCbSavePortNum().setSelected(true);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "정보를 로딩하는 과정에서 문제가 발생했습니다.");
		}
	}

	public void noticeServerError() {
		np.getBtnStartAndStop().setText("시작");
	}

	// 이건 여럿이 참조하기 때문에 동기화가 필요
	// 메세지를 받아 아래와 같은 형태로 TextArea에 append 한다.
	public synchronized void writeLog(String msg) {
		if (!this.cp.getCbLog().isSelected())
			return;

		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd  HH:mm  : ");
		String output = String.format("%s%s\n", sdf.format(now), msg);
		
		this.cp.getTaLog().append(output);
		// TextArea에 내용이 추가되면 가장 마지막으로 이동시킴.  수정필요
		this.cp.getTaLog().setCaretPosition(this.cp.getTaLog().getDocument().getLength());
	}

	// 포트번호 저장 체크박스 이벤트
	class SavePortHanddler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// 체크박스가 선택이 해제되면 정보를 삭제하는 조건문
			if (!np.getCbSavePortNum().isSelected()) {
				if (PORT_NUMBER_SAVE_FILE.exists())
					PORT_NUMBER_SAVE_FILE.delete();
				JOptionPane.showMessageDialog(null, "저장된 정보를 삭제했습니다.");
				return;
			}

			// 트림을 통해 공백을 지운다.
			// 계속 정보가 바뀔 수 있으므로 따로 tje.chat.model 패키지로 뺌
			String strPort = np.getTfPortNumber().getText().trim();

			// 아무것도 입력이 안되어있을 때
			if (strPort.length() == 0) {
				JOptionPane.showMessageDialog(null, "정보를 모두 입력해야만 합니다.");
				np.getCbSavePortNum().setSelected(false);
				return;
			}

			// port 번호를 문자열에서 정수로 변환
			int nPort = Integer.parseInt(strPort);
			// 클라이언트의 정보를 저장하는 객체 생성
			PortInfo si = new PortInfo(nPort);

			// 아래처럼 try() 에서 괄호안에 하면 close를 매번 안해줘도 됨
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(PORT_NUMBER_SAVE_FILE)));) {
				out.writeObject(si);
			} catch (Exception ex) { // 익셉션 하나로만 통일
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "정보 저장 과정에서 문제가 발생하였습니다.");
				np.getCbSavePortNum().setSelected(false);
				return;
			}

			JOptionPane.showMessageDialog(null, "정보 저장을 완료했습니다.");
		}
	}

	public static void main(String[] args) {
		new ServerFrame();
	}
	
	
	// 드래그앤드롭 구현하고자하는 클래스에 DropTargetAdapter 구현
	class FileTransfer extends DropTargetAdapter {
		@Override
		public void drop(DropTargetDropEvent dtde) {
			// if (dtde.getDropAction() == DnDConstants.ACTION_COPY_OR_MOVE) 와 같은 코드.
			// System.out.println("drop : "+dtde.getDropAction()); 드롭하면 2이고 dndcons가 3이므로 둘이연산해서 0이안됨.
			if ((dtde.getDropAction() & DnDConstants.ACTION_COPY_OR_MOVE) != 0) {
				// 드랍이벤트를 억셉트 하겟다. 이벤트 타입에 따라서.. 파일을 받아들일 수 있는 선언문.
				dtde.acceptDrop(dtde.getDropAction());
				// 파일의 리스트를 받아올 수 있는
				Transferable tf = dtde.getTransferable();
				
				// 드롭시에 드롭한 파일의 경로를 출력하는 코드
				try {
					java.util.List list = (java.util.List) tf.getTransferData(DataFlavor.javaFileListFlavor);

					for(int i = 0 ; i < list.size() ; i++) {
						writeLog(list.get(i) + " 파일 전송 시작");
						
						FileTransferThread ftt = new FileTransferThread((File)list.get(i));
						ftt.start();
						//ftt.join();
						writeLog(list.get(i) + " 파일 전송 종료");
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
