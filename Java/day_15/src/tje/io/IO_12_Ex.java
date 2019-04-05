package tje.io;

import java.io.*;

public class IO_12_Ex {
	public static void main(String[] args) throws Exception {
		// tools 디렉토리의 이클립스 압축파일을
		// tools_copy 디렉토리로 복사하기.
		
		String dir_source_Path = "D:\\dev\\java_se\\tools";
		String dir_target_Path = "D:\\dev\\java_se\\tools_copy";
		
		File dirSource = new File(dir_source_Path);
		File dirTarget = new File(dir_target_Path);
		
		if( !dirTarget.exists() )
			dirTarget.mkdirs();
		
		File fileSource = new File(dirSource, "eclipse-java-2018-12-R-win32-x86_64.zip");
		File fileTarget = new File(dirTarget, fileSource.getName());
		
		BufferedInputStream bis =
				new BufferedInputStream(
						new FileInputStream(fileSource));
		
		BufferedOutputStream bos =
				new BufferedOutputStream(
						new FileOutputStream(fileTarget));
		
		// 아래와 같이 하면 느리다
//		int data;1
//		long startTime = System.nanoTime();
//		while( (data = bis.read()) != -1 )
//			bos.write(data);
//		long endTime = System.nanoTime();
		
		// 아래와 같이 하면 배열을 사용하여 더 빠르다.
		int size;
		byte [] data = new byte[2048];
		long startTime = System.nanoTime();
		while( (size = bis.read(data)) != -1 ) {
			System.out.println(size);
			bos.write(data, 0, size);
			bos.flush(); // 버퍼 공간이 무한대가 아니라 반드시 flush로 내보내야 유실이 없다.
		}
		long endTime = System.nanoTime();
		
		
//		// 파일 크기만큼 배열을 만들어 인트타입으로 메모리에 올림
//		// 추천하는 방법은 아님.
//		int size;
//		long startTime = System.nanoTime();
//		byte [] data = new byte[(int) fileSource.length()];
//		bis.read(data);
//		bos.write(data);
//		long endTime = System.nanoTime();
		
		
		
		System.out.printf("파일 복사 완료 : (%d ns)\n", endTime-startTime);
		System.out.printf("원본 파일 크기 : %d bytes\n", fileSource.length());
		System.out.printf("복사 파일 크기 : %d bytes\n", fileTarget.length());
		bos.close();
		
		bis.close();
		
		
		
		
		
		
		
		
		
		// 나의 시도
//		String dirOri = "D:\\dev\\java_se\\tools";
//		
//		File Ori = new File(dirOri, "eclipse-java-2018-12-R-win32-x86_64.zip");
//		
//		BufferedInputStream fis = 
//				new BufferedInputStream(
//						new FileInputStream(Ori));
//		
////		BufferedOutputStream bos =
////				new BufferedOutputStream(
////						new FileOutputStream(Ori));
//				
//	
//		if( Ori.exists() ) {
//			System.out.println("파일이 존재합니다. 복사를 시작합니다.");
//			
//		
//		}
//		else
//			System.out.println("파일이 존재하지 않습니다.");
//
//		
//		String dirPath = "D:\\dev\\java_se\\tools_copy";
//		
//		File dirCp = new File(dirPath);
//		
//		if( !dirCp.exists() )
//			dirCp.mkdirs();
//		
//		
//		BufferedOutputStream bos =
//				new BufferedOutputStream(
//						new FileOutputStream(Ori));
		
		
		
		
		
	}
}