package tje.jdbc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class JDBCDriverLoader extends HttpServlet {
	
	// 서버가 구동될 때 단 한번만 만들어지게 해서 실행되게 web.xml에 load on start up 사용
	private static final String JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
       
    public JDBCDriverLoader() {
        try {
			Class.forName(JDBC_DRIVER_CLASS);
			System.out.println("JDBC 드라이버 클래스 로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

}
