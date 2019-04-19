package tje.chat.server;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

//import tje.chat.client.ClientFrame.SaveClientInfoHanddler;
//import tje.chat.model.ServerInfo;
// �Ʒ� ��Ű���� ���� ��� �����´�.
import tje.chat.server.panel.*;
import tje.server.model.*;
import tje.chat.server.net.*;

public class ServerFrame extends JFrame {
	// ���� ������ ��ü�� ��������
	// �ܺ��� Ŭ�������� ���� �����ӿ� �����ϱ� ���� ���
	// (�͸�, ���� Ŭ�������� ����� ����)
	private ServerFrame frame = this;

	// ��Ʈ��ȣ ������ ���� ���� ��� �� File ��ü ����
	private static final String PORTNUM_DIR_PATH = "./server";
	private static final String PORT_NUMBER_FILE_PATH = "port_number.dat";
	private static File PORTNUM_DIR;
	private static File PORT_NUMBER_SAVE_FILE;

	// �� ServerFrame ��ü�� �����ɶ� ���� �켱������ ����Ǵ� ���� ����.
	// ��Ʈ��ȣ ���忡 �ʿ��� ��ΰ� �ִ��� Ȯ���ϰ� ������ �����ϸ� port_number.dat ���� ��ü ����
	static {
		PORTNUM_DIR = new File(PORTNUM_DIR_PATH);
		if (!PORTNUM_DIR.exists())
			PORTNUM_DIR.mkdirs();

		PORT_NUMBER_SAVE_FILE = new File(PORTNUM_DIR, PORT_NUMBER_FILE_PATH);
	}

	private NorthPanel np = new NorthPanel();
	private CenterPanel cp = new CenterPanel();
	private SouthPanel sp = new SouthPanel();

	private ClientCollector clientCollector;

	public ServerFrame() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Chat Server - Ver 0.1");

		// ���̾ƿ� ����. JFrame, JDialog�� ����Ʈ ���̾ƿ��� �������̾ƿ��̴�.
		// JPanel�� �⺻ ���̾ƿ��� �÷ο�
		// this.setLayout(new BorderLayout());

		// ȭ�� ��ġ (�� �г��� ������ ������̴�. tje.chat.server.panel ��Ű���� ���� ������)
		this.add(np, BorderLayout.NORTH);
		this.add(cp, BorderLayout.CENTER);
		this.add(sp, BorderLayout.SOUTH);

		// ����� ������ Ȯ���� ��, ȭ�� ������Ʈ�� ���̳� ���¸� ����
		if (PORT_NUMBER_SAVE_FILE.exists())
			loadPortInfo();

		// �� ������Ʈ���� �̺�Ʈ ó��
		this.np.getBtnStartAndStop().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (np.getBtnStartAndStop().getText().equals("����")) {
					clientCollector.close();
					clientCollector = null;
					np.getBtnStartAndStop().setText("����");
					return;
				}

				String strPort = np.getTfPortNumber().getText().trim();

				// �ƹ��͵� �Է��� �ȵǾ����� ��
				if (strPort.length() == 0) {
					JOptionPane.showMessageDialog(null, "��Ʈ��ȣ�� �Է��ؾ߸� �մϴ�.");
					return;
				}

				int nPort = Integer.parseInt(strPort);
				clientCollector = new ClientCollector(frame, nPort);
				clientCollector.start();

				np.getBtnStartAndStop().setText("����");

			}
		});

		// �������� üũ�ڽ��� �̺�Ʈ ó��
		// �̳� Ŭ������ ���� ó���Ѵ�.
		np.getCbSavePortNum().addActionListener(new SavePortHanddler());

		setSize(500, 500);
		setVisible(true);

	}

	private void loadPortInfo() {
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(PORT_NUMBER_SAVE_FILE)))) {
			PortInfo pi = (PortInfo) in.readObject();

			if (pi == null)
				return;

			np.getTfPortNumber().setText(pi.getPort() + ""); // ���ڰ��̿��� �ٲ���

			np.getCbSavePortNum().setSelected(true);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "������ �ε��ϴ� �������� ������ �߻��߽��ϴ�.");
		}
	}

	public void noticeServerError() {
		np.getBtnStartAndStop().setText("����");
	}

	// �̰� ������ �����ϱ� ������ ����ȭ�� �ʿ�
	public synchronized void writeLog(String msg) {
		if (!this.cp.getCbLog().isSelected())
			return;

		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss  : ");
		String output = String.format("%s%s\n", sdf.format(now), msg);
		this.cp.getTaLog().append(output);
	}

	class SavePortHanddler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// üũ�ڽ��� ������ �����Ǹ� ������ �����ϴ� ���ǹ�
			if (!np.getCbSavePortNum().isSelected()) {
				if (PORT_NUMBER_SAVE_FILE.exists())
					PORT_NUMBER_SAVE_FILE.delete();
				JOptionPane.showMessageDialog(null, "����� ������ �����߽��ϴ�.");
				return;
			}

			// Ʈ���� ���� ������ �����.
			// ��� ������ �ٲ� �� �����Ƿ� ���� tje.chat.model ��Ű���� ��
			String strPort = np.getTfPortNumber().getText().trim();

			// �ƹ��͵� �Է��� �ȵǾ����� ��
			if (strPort.length() == 0) {
				JOptionPane.showMessageDialog(null, "������ ��� �Է��ؾ߸� �մϴ�.");
				np.getCbSavePortNum().setSelected(false);
				return;
			}

			// port ��ȣ�� ���ڿ����� ������ ��ȯ
			int nPort = Integer.parseInt(strPort);
			// Ŭ���̾�Ʈ�� ������ �����ϴ� ��ü ����
			PortInfo si = new PortInfo(nPort);

			// �Ʒ�ó�� try() ���� ��ȣ�ȿ� �ϸ� close�� �Ź� �����൵ ��
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(PORT_NUMBER_SAVE_FILE)));) {
				out.writeObject(si);
			} catch (Exception ex) { // �ͼ��� �ϳ��θ� ����
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "���� ���� �������� ������ �߻��Ͽ����ϴ�.");
				np.getCbSavePortNum().setSelected(false);
				return;
			}

			JOptionPane.showMessageDialog(null, "���� ������ �Ϸ��߽��ϴ�.");
		}
	}

	public static void main(String[] args) {
		new ServerFrame();
	}
}