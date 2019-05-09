package tje.chat.server.panel;

import java.awt.BorderLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CenterPanel extends JPanel {
	
	private JTextArea taLog = new JTextArea();
	private JCheckBox cbLog = new JCheckBox("로그 메세지 출력", true);
	
	public CenterPanel() {
		this.setLayout(new BorderLayout());
		
		JScrollPane sp = new JScrollPane(taLog);
		this.add(sp, BorderLayout.CENTER);
		
		this.add(cbLog, BorderLayout.SOUTH);
	}

	public JTextArea getTaLog() {
		return taLog;
	}

	public JCheckBox getCbLog() {
		return cbLog;
	}

}














