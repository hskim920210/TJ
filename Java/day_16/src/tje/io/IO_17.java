package tje.io;

import java.io.*;
import java.util.*;

// 객체 입출력을 위해서 사용되는 
// ObjectInputStream, ObjectOutputStream 클래스
// 특정 객체 자체를 외부로 출력하거나 입력받을 수 있는 클래스
// ObjectInputStream, ObjectOutputStream 클래스를 사용하여
// 입출력되는 클래스는 반드시 Serializable 인터페이스를 구현해야합니다.

// 사용자 정의 클래스를 외부로 입출력하는 예제
// Serializable 인터페이스는 어떠한 추상메소드도 제공하지 않는다. (선언만 필요)
class MyClass implements Serializable{
	String name;
}

public class IO_17 {
	public static void main(String[] args) throws Exception {
		
		MyClass obj = new MyClass();
		obj.name = "ABC";
		
		String dirPath = "D:\\dev\\java_se\\file_test";
		File dir = new File(dirPath);
		
		File file = new File(dir, "object_02.dat");
		
		ObjectOutputStream out = 
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
		
		// 객체 자체를 출력할 수 있는 writeObject 메소드
		// Object 타입을 매개변수로 전달받아
		// 해당 객체를 스트림을 통해서 출력하는 기능을 제공
		out.writeObject(obj);
		// flush를 호출하여 객체를 출력
		out.flush();
		// 스트림 종료
		out.close();
		
		System.out.println("프로그램 종료");
		
	}
}









