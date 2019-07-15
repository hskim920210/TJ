package com.tje.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tje.webapp.model.*;
import com.tje.webapp.service.*;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberSearchByIDService msbIDService;
	@Autowired
	private MemberInsertService miService;
	@Autowired
	private MemberLoginService mlService;
	
	@GetMapping("/insert")
	public String insertForm(Member member) {
		return "member/insertForm";
	}
	
	@PostMapping("/insert")
	public String insertSubmit(Member member, Model model) {
		if( msbIDService.service(member) != null ) {
			return "member/insertForm";
		}
		
		if( (Boolean)miService.service(member) ) {
			model.addAttribute("insert_result", true);
		} else {
			model.addAttribute("insert_result", false);
		}
		
		return "member/insertSubmit";
	}
	
	@GetMapping("/login")
	public String loginForm(@CookieValue(value="rememberID", required = false)Cookie rememberIDCookie, @ModelAttribute("member")Member member) {
		
		if( rememberIDCookie != null ) {
			member.setMember_id(rememberIDCookie.getValue());
			member.setRememberID(true);
		}
		
		return "member/loginForm";
	}
	
	// 스프링에서 매개변수로 세션을 넘기면 세션이 무조건 생성이 된다. (있으면 가져다 쓴다.)
	// 필요할때만 만들고자 하면 request객체를 매개변수로 가져와서 세션을 만든다.
	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute("member")Member member, Model model, HttpSession session, HttpServletResponse response) {
		
		Member target = null;
		if( (target = (Member)msbIDService.service(member)) == null ) { 
			model.addAttribute("isLogin", false);
			// target은 테이블에서 가져온 멤버, member는 로그인 입력폼에서 아이디와 패스워드만 가진 멤버
			return "member/loginForm";
		}
		// 로그인 정보만 가진 객체에 이름 값을 추가
		member.setName(target.getName());
		
		ArrayList<Member> args = new ArrayList<Member>();
		args.add(member);
		args.add(target);
		boolean isLogin = (Boolean)mlService.service(args);
		model.addAttribute("login_result", isLogin);
		
		if( isLogin ) {
			session.setAttribute("loginMember", target); // 로그인 성공
		}
		Cookie cookie = new Cookie("rememberID", member.getMember_id());
		if( !member.isRememberID() ) {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		
		return "member/loginSubmit";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		model.addAttribute("member", session.getAttribute("loginMember"));
		session.removeAttribute("loginMember");
		return "member/logout";
	}
	
}
