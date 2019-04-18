package tje.chat.client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import tje.chat.client.net.ClientSocket;
import tje.chat.client.panel.*;
import tje.chat.model.*;

public class ClientFrame extends JFrame {
	// 외부에서 이 클래스의 멤버필드에 접근하기 위한 대책
	private ClientFrame frame = this;
	
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
		if (SERVER_INFO_SAVE_FILE.exists())
			loadServerInfo();

		// 컴포넌트들의 이벤트 처리
		// 정보저장 체크박스의 이벤트 처리
		// 이너 클래스로 만들어서 처리한다.
		np.getCbSaveInfo().addActionListener(new SaveClientInfoHanddler());
		
		// 연결버튼의 이벤트처리
		// 서버 연결 버튼이 클릭되는 경우 실행되는 코드
		np.getBtConnect().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String strIp = np.getTfIP().getText().trim();
				String strPort = np.getTfPORT().getText().trim();
				String strNickName = np.getTfNickName().getText().trim();

				// 아무것도 입력이 안되어있을 때
				if (strIp.length() == 0 || strPort.length() == 0 || strNickName.length() == 0) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해야만 합니다.");
					np.getCbSaveInfo().setSelected(false);
					return;
				}
				
				// port 번호를 문자열에서 정수로 변환
				int nPort = Integer.parseInt(strPort);
				// 클라이언트의 정보를 저장하는 객체 생성
				ServerInfo serverInfo = new ServerInfo(strIp, nPort, strNickName);
				
				ClientSocket clientSocket = new ClientSocket(frame, serverInfo);
			}
		});

		setSize(1000, 500);
		setVisible(true);
	}

	private void loadServerInfo() {
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(SERVER_INFO_SAVE_FILE)))) {
			ServerInfo si = (ServerInfo) in.readObject();

			if (si == null)
				return;

			np.getTfIP().setText(si.getIp());
			np.getTfPORT().setText(si.getPort() + ""); // 숫자값이여서 바꿔줌
			np.getTfNickName().setText(si.getNickName());

			np.getCbSaveInfo().setSelected(true);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "정보를 로딩하는 과정에서 문제가 발생했습니다.");
		}
	}

	public static void main(String[] args) {
		new ClientFrame();
	}

	class SaveClientInfoHanddler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// 체크박스가 선택이 해제되면 정보를 삭제하는 조건문
			if (!np.getCbSaveInfo().isSelected()) {
				if (SERVER_INFO_SAVE_FILE.exists())
					SERVER_INFO_SAVE_FILE.delete();
				JOptionPane.showMessageDialog(null, "저장된 정보를 삭제했습니다.");
				return;
			}

			// 트림을 통해 공백을 지운다.
			// 계속 정보가 바뀔 수 있으므로 따로 tje.chat.model 패키지로 뺌
			String strIp = np.getTfIP().getText().trim();
			String strPort = np.getTfPORT().getText().trim();
			String strNickName = np.getTfNickName().getText().trim();

			// 아무것도 입력이 안되어있을 때
			if (strIp.length() == 0 || strPort.length() == 0 || strNickName.length() == 0) {
				JOptionPane.showMessageDialog(null, "정보를 모두 입력해야만 합니다.");
				np.getCbSaveInfo().setSelected(false);
				return;
			}

			// port 번호를 문자열에서 정수로 변환
			int nPort = Integer.parseInt(strPort);
			// 클라이언트의 정보를 저장하는 객체 생성
			ServerInfo si = new ServerInfo(strIp, nPort, strNickName);

			// 아래처럼 try() 에서 괄호안에 하면 close를 매번 안해줘도 됨
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(SERVER_INFO_SAVE_FILE)));) {
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
}
