package com.tje.webapp.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tje.webapp.model.*;
import com.tje.webapp.service.*;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberInsertService miService;
	@Autowired
	private MemberSearchByIDService msbIDService;
	@Autowired
	private MemberLoginService mlService;
	
	@GetMapping("/regist")
	public String registForm(@ModelAttribute(value = "member")Member member) {
		return "member/registForm";
	}
	
	@PostMapping("/regist")
	public String registSubmit(Member member, Model model) {
		if( (Member)msbIDService.service(member) != null ) {
			model.addAttribute("idExist", true);
			return "member/registForm";
		}
		
		if( (Boolean)miService.service(member) ) {
			model.addAttribute("regist_result", true);
		} else {
			model.addAttribute("regist_result", false);
		}
		
		return "member/registSubmit";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute(value = "member")Member member,
			@CookieValue(value = "idSave", required = false)Cookie idSaveCookie) {
		
		if( idSaveCookie != null ) {
			member.setIdSave(true);
			member.setMember_id(idSaveCookie.getValue());
		}
		
		return "member/loginForm";
	}
	
	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute(value = "member")Member member,
			HttpSession session, HttpServletResponse response, Model model) {
		Cookie cookie = new Cookie("idSave", member.getMember_id());
		
		Member searchedMember = (Member)msbIDService.service(member);
		
		if( searchedMember == null ) {
			model.addAttribute("isPass", false);
			model.addAttribute("loginError", "아이디가 존재하지 않습니다.");
			return "member/loginForm";
		}

		if( !(Boolean)mlService.service(member) ) {
			model.addAttribute("isPass", false);
			model.addAttribute("loginError", "비밀번호가 올바르지 않습니다.");
			return "member/loginForm";
		}
		
		session.setAttribute("loginMember", searchedMember);
		
		response.addCookie(cookie);
		
		try {
			response.sendRedirect("/webapp/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "home";
	}
}
