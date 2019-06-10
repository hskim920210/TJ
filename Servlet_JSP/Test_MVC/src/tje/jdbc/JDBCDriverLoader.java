package tje.jdbc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class JDBCDriverLoader extends HttpServlet {
	
	private static final String JDBC_DRIVER_CLASS = 
			"com.mysql.cj.jdbc.Driver";
	
    public JDBCDriverLoader() {
        try {
			Class.forName(JDBC_DRIVER_CLASS);
			System.out.println("JDBC Driver 클래스 로딩 완료");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
    }

}
