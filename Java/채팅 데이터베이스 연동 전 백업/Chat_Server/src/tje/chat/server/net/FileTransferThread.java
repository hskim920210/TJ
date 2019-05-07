package tje.chat.server.net;

import java.io.*;
import java.net.*;
import java.util.*;

import tje.chat.common.ClientInfo;

public class FileTransferThread extends Thread {

	public static final int PORT = 50155;
	private File file;

	public FileTransferThread(File file) {
		this.file = file;
	}

	public void run() {
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		System.out.println(file);
		// 여기서 좀 꼬인거임
		// 현재 접속중인 모든 클라이언트들을 받아온다.
		ArrayList<ClientInfo> info_list = ClientSaver.getInfo_list();
		// 파일마다 스트림을 만들어서 저장하는 배열을 생성
		ArrayList<Socket> out_socket = new ArrayList<>();
		// 문자열이랑 바이트 출력이 네트워크 버퍼에서 꼬여서 오브젝트스트림으로 했다.
		ArrayList<ObjectOutputStream> out_oos = new ArrayList<>();
		for (int i = 0; i < info_list.size(); i++) {
			try {
				// 소켓 만들고 바로 스트림 만들어서 배열에 저장, 송수신을 위한 포트로 소켓 만든다.
				out_socket.add(new Socket(info_list.get(i).getIp(), PORT));
				out_oos.add(
						new ObjectOutputStream(
							new BufferedOutputStream(out_socket.get(i).getOutputStream())));				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 모든 클라이언트에게 파일명 전송
		for (int i = 0; i < out_socket.size(); i++) {
			try {
				out_oos.get(i).writeObject(file.getName());
				out_oos.get(i).flush();
			} catch (IOException e) {
				e.printStackTrace();
			}				
		}

		byte[] buffer = new byte[1024];
		int size;
		try {
			while ((size = in.read(buffer)) != -1) {
				// System.out.println("SERVER : " + size);
				// 모든 클라이언트에게 읽어들인 파일의 일부분을 전송
				for (int i = 0; i < out_socket.size(); i++) {					
					out_oos.get(i).write(buffer, 0, size);
					out_oos.get(i).flush();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < out_socket.size(); i++) {
			try {
				out_oos.get(i).close();				
				out_socket.get(i).close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
