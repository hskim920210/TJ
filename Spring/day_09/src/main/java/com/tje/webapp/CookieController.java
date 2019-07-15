package com.tje.webapp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tje.webapp.model.*;

@Controller
@RequestMapping("/login")
public class CookieController {
	@GetMapping
	public String form(@ModelAttribute("member")Member member,
			@CookieValue(value="rememberID", required = false)Cookie rememberIDCookie) {

		if( rememberIDCookie != null ) {
			member.setId(rememberIDCookie.getValue());
			member.setRememberID(true);
		}
		return "loginForm";
	}

	@PostMapping
	// 쿠키 객체를 위해 response 객체가 필요
	public String submit(@ModelAttribute("member")Member member, HttpServletResponse response) {
		Cookie cookie = new Cookie("rememberID", member.getId());
		
		// 체크하지 않았다면
		if( !member.isRememberID() ) {
			// 쿠키를 보내자마자 없애버리겠다.
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		
		return "loginSubmit";
	}

}
