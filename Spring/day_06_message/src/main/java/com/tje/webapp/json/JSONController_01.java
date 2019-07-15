package com.tje.webapp.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tje.webapp.repository.*;
import com.tje.webapp.service.MessageCountByReceiverService;
import com.tje.webapp.service.MessageSearchByReceiverService;
import com.tje.webapp.model.*;
import com.tje.webapp.setting.*;
import java.util.*;

import javax.servlet.http.HttpSession;

// @Controller
// @RestController 어노테이션
// - 현재 클래스의 모든 맵핑 메소드의 리턴값을 
//   응답으로 사용하는 경우에 적용하는 어노테이션
//   @ResponseBody 어노테이션을 쓰지 않아도 동작하게된다.
@RestController
public class JSONController_01 {
	@Autowired
	private MessageSearchByReceiverService msbrService;
	@Autowired
	private MessageCountByReceiverService mcbrService;
	@Autowired
	private PagingInfo pagingInfo;
	
	@GetMapping("/json/ex_01")
	// @ResponseBody
	public Member ex_01() {
		Member member = new Member("abc","def","TJE",false);
		return member;
	}
	
	@GetMapping("/json/ex_02")
	// @ResponseBody
	public ArrayList<Member> ex_02() {
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("abc","def","TJE1",false));
		list.add(new Member("qwe","der","TJE2",false));
		return list;
	}
	
	// 페이지 번호를 입력받아 해당 페이지의 받은 메세지를 JSON 포맷으로 반환하는
	// ex_03메소드를 작성
	
	@GetMapping("/json/ex_03/{pageNo}")
	public ArrayList<Message> ex_03(
			@PathVariable(value="pageNo", required = false)Integer page,
			HttpSession session) {
		
		if( page == null ) {
			return null;
		}
		
		Member loginMember = 
				(Member)session.getAttribute("loginMember");		
		HashMap<String, Object> args = 
				new HashMap<String, Object>();		
		
		args.put("curPageNo", page);		
		Message message = new Message();		
		message.setReceiver(loginMember.getMember_id());
		args.put("message", message);
		
		return (ArrayList<Message>)msbrService.service(args);
	}
	
}
