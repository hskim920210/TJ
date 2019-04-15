package Chatting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileListener implements ActionListener {

	JFileChooser chooser;

	// 파일 전송 버튼을 누르면 파일 추저가 나옴
	FileListener() {
		chooser = new JFileChooser();
	}

	public void actionPerformed(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);

		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// 추저에서 선택된 파일을 in에 읽어오기
		File selFile = chooser.getSelectedFile(); // .getPath();

		try {
			BufferedReader in = new BufferedReader(new FileReader(selFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// 읽어온 in을 input에 저장하여 ArrayList인 selectedFile에 한줄 한줄 저장
		// day_17 Server_05 참고
		String input;

	}
}
