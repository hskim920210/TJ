package tje.mvc.controller;

import java.io.*;
import java.lang.reflect.Constructor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tje.mvc.service.*;

import java.util.*;

public class ControllerServlet extends HttpServlet {	
	private HashMap<String, Service> uriMap = new HashMap<>();

	public void init(ServletConfig config) throws ServletException {
		String strConfigFile = config.getInitParameter("ConfigFile");
		String strConfigFilePath = config.getServletContext().getRealPath(strConfigFile);
		
		Properties prop = new Properties();
		try (FileReader fr = new FileReader(strConfigFilePath)) {
			prop.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Iterator<Object> keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String strServiceName = (String)keyIter.next();
			String strServiceClassName = prop.getProperty(strServiceName);
			
			try {				
				Class<?> serviceClass = 
						Class.forName(strServiceClassName);
				
				// 생성자 목록을 반환				
				Constructor [] constructors = 
						serviceClass.getConstructors();
				// 특정 생성자를 저장하기 위한 변수 
				Constructor cs = null;
				try {
					cs = serviceClass.getConstructor(ServletConfig.class);
				} catch(Exception e) {
					cs = null;
				}
				
				//System.out.println(serviceClass.getName());
				//System.out.println(constructors[0].getParameterCount());
				
				Service service = null;
				//if( constructors[0].getParameterCount() == 0 )
				if( cs == null )
					// 사실 지금 상으론 다 안하고 아래줄만 해주면 된다.
					service = (Service)serviceClass.newInstance();
				else {
					System.out.println(serviceClass.getName());
					System.out.println(cs.getParameterCount());
					System.out.println(cs.getParameters()[0].getType());
					
					// 동적으로 생성자의 매개변수를 전달하는 방법
					service = (Service)cs.newInstance(config);
					service = (Service)constructors[0].newInstance(config);
				}	
				
				// 또는 Service에 선언한 public void init(ServletConfig config) {};를
				// 각각의 Service에서 상속받아 아래의 메소드로 오버라이딩 하여
				// 원하는 변수를 초기화할 수 있다.
				// service.init(config);
				
				uriMap.put(strServiceName, service);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	

		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 클라이언트의 요청 URI를 추출하여 변수로 저장
		String requestURI = 
				request.getRequestURI().substring(
						request.getContextPath().length());
		
		String viewPage = null;
		Service service = null;
		
		if( (service = uriMap.get(requestURI)) != null )			
			viewPage = service.service(request, response);
		else
			response.sendError(404);
		
		if( viewPage != null )
			request.getRequestDispatcher(viewPage).forward(request, response);		
	}

}
