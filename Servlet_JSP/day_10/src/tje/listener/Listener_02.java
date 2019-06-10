package tje.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;

//방문자 수를 저장 및 로드할 수 있는 리스너 객체
@WebListener
public class Listener_02 implements ServletContextListener {
	
	// 파일에 저장되어 있는 방문자 수를 읽어와
	// application 객체의 속성에 추가
	public void contextInitialized(ServletContextEvent sce)  {
		String strDirPath = sce.getServletContext().getInitParameter("save_dir");
		String strFilePath = sce.getServletContext().getInitParameter("save_file");
		
		File dir = new File(sce.getServletContext().getRealPath(strDirPath));
		if( !dir.exists() )
			dir.mkdirs();
		
		File file = new File(dir, strFilePath);
		
		try (BufferedReader in = 
				new BufferedReader(new FileReader(file))) {
			String line = null;
			Integer count = 0;
			if( (line = in.readLine()) != null )
				count = Integer.parseInt(line);
			
			sce.getServletContext().setAttribute("count", count);
			
		} catch ( Exception e ) {			
			e.printStackTrace();
		}
    }
	
	// 웹 서버가 종료될 때, application 객체에 저장되어 있는
	// 전체 방문자의 수를 파일에 저장
	public void contextDestroyed(ServletContextEvent sce)  {
		String strDirPath = sce.getServletContext().getInitParameter("save_dir");
		String strFilePath = sce.getServletContext().getInitParameter("save_file");
		
		File dir = new File(sce.getServletContext().getRealPath(strDirPath));
		if( !dir.exists() )
			dir.mkdirs();
		
		File file = new File(dir, strFilePath);
		
		try (PrintWriter out = 
				new PrintWriter(
						new BufferedWriter(
								new FileWriter(file)))) {
			int count = (Integer)sce.getServletContext().getAttribute("count");			
			out.printf("%d\n", count);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }	
	
}









