package tje.jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class JDBCDriverLoader extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {		
		String driverClassName = config.getServletContext().getInitParameter("JDBC_DIRVER_CLASS_NAME");
		
		try {
			Class.forName(driverClassName);
			System.out.println("드라이버 클래스 로딩 성공");
			
			JDBCInfo info = new JDBCInfo(
					config.getServletContext().getInitParameter("JDBC_URL"), 
					config.getServletContext().getInitParameter("JDBC_USER"), 
					config.getServletContext().getInitParameter("JDBC_PASSWORD"));
			
			config.getServletContext().setAttribute("jdbc_info", info);
		} catch (ClassNotFoundException e) {			
			System.out.println("드라이버 클래스 로딩 실패");
		}
	}

}





