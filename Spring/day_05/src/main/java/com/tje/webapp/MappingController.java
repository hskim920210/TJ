package com.tje.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappingController {
	// 클라이언트의 요청을 처리하기 위한 메소드의 선언
	// - 요청 URL의 정의
	// - @RequestMapping : 요청 메소드에 관계없이 요텅을 처리할 수 있는 메소드의 선언부에 정의하는 어노테이션
	// - @GetMapping : Get 방식의 요청을 처리할 수 있는 메소드의 선언부에 정의하는 어노테이션
	// - @PostMapping : Post 방식의 요청을 처리할 수 있는 메소드의 선언부에 정의하는 어노테이션
	
	// /request_1 의 요청이 GET 방식으로 전달될 경우 실행 될 메소드를 정의하는 @RequestMapping 어노테이션
	@RequestMapping(method=RequestMethod.GET, value = "/request_1")
	public void request_1() {
		System.out.println("request_1 메소드 실행");
	}
	
	// /request_2 의 요청이 GET방식으로 전달되는 경우 실행될 메소드를 정의하는 @GetMapping 어노테이션
	@GetMapping(value = "request_2")
	public void request_2() {
		System.out.println("request_2 메소드 실행");
	}
	
	// /request_3 의 요청이 POST 방식으로 전달될 경우 실행될 메소드를 정의하는 @PostMapping 어노테잉션
	// @RequestMapping(method=RequestMethod.POST, value = "/request_3") 와 같은 의미
	// @PostMapping은 스프링 프레임워크 <org.springframework-version>4.3.11.RELEASE</org.springframework-version>를 해줘야(pom.xml)
	@PostMapping(value = "/request_3")
	public void request_3() {
		System.out.println("request_3 메소드 실행");
	}
}
