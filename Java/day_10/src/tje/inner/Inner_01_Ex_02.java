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

public class Inner_01_Ex_02 extends JFrame {
	
	private JTextField tfGuGuDan;

	private JButton btnGuGudan;
	private JLabel lbResult;
	

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public Inner_01_Ex_02(String title) {
		// 윈도우 프레임의 종료버튼 기능을 설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 윈도우 프레임의 제목을 설정
		this.setTitle(title);

		// 레이아웃을 설정
		this.setLayout(new FlowLayout());

		this.tfGuGuDan = new JTextField(5);

		this.btnGuGudan = new JButton("구구단 출력");
		
		this.lbResult = new JLabel();


		// 익명 클래스를 활용한 윈도우 이벤트 처리 방법
		// 이벤트 처리에 복잡한 코드가 포함되지 않는 경우
		// 아래와 같이 간단하게 이벤트를 처리할 수 있는 객체를
		// 생성하여 활용할 수 있습니다.
		// (익명 클래스는 외부의 클래스 모든 멤버에 제한없이
		// 접근할 수 있습니다.)
		// (private 멤버에도 접근이 가능)
		this.btnGuGudan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 클래스 안의 클래스는 바깥쪽 클래스의 필드를 바로 가져다 사용 가능하다.
				String output = "<html>";
				int dan = Integer.parseInt(tfGuGuDan.getText());
				for ( int i = 1 ; i <= 9 ; i++ )
					output += "<br>" + dan + " * " + i + " = " + (dan * i);
				
				output += "</html>";
			
				lbResult.setText(output);
				
//				int dan = Integer.parseInt(tfGuGuDan.getText());
//				for ( int i = 1 ; i <= 9 ; i++ ) {
//					lbResult.setText(dan + " * " + i + " = " + (dan*i));
//					System.out.println("");}
//			}
		}});

		this.add(tfGuGuDan);

		this.add(btnGuGudan);
		
		this.add(lbResult);

		// 윈도우 프레임의 크기를 설정
		this.setSize(1000, 300);
		// 윈도우 프레임을 화면에 출력
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Inner_01_Ex_02 ex = new Inner_01_Ex_02("인터페이스 예제");

	}

}
