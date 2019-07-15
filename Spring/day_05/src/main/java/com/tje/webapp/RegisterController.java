package com.tje.webapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tje.webapp.model.*;

@Controller
public class RegisterController {
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	
	// @RequestMapping 어노테이션은 메소드가 지정되지 않은경우 
	// 정의된 url 요청을 메소드와 관계없이 실행한다.
	// @RequestMapping(value = "/register/step2", method = RequestMethod.POST)
	@RequestMapping
	// 요청 파라메터 추출을 위한 처리
	// 1. HttpServletRequest 객체를 통해 처리(일반적으로 잘 쓰지 않는다)
	// - 메소드의 매개변수로 HttpServletRequest 객체를 선언하면
	//   Dispatcher 서블릿을 통해 실행될 때, 값을 전달받을 수 있다.

//	public String handleStep2(HttpServletRequest request) {
//		// 약관 동의 여부에 대한 파라메터 정보를 추출
////		boolean agree = false;
////		if (request.getParameter("agree") != null) {
////			agree = true;
////		}
//		Boolean agree = request.getParameter("agree") != null;
//		System.out.println(agree);
//		return "register/step2";
//	}
	
	// 2. @RequestParam 어노테이션을 사용하여 파라메터 정보를 변수에 직접 할당(형변환 과정이 필요 없다)
//	public String handleStep2(
//		@RequestParam(value="name") String name,
//		@RequestParam(value="age") int age, 
//		@RequestParam(value="agree", defaultValue = "false") boolean agree) {
//		
//		System.out.printf("이름 : %s\n", name);
//		System.out.printf("나이 : %d\n", age);
//		System.out.printf("동의여부 : %b\n", agree);
//		
//		return "register/step2";
//	}
	
	// 3. 커맨드 객체를 사용한 파라메터 정보 추출
	//    메소드 매개변수로 model 객체를 넣어줬을 때 jsp에서 넘어온 parameter name와
	//    model 객체의 필드명(+타입)이 같은거는
	//    알아서 setter로 set해준다.
	// 이걸 커맨드객체라 부른다. 이건 알아서 ModelAndView 영역에 저장해놓음
	// - 요청 파라메터의 name 값과 매개변수로 지정된 클래스의 멤버필드명이 동일한 경우
	//   해당 객체를 생성하여 멤버필드로 값을 설정하여 반환하는 기능
	// - 커맨드 객체는 Model 객체로 추가되어 JSP와 같은 페이지에서 
	//   별도의 설정 없이 사용할 수 있다.
	public String handleStep2(Member member) {
		
		System.out.printf("이름 : %s\n", member.getName());
		System.out.printf("나이 : %d\n", member.getAge());
		System.out.printf("동의여부 : %b\n", member.isAgree());
		
		return "register/step2";
	}
}