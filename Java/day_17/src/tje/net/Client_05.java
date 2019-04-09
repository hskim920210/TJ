package tje.net;

import java.io.*;
import java.net.*;

public class Client_05 {
	public static void main(String[] args) {
		String host = "localhost";
		int port = 7070;
		
		// 서버에 연결
		Socket socket = null;
		
		try {
			socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			return;
		} catch (IOException e) {
			System.out.println("서버와 연결에 실패했습니다.");
			return;
		}
		
		// 서버와 연결 성공 지점
		System.out.println("서버와 연결되었습니다.");
		
		// 데이터 송수신을 위한 스트림 생성
		// 주의사항
		// 반드시 입출력 스트림의 생성 순서는
		// 서버와 반대로 해야합니다.
		// 예를들어 서버에서 입력스트림을 먼저 생성하는 경우 
		// 클라이언트에서는 출력 스트림을 먼저 생성합니다.
		// 서버와 클라이언트 모두 입력스트림은 먼저 생성하는 경우
		// 무한 블럭킹 현상에 빠집니다.(객체 입출력인 경우 발생)
		BufferedReader socket_in = null;
		BufferedInputStream socket_byte_in = null;
		try {			
			socket_in = new BufferedReader(
							new InputStreamReader(
									socket.getInputStream()));	
			socket_byte_in = new BufferedInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("서버와의 스트림 생성 실패");
			try {
				socket.close();
			} catch (IOException e1) {
				System.out.println("소켓 종료과정에서 예외가 발생하였습니다.");
			}
			return;
		}		
		
		// 서버와 데이터를 주고받기 위한 준비가 완료
		
		String dirPath = "D:\\dev\\java_se\\tools_net_copy";
		File dir = new File(dirPath);
		
		if( !dir.exists() )
			dir.mkdirs();
		
		String fileName = null;
		try {
			fileName = socket_in.readLine();
		} catch (IOException e1) {
			System.out.println("파일명을 수신하는과정에서 문제가 발생");
		}
		
		File file = new File(dir, fileName);	
		
		BufferedOutputStream out_file = null;		
		try {
			out_file = new BufferedOutputStream(new FileOutputStream(file));
		} catch (FileNotFoundException e2) {
			System.out.println("파일을 찾을 수 없습니다.");
			return;
		}		
		
		byte [] data = new byte[1024];
		int size;
		try {
			while( (size = socket_byte_in.read(data)) != -1 ) {
				out_file.write(data, 0, size);
				out_file.flush();
			}
		} catch (IOException e1) {
			System.out.println("파일 데이터를 수신받는 과정에 예외가 발생");
		}
				
		try {		
			socket_in.close();
			out_file.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("소켓 종료과정에서 예외가 발생하였습니다.");
		}
	}
}
