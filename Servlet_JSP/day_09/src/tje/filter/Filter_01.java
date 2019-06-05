package tje.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


// Filter
// 클라이언트의 요청 및 응답에 대해서 추가적인 작업을 진행하는 경우
// 공통된 로직을 분리할 수 있는 방법을 제공해주는 기능
// - 클라이언트의 요청에 대해서 사전작업을 진행할 수 있다.
//	 (요청 객체의 인코딩 작업)
// - 클라이언트에게 전달하는 응답에 대해서 추가적인 작업을 진행할 수 있다.
// 	 (쿠키의 전송 등)

// 필터는 웹 서버로 전달되는 URL 패턴에 따라 동작을 제어할 수 있다.
// 아래의 필터는 웹 서버로 /fs_01 요청이 전달된 경우에만 실행되는 필터
// 만약 모든 요청에 대해서 동작할 필터를 선언하는 경우 /* 로 정의한다.
@WebFilter("/fs_01")
public class Filter_01 implements Filter {
	
	// 필터의 동작
	// 1. 웹 서버가 구동되면서 생성자가 호출
	// 2. 생성된 필터 객체의 init 메소드 실행
	// 3. 필터에 지정된 URL 요청이 전달될 때,
	// 	  doFilter 메소드가 호출
	// 4. doFilter 메소드의 실행코드인 chain.doFilter(request, response);
	//    에 의해서 다음 필터 또는 실제 요청 대상인 서블릿 또는 JSP가 실행
	// 5. 4번에 의해서 호출된 필터 또는 서블릿, JSP의 실행이 종료된 후,
	//    chain.doFilter(request, response); 이후의 코드가 실행된다.
	// 6. URL 요청이 들어올 때마다 3 ~ 5 번 까지의 내용이 반복
	// 7. 웹 서버의 종료 시, destroy() 메소드가 실행되어 종료 처리를 한다.
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter_01의 init 메소드 실행");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter_01의 doFilter 메소드 실행(BEFORE)");
		chain.doFilter(request, response);
		System.out.println("Filter_01의 doFilter 메소드 실행(AFTER)");
	}
	
	public void destroy() {
		System.out.println("Filter_01의 destroy 메소드 실행");
	}
}
