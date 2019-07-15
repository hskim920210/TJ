package com.tje.webapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tje.webapp.service.*;
import com.tje.webapp.model.*;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private MessageCountByReceiverService mcbrService;
	@Autowired
	private MessageCountBySenderService mcbsService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		// 로그인 상태 체크
		if( session.getAttribute("loginMember") != null ) {
			Member member = (Member)session.getAttribute("loginMember");
			Message message = new Message();
			message.setSender(member.getMember_id());
			message.setReceiver(member.getMember_id());
			
			HashMap<String, Integer> result = (HashMap<String, Integer>)mcbsService.service(message);
			model.addAttribute("s_count", result.get("totalCount"));
				
			result = (HashMap<String, Integer>)mcbrService.service(message);
			model.addAttribute("r_count", result.get("totalCount"));
		}
		
		return "main";
	}
	
}
