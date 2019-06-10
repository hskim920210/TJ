package tje.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tje.jdbc.JDBCInfo;

// JDBC 드라이버 클래스를 로딩하는 리스너 클래스의 선언
@WebListener
public class JDBCDriverListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	String driverClassName = sce.getServletContext().getInitParameter("JDBC_DIRVER_CLASS_NAME");
    	
    	try {
			Class.forName(driverClassName);
			System.out.println("드라이버 클래스 로딩 성공");
			
			JDBCInfo info = new JDBCInfo(
					sce.getServletContext().getInitParameter("JDBC_URL"), 
					sce.getServletContext().getInitParameter("JDBC_USER"), 
					sce.getServletContext().getInitParameter("JDBC_PASSWORD"));
			
			sce.getServletContext().setAttribute("jdbc_info", info);
		} catch (ClassNotFoundException e) {			
			System.out.println("드라이버 클래스 로딩 실패");
		}
    }
	
}
