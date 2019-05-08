package tje.chat.client.net;

import java.net.*;

import tje.chat.client.ClientFrame;

import java.io.*;

// 파일을 전송받기 위한 바이트스트림 클래스
public class ClientBinarySocket extends Thread {

	private ClientFrame frame;

	// 파일 저장을 위한 디렉토리 지정
	private File dir;
	private ServerSocket binarySocketServer;

	// 파일 전송을 위한 새로운 포트로 서버 소켓 생성
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
		// 무한루프를 돌며 파일 전송을 기다린다.
		while (true) {
			try {
				// 서버쪽에서 클라이언트에 요청이 들어간다
				Socket fileSocket = this.binarySocketServer.accept();

				// 소켓이 연결되면 스트림 생성.
				// 파일 내용을 수신하기 위한 스트림 오브젝트스트림으로 한다.
				ObjectInputStream in = 
						new ObjectInputStream(
								new BufferedInputStream(fileSocket.getInputStream()));
				
				// 파일 이름 얻어오기
				String fileName = null;
				try {
					fileName = (String)in.readObject();
				} catch (ClassNotFoundException e) {					
					e.printStackTrace();
				}
				File file = new File(dir, fileName);				

				this.frame.addNoticeMessage(String.format("%s 파일의 수신을 시작합니다.", fileName));

				// 파일 내용을 출력
				BufferedOutputStream out_file = new BufferedOutputStream(new FileOutputStream(file));

				byte[] buffer = new byte[1024];

				int size;
				while ((size = in.read(buffer)) != -1) {
					// 네트워크에서 버퍼에 계속 읽어온다
					// System.out.println("CLIENT : " + size);
					out_file.write(buffer, 0, size);
					out_file.flush();
				}
				out_file.close();
				
				this.frame.addNoticeMessage(String.format("%s 파일 저장을 완료했습니다.", fileName));

				in.close();
				fileSocket.close();
			} catch (IOException e) {
				//e.printStackTrace();
				break;
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
