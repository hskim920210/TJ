package tje.abstract_;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

class MouseHanddler extends MouseAdapter {
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭 감지~!");
	}
}

class WindowFrame extends JFrame {
	public WindowFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("윈도우 타이틀");
		this.setSize(300, 200);

		this.addMouseListener(new MouseHanddler());

		this.setVisible(true);
	}
}

public class Abstract_Ex {

	public static void main(String[] args) {
		WindowFrame frame = new WindowFrame();
	}

}
