package tje.jdbc.util;

public class JDBCDriverLoader {
	public static void init() {
		try {
			Class.forName(JDBCConstraints.JDBC_DRIVER);
			System.out.println("JDBC 드라이버 클래스 로딩 완료");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
}
