package com.personal.khs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.khs.model.*;
import com.personal.khs.service.*;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserIdCheckService uicService;
	@Autowired
	private UserInsertService uiService;
	
	
	@GetMapping("/regist")
	public String registForm() {
		return "user/regist/registForm";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public String idCheck(@RequestBody User user) {
		// uicService로 user객체가 반환되면 테이블에 해당 id인 user가 존재.
		// 반환된 user 객체가 null이면 가입이 가능
		System.out.println(user.getUser_id());
		if( uicService.service(user) != null ) {
			// 가입할 수 없는 ID
			System.out.println("가입 불가");
			return "{\"result\" : \"false\"}";
		} else {
			// 가입할 수 있는 ID
			System.out.println("가입 가능");
			return "{\"result\" : \"true\"}";
		}
		
	}
	
	@PostMapping("/regist")
	public String registSubmit(User user) {
		uiService.service(user);
		return "user/regist/registSubmit";
	}
}
