package tje.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tje.jdbc.*;

@WebListener
public class JDBCInfoLoader implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce)  { 
        ServletContext context = sce.getServletContext();
        // 웹 서버 구동 시, 데이터베이스 접속에 필요한 정보를 
        // 자바빈 객체로 생성
    	JDBCInfo info = new JDBCInfo(context.getInitParameter("JDBC_URL")
    			, context.getInitParameter("JDBC_USER")
    			, context.getInitParameter("JDBC_PASSWORD"));
    	// 생성된 자바빈 객체를 JDBC 커넥션을 제공하기 위한
    	// 클래스의 멤버로 설정
    	JDBCConnection.setInfo(info);
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	// TODO Auto-generated method stub
    }
}
