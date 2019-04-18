package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class CenterPanel extends JPanel {

	// {"별칭", "IP", "접속시간"} 테이블 만들기
	private Vector<String> strAllClientHeader = new Vector<String>();
	private DefaultTableModel dtmAllClientModel;
	private JTable tbAllClient;

	private JLabel lbNoticeMsg = new JLabel("공지메세지", SwingConstants.CENTER);
	private JTextArea taNoticeMsg = new JTextArea();

	// {"별칭", "IP", "마지막 메세지"} 테이블 만들기
	private Vector<String> strChatClientHeader = new Vector<String>();
	private DefaultTableModel dtmChatClientModel;
	private JTable tbChatClient;

	private CenterRightPanel rp = new CenterRightPanel();

	// 이 클래스의 겟터
	public DefaultTableModel getDtmAllClientModel() {
		return dtmAllClientModel;
	}

	public JTextArea getTaNoticeMsg() {
		return taNoticeMsg;
	}

	public DefaultTableModel getDtmChatClientModel() {
		return dtmChatClientModel;
	}

	// CenterRightPanel rp 의 겟터도 이 패널에서 접근할 수 있도록 다시 설정
	public JTextArea getTaChatMsg() {
		return this.rp.getTaChatMsg();
	}

	public JTextField getTfSendMsg() {
		return this.rp.getTfSendMsg();
	}

	public JButton getBtSend() {
		return this.rp.getBtSend();
	}

	public CenterPanel() {
		this.setLayout(new GridLayout(1, 4, 3, 0));

		// 테이블 헤더의 정보를 Vector 타입으로 저장
		strAllClientHeader.add("별칭");
		strAllClientHeader.add("IP");
		strAllClientHeader.add("접속시간");
		// 테이블의 정보를 입력 수정 삭제할 수 있는 모델 객체 생성
		dtmAllClientModel = new DefaultTableModel(strAllClientHeader, 0);
		// 모델 객체를 사용하여 JTable 객체를 생성
		this.tbAllClient = new JTable(dtmAllClientModel);
		// 테이블의 정보가 화면의 영역을 벗어나는 경우를 처리하기 위한 스크롤 팬 객체 생성
		JScrollPane sp1 = new JScrollPane(this.tbAllClient);

		this.add(sp1);

		// 공지메세지 패널을 따로 생성
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(lbNoticeMsg, BorderLayout.NORTH);
		panel.add(taNoticeMsg, BorderLayout.CENTER);

		this.add(panel);

		// 테이블 헤더의 정보를 Vector 타입으로 저장
		strChatClientHeader.add("별칭");
		strChatClientHeader.add("IP");
		strChatClientHeader.add("마지막 메세지");
		// 테이블의 정보를 입력 수정 삭제할 수 있는 모델 객체 생성
		dtmChatClientModel = new DefaultTableModel(strChatClientHeader, 0);
		// 모델 객체를 사용하여 JTable 객체를 생성
		this.tbChatClient = new JTable(dtmChatClientModel);
		// 테이블의 정보가 화면의 영역을 벗어나는 경우를 처리하기 위한 스크롤 팬 객체 생성
		JScrollPane sp2 = new JScrollPane(this.tbChatClient);

		this.add(sp2);

		this.add(rp);

	}
}
