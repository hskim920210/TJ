package tje.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 리스너
// 웹 어플리케이션에서 이벤트를 처리할 수 있는 구성요소
// 웹 서버의 시작/종료 시점에 처리할 내용 
// 또는 세션 내부의 속성값의 추가 및 변경 삭제 시
// 동작할 코드를 정의할 수 있는 구성요소

// 리스너를 사용하여 웹 서버의 시작/종료 시
// 처리할 작업을 정의하기 위해서 ServletContextListener 인터페이스를
// 구현할 수 있습니다.

// 웹 서버(서블릿 컨테이너)는 웹 서버가 구동할 때 
// ServletContextListener를 구현한 리스너 객체의
// contextInitialized 메소드를 자동으로 호출하고,
// 웹 서버가 종료될 떄, contextDestroyed 메소드를 호출합니다.

// 웹 서버에 의해서 리스너를 동작시키기 위해
// web.xml 파일 내부에 listener 태그를 사용하여
// 리스너 클래스를 등록해야 합니다.
//(@WebListener 어노테이션을 사용할 수 있음)
public class Listener_01 implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce)  {    	
    	System.out.println("서버 시작");
    }
    
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("서버 종료");
    }    
	
}




