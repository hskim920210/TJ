package tje.chat.client.net;

import java.net.*;

import tje.chat.client.ClientFrame;

import java.io.*;

public class ClientBinarySocket extends Thread {

	private ClientFrame frame;

	private File dir;
	private ServerSocket binarySocketServer;

	public ClientBinarySocket(ClientFrame frame) {
		this.frame = frame;

		try {
			this.binarySocketServer = new ServerSocket(50155);

			dir = new File("./save");
			if (!dir.exists())
				dir.mkdirs();

		} catch (IOException e) {
			this.binarySocketServer = null;
		}
	}

	public void run() {
		if (this.binarySocketServer == null)
			return;

		while (true) {
			try {
				Socket fileSocket = this.binarySocketServer.accept();

				// 파일 내용을 수신하기 위한 스트림
				ObjectInputStream in = 
						new ObjectInputStream(
								new BufferedInputStream(fileSocket.getInputStream()));
				
				String fileName = null;
				try {
					fileName = (String)in.readObject();
				} catch (ClassNotFoundException e) {					
					e.printStackTrace();
				}
				File file = new File(dir, fileName);				

				this.frame.addNoticeMessage(String.format("%s 파일의 수신을 시작합니다.", fileName));

				BufferedOutputStream out_file = new BufferedOutputStream(new FileOutputStream(file));

				byte[] buffer = new byte[1024];

				int size;
				while ((size = in.read(buffer)) != -1) {
					// System.out.println("CLIENT : " + size);
					out_file.write(buffer, 0, size);
					out_file.flush();
				}
				out_file.close();
				
				this.frame.addNoticeMessage(String.format("%s 파일 저장을 완료했습니다.", fileName));

				in.close();
				fileSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void close() {
		try {
			this.binarySocketServer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
