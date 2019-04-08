package tje.io;

import java.io.*;
import java.util.*;

// 객체 입출력을 위해서 사용되는
// ObjectInputStream, ObjectOutputStream 클래스
// 특정 객체 자체를 외부로 출력하거나 입력받을 수 있는 클래스
// ObjectInputStream, ObjectOutputStream 클래스를 사용하여
// 입출력 되는 클래스는 반드시 Serializable 인터페이스를 구현해야 한다.

public class IO_15 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		
		String dirPath = "D:\\dev\\java_se\\file_test";
		File dir = new File(dirPath);
		
		File file = new File(dir, "object_01.dat");
		
		ObjectOutputStream out =
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
		
		// 객체 자체를 출력할 수 있는 writeObject 메소드
		// Object 타입을 매개변수로 전달받아 
		// 해당 객체를 스트림을 통해 출력하는 기능을 제공
		out.writeObject(list);
		// flush를 호출하여 객체를 출력
		out.flush();
		// 스트림 종료
		out.close();
		
		System.out.println("프로그램 종료");
		
	}
}
