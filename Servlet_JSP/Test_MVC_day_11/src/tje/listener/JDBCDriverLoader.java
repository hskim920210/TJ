package tje.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class JDBCDriverLoader implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext context = sce.getServletContext();
		String strJDBCDriverName = context.getInitParameter("JDBC_DRIVER");
		
		try {
			Class.forName(strJDBCDriverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }
	
}
