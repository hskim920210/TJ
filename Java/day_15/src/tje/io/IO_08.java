package tje.io;

import java.io.*;



public class IO_08 {
	public static void main(String[] args) throws IOException {
		// 파일처리
		// File 클래스
		// 파일 또는 디렉토리에 관련된 메타 정보를 제공하는 클래스
		// 파일을 생성, 디렉토리를 생성 등 추가적인 기능을 제공
		
		// 디렉토리의 경로를 저장
		// 주의사항 - \ 문자는 자바에서 특수문자를 정의하는 문자이므로
		// 		   \ 자체를 사용하기 위해서는 \\로 정의해야 한다. 
		
		// D:\dev\java_se\temp 디렉토리의 경로를 저장
		// File.separator : 각 운영체제마다 경로의 구분 문자가 다르므로 
		// 					File.Separator을 사용하여 디렉토리의 경로 구분문자를
		//					고정하지 않고 실제 실행중인 환경에 맞춰서 동작시킬 수 있다.
		String dirPath = "D:\\dev\\java_se" + File.separator + "temp";
		// System.out.println(dirPath);
		
		// D:\dev\java_se\temp 디렉토리를 참조하는 File 객체 생성
		// (File 객체는 디렉토리 또는 파일을 참조할 수 있다.)
		File dir = new File(dirPath);
		
		// File 객체가 참조하고 있는 대상의 존재 유무를 반환
		if( !dir.exists() )
			
			// 디렉토리를 생성하는 메소드
			// mkdir : 최종 타겟 이전의 경로가 존재해야만 동작
			// mkdirs : 최종 타겟 이전의 경로가 존재하지 않아도
			//          전체 경로를 생성
			dir.mkdirs();
		
		if( dir.exists() )
			System.out.println("temp 디렉토리 발견 ~ !");
		else
			System.out.println("temp 디렉토리가 없음 ... ");
		
		
		// D:\dev\java_se\temp\log.txt 파일을 참조하는 File 객체 생성
		
		// 전체 경로를 사용하는 경우의 객체 생성 코드
		// File file = new File("D:\\dev\\java_se\\temp\\log.txt");
		
		// 파일이 저장된 디렉토리를 참조하는 File 객체를 사용하여  객체를 생성하는 코드
		File file = new File(dir, "log.txt");
		
		if( !file.exists() )
			file.createNewFile();
		
		if( file.exists() )
			System.out.println("log.txt 파일 발견 ~ !");
		else
			System.out.println("log.txt 파일 없음 ... ");
		
		System.out.printf("파일명                      : %s\n", file.getName());
		System.out.printf("파일의 전체 경로        : %s\n", file.getAbsolutePath());
		System.out.printf("파일의 크기 (byte) : %d\n", file.length());
	}
}
