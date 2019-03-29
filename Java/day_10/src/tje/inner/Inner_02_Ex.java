package tje.inner;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

// 사용자에게 정수값 하나를 입력받을 수 있는 UI 화면을 구현하세요.
// JButton을 활용하여 클릭 이벤트가 발생하는 경우
// JTextField 타입에 입력된 정수를 이용하여 구구단을 화면에 출력하세요.(JLabel 활용)

// 구구단 출력을 위한 이벤트 처리 클래스의 선언
//class GuGudanBtnHandlerOut extends MouseAdapter {
//	public void mouseClicked(MouseEvent e) {
//		// 이벤트 처리를 위한 클래스의 객체는
//		// 이벤트가 발생된 윈도우의 각 UI 요소에 
//		// 접근할 수 있어야 한다.
//		// 이러한 클래스를 중첩클래스가 아닌 
//		// 일반 클래스로 정의하는 경우
//		// 윈도우 클래스의 각 요소에 접근이 불가능하다.
//		int dan = Integer.parseInt(tfGuGuDan.getText());
//		for ( int i = 1 ; i <= 9 ; i++ )
//			output += "<br>" + dan + " * " + i + " = " + (dan * i);
//		
//		output += "</html>";
//	
//		lbResult.setText(output);
//	}
//}

public class Inner_02_Ex extends JFrame {

	private JTextField tfGuGuDan;
	private JButton btnGuGudan;
	private JLabel lbResult;

	class GuGudanBtnHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			// 중첩된 클래스를 활용하여 이벤트 처리를 처리하는 예제
			// 윈도우 클래스의 내부 클래스로 정의되었기 때문에
			// 모든 UI 구성요소에 자유롭게 접근할 수 있다.
			String output = "<html>";
			int dan = Integer.parseInt(tfGuGuDan.getText());
			for (int i = 1; i <= 9; i++)
				output += "<br>" + dan + " * " + i + " = " + (dan * i);

			output += "</html>";

			lbResult.setText(output);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public Inner_02_Ex(String title) {
		// 윈도우 프레임의 종료버튼 기능을 설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 윈도우 프레임의 제목을 설정
		this.setTitle(title);

		// 레이아웃을 설정
		this.setLayout(new FlowLayout());

		this.tfGuGuDan = new JTextField(5);
		this.btnGuGudan = new JButton("구구단 출력");
		this.lbResult = new JLabel();
		// 중첩된 내부 클래스의 객체를 사용하여 이벤트를 처리하는 예제
		this.btnGuGudan.addMouseListener(new GuGudanBtnHandler());

		this.add(tfGuGuDan);
		this.add(btnGuGudan);
		this.add(lbResult);

		// 윈도우 프레임의 크기를 설정
		this.setSize(1000, 300);
		// 윈도우 프레임을 화면에 출력
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Inner_02_Ex ex = new Inner_02_Ex("인터페이스 예제");
	}

}
