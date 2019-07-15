package com.tje.webapp.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tje.webapp.service.MemberInsertService;
import com.tje.webapp.service.MemberSearchByIDService;
import com.tje.webapp.service.MessageCountByReceiverService;
import com.tje.webapp.service.MessageSearchByReceiverService;
import com.tje.webapp.model.*;
import com.tje.webapp.setting.*;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class JSONController_02 {
	@Autowired
	private MemberInsertService miService;
	@Autowired
	private MemberSearchByIDService msbIDService;
	
	@GetMapping("/json/ex_04")
	public String ex_04() {
		return "/json/memberForm";
	}
	
	@PostMapping("/json/ex_05")
	@ResponseBody
	public Member ex_05(@RequestBody Member member) {
		System.out.printf("id = %s, password = %s, name = %s\n", member.getMember_id(),
				member.getPassword(), member.getName());
		return member;
	}
	
	
	// 회원가입 페이지로 이동하는 메소드
	@GetMapping("/json/ex_06")
	public String ex_06() {
		return "/json/registForm";
	}
	
	// 회원가입 정보를 AJAX로 전달받아
	// 성공, 실패 여부를 반환하는 메소드
	// 성공 : {"result" : "S"}
	// 실패 : {"result" : "F"}
	@PostMapping("/json/ex_07")
	@ResponseBody
	public String ex_07(@RequestBody Member m) {
		
		if( msbIDService.service(m) != null ) {
			return "{\"result\" : \"F\"}";
		}
		
		if( (Boolean)miService.service(m) )
			return "{\"result\" : \"S\"}";
		else
			return "{\"result\" : \"F\"}";
	}
}
