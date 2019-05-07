package tje.chat.server.panel;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.*;


public class CenterPanel extends JPanel {
	
	

	private JTextArea taLog = new JTextArea();
	// 체크가 된 상태의 체크박스 생성
	private JCheckBox cbLog = new JCheckBox("로그메세지 출력", true);

	// ta로 들어왔을때 감지.
	

	
	
	public CenterPanel() {
		this.setLayout(new BorderLayout());
		
		
		JScrollPane sp = new JScrollPane(taLog);
		this.add(sp, BorderLayout.CENTER);
		this.add(cbLog, BorderLayout.SOUTH);

	}

	// 외부에서 접근하기 위한 겟터를 생성
	public JTextArea getTaLog() {
		return taLog;
	}

	public JCheckBox getCbLog() {
		return cbLog;
	}
	
}
