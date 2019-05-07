package tje.chat.common.util;

// JDBC 드라이버 클래스 로딩하고 예외처리하는 객체
public class JDBCDriverLoader {
	public static void init() {
		try {
			Class.forName(JDBCConstraints.JDBC_DRIVER);
			System.out.println("JDBC 드라이버 클래스 로딩 완료");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
