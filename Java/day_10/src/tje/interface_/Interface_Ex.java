package tje.interface_;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

class MouseHandler implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

}

// 윈도우 프로그램을 구현하기 위한 JFrame 클래스의 상속
// JFrame 클래스를 상속받는 클래스는 윈도우 프레임에 관련된
// 기능들을 활용할 수 있다.
// (제목, 크기, ...)
public class Interface_Ex extends JFrame implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

	private JButton btn;

	public Interface_Ex(String title) {
		// 윈도우 프레임의 종료버튼 기능을 설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 윈도우 프레임의 제목을 설정
		this.setTitle(title);

		// 레이아웃을 설정
		this.setLayout(new FlowLayout());

		// 버튼 객체를 생성
		this.btn = new JButton("클릭하세요~!");
		this.btn.setSize(100, 100);
		// 버튼 객체를 윈도우 컨테이너에 등록
		this.add(btn);

		// 버튼 객체에 대한 마우스 이벤트를 처리할 수 있는
		// 객체를 등록
		// this.btn.addMouseListener(new MouseHandler());
		this.btn.addMouseListener(this); // this : 현재 이 메소드를 실행하고 있는 객체

		// 윈도우 프레임의 크기를 설정
		this.setSize(300, 300);
		// 윈도우 프레임을 화면에 출력
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Interface_Ex ex = new Interface_Ex("인터페이스 예제");

	}

}
