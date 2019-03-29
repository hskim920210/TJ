package tje.inner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Inner_01_Ex_01 extends JFrame {
	
	private JTextField tfN1;
	private JTextField tfN2;
	private JLabel lbResult;
	private JButton btnPlus;

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public Inner_01_Ex_01(String title) {
		// 윈도우 프레임의 종료버튼 기능을 설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 윈도우 프레임의 제목을 설정
		this.setTitle(title);

		// 레이아웃을 설정
		this.setLayout(new FlowLayout());

		this.tfN1 = new JTextField(10);
		this.tfN2 = new JTextField(10);
		this.lbResult = new JLabel();

		this.btnPlus = new JButton("더하기");

		this.lbResult.setEnabled(false);

		// 익명 클래스를 활용한 윈도우 이벤트 처리 방법
		// 이벤트 처리에 복잡한 코드가 포함되지 않는 경우
		// 아래와 같이 간단하게 이벤트를 처리할 수 있는 객체를
		// 생성하여 활용할 수 있습니다.
		// (익명 클래스는 외부의 클래스 모든 멤버에 제한없이
		// 접근할 수 있습니다.)
		// (private 멤버에도 접근이 가능)
		this.btnPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 클래스 안의 클래스는 바깥쪽 클래스의 필드를 바로 가져다 사용 가능하다.
				String strN1;
				String strN2;
				int nN1 = Integer.parseInt(tfN1.getText());
				int nN2 = Integer.parseInt(tfN2.getText());
				lbResult.setText(nN1 + nN2 + "");
			}
		});

		this.add(tfN1);
		this.add(tfN2);
		this.add(lbResult);
		this.add(btnPlus);

		// 윈도우 프레임의 크기를 설정
		this.setSize(1000, 300);
		// 윈도우 프레임을 화면에 출력
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Inner_01_Ex_01 ex = new Inner_01_Ex_01("인터페이스 예제");

	}

}
