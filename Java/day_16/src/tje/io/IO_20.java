package tje.io;

import java.io.*;
import java.util.*;

// 객체 입출력을 위해서 사용되는
// ObjectInputStream, ObjectOutputStream 클래스
// 특정 객체 자체를 외부로 출력하거나 입력받을 수 있는 클래스
// ObjectInputStream, ObjectOutputStream 클래스를 사용하여
// 입출력 되는 클래스는 반드시 Serializable 인터페이스를 구현해야 한다.
// Serializable 인터페이스는 어떠한 추상메소드도 제공하지 않습니다.
// (선언만 필요)
public class IO_20 {
	public static void main(String[] args) throws Exception {
		
		String dirPath = "D:\\dev\\java_se\\file_test";
		File dir = new File(dirPath);
		
		File file = new File(dir, "object_03.dat");
		
		// 파일로부터 객체를 입력받을 수 있는 스트림 생성
		ObjectInputStream in =
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(file)));
		
		// 객체 자체를 입력받을 수 있는 readObject 메소드
		// Object 타입을 반환하기 때문에
		// 반드시 강제 형변환을 통해 객체를 대입받아야 한다.
		ArrayList<Point> list = (ArrayList<Point>) in.readObject();
		
		for( int i = 0 ; i < list.size() ; i++ )
			System.out.println(list.get(i));
		
		
		System.out.println("프로그램 종료");
		
	}
}
