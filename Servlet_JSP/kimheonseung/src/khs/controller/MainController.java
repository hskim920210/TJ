package khs.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.command.*;

public class MainController extends HttpServlet {
private HashMap<String, Command> uriMap = new HashMap<>();
	
	public void init(ServletConfig config) throws ServletException {
		// URI와 각 URI가 요청될 때 실행할 서비스 클래스의 이름이 등록된 
		// 파일의 이름 및 실제 경로의 값을 추출
		String strConfigFile = config.getInitParameter("ConfigFile");
		String strConfigFilePath = config.getServletContext().getRealPath(strConfigFile);
		
		// 설정 정보를 저장하기 위한 Properties 객체 생성
		// Properties 클래스는 키=값 의 형태로 데이터를 저장하고 읽어올 수 있는 클래스
		Properties prop = new Properties();
		
		// 자동으로 close 불리게 되는 트라이캐치
		try (FileReader fr = new FileReader(strConfigFilePath)) {
			// =을 기준으로 키와 밸류를 자동으로 나눠줌
			prop.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 프로퍼티를 순회하는 방법
		Iterator<Object> keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String strServiceName = (String)keyIter.next();
			String strServiceClassName = prop.getProperty(strServiceName);
			
			// 이 부분은 외워야한다. 동적 객체 생성. 클래스 이름밖에 모를 때.
			try {
				// 클래스의 이름을 사용하여 해당 클래스 타입을 제어할 수 있는 객체를 생성하는 방법
				// 클래스 타입의 객체를 사용하여 임의의 타입의 객체를 생성할 수 있다.
				Class<?> commandClass = Class.forName(strServiceClassName);
				// 이 순간에 레퍼런스 변수로 객체가 생성
				// 서비스 타입의 객체를 생성
				Command service = (Command)commandClass.newInstance();
				// URI 정보와 해당 URI 요청 시 실행할 서비스 객체를 Map에 등록
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
		String requestURI = 
				request.getRequestURI().substring(
						request.getContextPath().length());
		
		String viewPage = null;
		Command command = null;
		
		if( (command = uriMap.get(requestURI)) != null )			
			viewPage = command.process(request, response);
		else
			response.sendError(404);
		
		if( viewPage != null )
			request.getRequestDispatcher(viewPage).forward(request, response);		
	}
}
