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
		ArrayList<ClientInfo> info_list = ClientSaver.getInfo_list();

		ArrayList<Socket> out_socket = new ArrayList<>();
		ArrayList<ObjectOutputStream> out_oos = new ArrayList<>();
		for (int i = 0; i < info_list.size(); i++) {
			try {
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
				//System.out.println("SERVER : " + size);
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
