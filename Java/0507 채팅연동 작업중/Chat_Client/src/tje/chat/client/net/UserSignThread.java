package tje.chat.client.net;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JLabel;

import tje.chat.client.ClientFrame;
import tje.chat.client.ClientSignInDialog;
import tje.chat.common.ClientInfo;
import tje.chat.common.jdbc.model.User;

public class UserSignThread extends Thread {
	public static final int PORT = 50150;
	private User user;
	private Socket socket;
	private String ip;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ClientFrame frame ;
	
	public UserSignThread(User user, String ip, ClientFrame cf) {
		this.user = user;
		this.ip = ip;
		this.frame = cf;
	}
	
	public void run() {
		try {
			socket = new Socket(ip, PORT);
			oos = new ObjectOutputStream(
					new BufferedOutputStream(socket.getOutputStream()));
			oos.writeObject(user);
			oos.flush();
			ois = new ObjectInputStream(
					new BufferedInputStream(socket.getInputStream()));
			try {
				String result = (String)ois.readObject();
				this.frame.getSignDial().getResultSign().setText(result);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			oos.close();
			ois.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
