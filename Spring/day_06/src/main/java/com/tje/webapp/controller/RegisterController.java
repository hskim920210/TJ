package com.tje.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tje.webapp.model.*;
import com.tje.webapp.services.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private MemberRegisterService mrService;
	
	@GetMapping("/step1")
	public String step1() {
		System.out.println("step1");
		return "register/step1";
	}
	
	@PostMapping("/step2")
	public String step2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		System.out.println("step2");
		if(!agree) {
			return "register/step1";
		}
		return "register/step2";
	}
	
	@GetMapping("/step2")
	public String step2Get(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		System.out.println("step2Get");
		return "redirect:/register/step1";
	}
	
	// 커맨드 객체를 전달받는 메소드의 선언.
	// 요청 객체의 파라메터 정보를 사용하여 
	// 클래스의 객체를 생성한 후, 전달되는 객체
	@PostMapping("/step3")
	public String step3(Model model, RegisterRequest regReq) {
		try {
			model.addAttribute("insertedKey", mrService.service(regReq));
			return "register/step3";
		} catch (Exception e) {
			return "register/step2";
		}
	}
	
	
	
}
