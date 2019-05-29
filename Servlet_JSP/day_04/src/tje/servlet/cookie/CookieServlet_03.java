package tje.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie_04")
public class CookieServlet_03 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키
		// 클라이언트 (웹 브라우저)에 저장할 정보를 기록하는 방법을 제공
		// 키와 값의 형태로 데이터를 저장할 수 있다.
		
		// 쿠키의 사용 과정
		// # 서버에서 클라이언트로 쿠키를 저장하는 과정
		// 1. 서버에서 쿠키 객체를 생성
		// 2. 서버에서 생성된 쿠키 객체를 응답(response)에 추가하여
		//    클라이언트에게 전달
		// 3. 클라이언트는 서버로부터 전달받은 쿠키를 
		//    URL 정보와 함께 저장
		// # 클라이언트에서 서버로 쿠키를 전송하는 과정
		// 4. 클라이언트 (웹 브라우저)는 서버로 요청을 보낼 때
		//    현재 URL과 연관된 쿠키를 검색
		// 5. 쿠키가 존재한다면 쿠키를 요청(request)에 추가하여 전달
		// 6. 서버는 getCookies 메소드를 사용하여 클라이언트가 전달한
		//    쿠키의 배열을 반환받는다. (null 값이 반환될 수 있다.)
		// 7. 서버는 쿠키의 배열을 반복문을 활용하여 특정 name(키)의
		//    쿠키값을 전달받아 요청을 처리한다.
		
		// 쿠키의 삭제
		// setMaxAge 메소드의 매개변수 값을 0으로 지정하여
		// 클라이언트에서 특정 키값의 쿠키를 즉시 삭제하도록 제어
		
		Cookie cookie_600 = new Cookie("test_age_600", "600");
		cookie_600.setMaxAge(0);
		response.addCookie(cookie_600);
		
	}

}
