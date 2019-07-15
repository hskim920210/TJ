package com.tje.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tje.webapp.model.*;
import java.util.*;

@Controller
public class ModelAttrController {
	@GetMapping("/model_attr_1")
	public String model_attr_1(Member member) {
		return "model_attr_1";
	}
	
	@GetMapping("/model_attr_2")
	public String model_attr_2(@ModelAttribute("m") Member member) {
		return "model_attr_2";
	}
	
	@GetMapping("/model_attr_3")
	public String model_attr_3_get(@ModelAttribute("m") Member member) {
		return "model_attr_3";
	}
	
	@PostMapping("/model_attr_3")
	public String model_attr_3_post(@ModelAttribute("m") Member member) {
		return "model_attr_3";
	}
	
	@GetMapping("/model_attr_4")
	public String model_attr_4_get(@ModelAttribute("m") Member member) {
		return "model_attr_4";
	}
	
//	@GetMapping("/login")
//	public String form(Model model) {
//		List<String> loginTypes = new ArrayList<>();
//		loginTypes.add("일반회원");
//		loginTypes.add("기업회원");
//		loginTypes.add("헤드헌터회원");
//		model.addAttribute("loginTypes", loginTypes);
//		System.out.println("리스트 저장완료");
//		return "login/form";
//	}
	
	@GetMapping("/register")
	public String step1() {
		return "register/step1";
	}
}
